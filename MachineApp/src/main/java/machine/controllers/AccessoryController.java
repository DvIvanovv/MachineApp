package machine.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;
import machine.dto.AccessoryDto;
import machine.services.AccessoryService;
import machine.services.MachineService;

@Controller
@RequestMapping("/accessories")
public class AccessoryController 	{
		
	private AccessoryService accessoryService;
	private MachineService machineService;

	
	@Autowired
	public AccessoryController(AccessoryService accessoryService, MachineService machineService) {
		super();
		this.accessoryService = accessoryService;
		this.machineService = machineService;
	}
	
	@GetMapping("/add")
	public String getAddAccessoryForm(Model model) {
		AccessoryDto accessory = new AccessoryDto();
		model.addAttribute("accessory",  accessory);
		return "addAccessory";
	}
	
	@PostMapping("/add")
	public String addAccessory( @ModelAttribute("accessory") AccessoryDto accessory, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("accessory", accessory);
			return "addAccessory";
		}
		this.accessoryService.addAccessory(accessory);
		return "index";
	}
	
	
	@ModelAttribute("machines")
	public List<Machine> machines() {
		List<Machine> machines=new ArrayList<>();
		machines = machineService.getAllMachines();
		return machines;
	}
	@ModelAttribute("accessoryTypes")
	public List<AccessoryType> accessoryTypes() {
		List<AccessoryType> accessoryTypes=new ArrayList<>();
		accessoryTypes.addAll(Arrays.asList(AccessoryType.values()));
		return accessoryTypes;
	}


	
	

}
