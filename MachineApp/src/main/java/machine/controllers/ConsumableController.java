package machine.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;
import machine.dto.ConsumableDto;
import machine.dto.MachineDto;
import machine.services.ConsumableService;
import machine.services.MachineService;

@Controller
@RequestMapping("/accessories")
public class ConsumableController 	{
		
	private ConsumableService accessoryService;
	private MachineService machineService;

	
	@Autowired
	public ConsumableController(ConsumableService accessoryService, MachineService machineService) {
		super();
		this.accessoryService = accessoryService;
		this.machineService = machineService;
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public String getAddAccessoryForm(Model model) {
		ConsumableDto accessory = new ConsumableDto();
		model.addAttribute("accessory",  accessory);
		return "addAccessory";
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public String addAccessory(@Valid @ModelAttribute("accessory") ConsumableDto accessory, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("accessory", accessory);
			return "addAccessory";
		}
		this.accessoryService.addAccessory(accessory);
		return "index"; //TODO go to accessory list instead of index
	}
	
	
//	@ModelAttribute("allMachines")
//	public List<Machine> machines() {
//		List<Machine> machines=new ArrayList<>();
//		machines = machineService.getAllMachines();
//		return machines;
//	}
	@ModelAttribute("allMachines")
	public List<MachineDto> machines() {
		List<MachineDto> machines=new ArrayList<>();
		machines = machineService.getAllMachinesDto();
		return machines;
	}
	
	@ModelAttribute("accessoryTypes")
	public List<AccessoryType> accessoryTypes() {
		List<AccessoryType> accessoryTypes=new ArrayList<>();
		accessoryTypes.addAll(Arrays.asList(AccessoryType.values()));
		return accessoryTypes;
	}
}
