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
import machine.data.enums.ConsumableType;
import machine.dto.ConsumableDto;
import machine.dto.MachineDto;
import machine.services.ConsumableService;
import machine.services.MachineService;

@Controller
@RequestMapping("/consumables")
public class ConsumableController 	{
		
	private ConsumableService consumableService;
	private MachineService machineService;

	
	@Autowired
	public ConsumableController(ConsumableService consumableService, MachineService machineService) {
		super();
		this.consumableService = consumableService;
		this.machineService = machineService;
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public String getAddConsumableForm(Model model) {
		ConsumableDto consumable = new ConsumableDto();
		model.addAttribute("consumable",  consumable);
		return "addConsumable";
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public String addConsumable(@Valid @ModelAttribute("consumable") ConsumableDto consumable, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("consumable", consumable);
			return "addConsumable";
		}
		boolean isAdded = this.consumableService.addConsumable(consumable);
		model.addAttribute("consumable", consumable);
		model.addAttribute("isAdded", isAdded);
		return "successfulyAddConsumable"; //TODO go to consumable list instead of index
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
	
	@ModelAttribute("consumableTypes")
	public List<ConsumableType> consumableTypes() {
		List<ConsumableType> consumableTypes=new ArrayList<>();
		consumableTypes.addAll(Arrays.asList(ConsumableType.values()));
		return consumableTypes;
	}
}
