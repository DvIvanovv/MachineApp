package machine.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import machine.ServiceOrderServiceImpl;
import machine.data.entities.Consumable;
import machine.data.enums.AccessoryType;
import machine.dto.ServiceOrderDto;
import machine.services.ConsumableService;
import machine.services.MachineService;
import machine.services.RgisterWarrantyService;
import machine.services.UserService;
	
	
@Controller
@RequestMapping("/serviceOrder")
public class ServiceOrderController {
	
	private ServiceOrderServiceImpl serviceOrderService;
	private MachineService machineService;
	private RgisterWarrantyService warrantyService;
	private UserService  userService;
	private ConsumableService accessoryService;
	
	@Autowired
	public ServiceOrderController(MachineService machineService,
			ServiceOrderServiceImpl serviceOrderService, RgisterWarrantyService warrantyService,
			UserService  userService,ConsumableService accessoryService) {
		super();
		this.serviceOrderService = serviceOrderService;
		this.warrantyService = warrantyService;
		this.machineService = machineService;
		this.userService = userService;
		this.accessoryService = accessoryService;
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
		List<Consumable> consumables = new ArrayList<>();
		for(String s : serviceOrder.getConsumables()) {
			AccessoryType val =AccessoryType.valueOf(s);
			Consumable con = this.accessoryService.findByType(val);
			consumables.add(con);
		}
		//serviceOrder.getConsumables().stream().forEach(c-> consumables.add(this.accessoryService.findByType(AccessoryType.valueOf(c))));
		try {
			serviceOrderService.addServiceOrder(serviceOrder, consumables);	
		} catch( IllegalArgumentException e) {
			bindingResult.rejectValue("serviceDate","404", e.getMessage());
			model.addAttribute("serviceDate", serviceOrder);
			return "addServiceOrder";
		}
		return "redirect:/serviceOrder/all";
	}
	@GetMapping("/all")
	public String showAllServiceOrders(Model model,HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		model.addAttribute("allServiceOrders",this.serviceOrderService.getAllServiceOrdersByUser(principal.getName()));
		return "showAllServiceOrders";
	}

	
	@ModelAttribute("warranties")
	public List<WarrantyDto> warranties(HttpServletRequest request){
		 Principal principal = request.getUserPrincipal();
		 String username = principal.getName();
		 return this.warrantyService.findAllByUser(username);
	}
}
