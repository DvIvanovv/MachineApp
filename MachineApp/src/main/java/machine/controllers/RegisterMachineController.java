package machine.controllers;

import java.security.Principal;
import java.util.ArrayList;
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

import machine.data.entities.machines.Machine;
import machine.dto.RegisterMachineDto;
import machine.services.MachineService;
import machine.services.RegisterMachineService;

@Controller
public class RegisterMachineController {
	private MachineService machineService;
	private RegisterMachineService registerMachineService;
	
	
	@Autowired
	public RegisterMachineController(MachineService machineService, RegisterMachineService regiserMachineService) {
		super();
		this.machineService = machineService;
		this.registerMachineService = regiserMachineService;
	}

	@GetMapping("/register/machine")
	public String getRegisterMachineForm(Model model) {
		model.addAttribute("warranty", new RegisterMachineDto());
		return "registerMachine";
	}
	
	@PostMapping("/register/machine")
	public String registerMachine(@Valid @ModelAttribute("warranty") RegisterMachineDto registerMachine,
			BindingResult bindingResult, HttpServletRequest request) {
		 Principal principal = request.getUserPrincipal();
	       String username = principal.getName();
	       registerMachine.setUsername(username);
	       registerMachineService.registerWarranty(registerMachine);
	       return"index";
		
	}
	
	@ModelAttribute("machines")
	public List<Machine> machines() {
		List<Machine> machines=new ArrayList<>();
		machines = machineService.getAllMachines();
		return machines;
	}
}
