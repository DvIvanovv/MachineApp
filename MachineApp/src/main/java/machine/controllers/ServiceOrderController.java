package machine.controllers;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import machine.dto.WarrantyDto;
import machine.data.entities.Consumable;
import machine.dto.ServiceOrderDto;
import machine.services.RgisterWarrantyService;
import machine.services.UserService;
import machine.services.impl.ServiceOrderServiceImpl;
	
	
@Controller
@RequestMapping("/serviceOrder")
public class ServiceOrderController {
	
	private ServiceOrderServiceImpl serviceOrderService;
	private RgisterWarrantyService warrantyService;
	private UserService  userService;
	
	@Autowired
	public ServiceOrderController( ServiceOrderServiceImpl serviceOrderService, RgisterWarrantyService warrantyService,
			UserService  userService) {
		super();
		this.serviceOrderService = serviceOrderService;
		this.warrantyService = warrantyService;
		this.userService = userService;
	}


	@GetMapping("/add")
	public String getServiceOrderForm(Model model) {
		model.addAttribute("serviceOrder", new ServiceOrderDto());
		
		return "addServiceOrder";
	}
	@PostMapping("/next")
	public ModelAndView chooseConsumablesForServiceOrder(@Valid @ModelAttribute("serviceOrder") ServiceOrderDto serviceOrder,
			BindingResult bindingResult, HttpServletRequest request, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("serviceOrder", serviceOrder);
			modelAndView.setViewName("addServiceOrder");
			return modelAndView;
		}
		Principal principal = request.getUserPrincipal();
		serviceOrder.setUser(this.userService.findByUsername(principal.getName()));
		serviceOrder.setWarranty(this.warrantyService.findBySerialNumber(serviceOrder.getForMachine()));
		List<Consumable> consumables = serviceOrder.getWarranty().getMachine().getConsumables();
		modelAndView.addObject("serviceOrder", serviceOrder);
		modelAndView.addObject("allConsumables", consumables);
		modelAndView.setViewName("chooseConsumables");
		return modelAndView;
	}
	@PostMapping("/add")
	public String registerServiceOrder(@Valid @ModelAttribute("serviceOrder") ServiceOrderDto serviceOrder,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("serviceOrder", serviceOrder);
			return "addServiceOrder";
		}
		try {
			serviceOrderService.addServiceOrder(serviceOrder);	
		} catch( IllegalArgumentException e) {
			bindingResult.rejectValue("serviceDate","404", e.getMessage());
			model.addAttribute("serviceDate", serviceOrder);
			return "addServiceOrder";
		}
		return "redirect:/serviceOrder/my";
	}
	
	@GetMapping("/my")
	public String showAllMyServiceOrders(Model model,HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		model.addAttribute("allServiceOrders",this.serviceOrderService.getAllServiceOrdersByUser(principal.getName()));
		return "showAllServiceOrders";
	}
	
	@GetMapping("/all")
	public String showAllServiceOrders(Model model) {
		
		model.addAttribute("allServiceOrders",this.serviceOrderService.getAllServiceOrders());
		return "showAllServiceOrders";
	}
	
	@ModelAttribute("warranties")
	public List<WarrantyDto> warranties(HttpServletRequest request){
		 Principal principal = request.getUserPrincipal();
		 String username = principal.getName();
		 return this.warrantyService.findAllByUser(username);
	}
}
