package machine.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import machine.dto.WarrantyDto;
import machine.services.MachineService;
import machine.services.RgisterWarrantyService;

@Controller
public class RegisterWarrantyController {
	private MachineService machineService;
	private RgisterWarrantyService registerMachineService;
	
	
	@Autowired
	public RegisterWarrantyController(MachineService machineService, RgisterWarrantyService regiserMachineService) {
		super();
		this.machineService = machineService;
		this.registerMachineService = regiserMachineService;
	}

	@GetMapping("/register/machine")
	public String getRegisterMachineForm(Model model) {
		model.addAttribute("warranty", new WarrantyDto());
		return "registerWarranty";
	}
	
	@PostMapping("/register/machine")
	public String registerMachine(@Valid @ModelAttribute("warranty") WarrantyDto registerMachine,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		if(bindingResult.hasErrors()) {
			return "registerWarranty";
		}
		Principal principal = request.getUserPrincipal();
	    String username = principal.getName();
	    registerMachine.setUsername(username);   
	    try {
	  	   this.registerMachineService.registerWarranty(registerMachine);
		} catch (IllegalArgumentException e) {
			if(e.getMessage().startsWith("Regis")) {
				bindingResult.rejectValue("orderDate","404", e.getMessage());
				model.addAttribute("warranty", registerMachine);
			}
			else {
				bindingResult.rejectValue("serialNumber","404", e.getMessage());
				model.addAttribute("warranty", registerMachine);
			}			
			return "registerWarranty";
		}   
	    return "redirect:/warranties/all";
	}
	
	@GetMapping("/warranties/all")
	public String showAllWarranties(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		model.addAttribute("allWarranties", this.registerMachineService.findAllByUser(principal.getName())) ;
		return "showAllWarranties";
	}
	
	@GetMapping("/warranties/soldMachines")
	public String showSoldMachineForm(Model model) {	
		model.addAttribute("model1", new String()) ;
		model.addAttribute("model2", new String()) ;
		return "showCompareSoldForm";
	}
	
	@PostMapping("/warranties/soldMachines")
	public String showSoldMachine(@ModelAttribute ("model1") String modelOne, 
			@ModelAttribute ("model2") String modelTwo, BindingResult bindingResult, Model model) throws InterruptedException, ExecutionException {	
		 CompletableFuture<String> firstModel = this.registerMachineService.countMachineSales(modelOne);
		 CompletableFuture<String> secondModel = this.registerMachineService.countMachineSales(modelTwo);
		 CompletableFuture.allOf(firstModel, secondModel).join();
		 model.addAttribute("model1", firstModel.get());
		 model.addAttribute("model2", secondModel.get());
		return "showCompareSold";
	}
	
	@ModelAttribute("allMachines")
	public List<String> machines() {
		List<String> machines=new ArrayList<>();
		machineService.getAllMachinesDto().stream().forEach( m->machines.add(m.getModel()));
		return machines;
	}
}
