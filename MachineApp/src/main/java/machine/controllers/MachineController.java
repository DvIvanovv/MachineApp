package machine.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import machine.data.enums.MachineType;
import machine.dto.AdDryerDto;
import machine.dto.PistonCompressorDto;
import machine.dto.RfDryerDto;
import machine.dto.ScrewCompressorDto;
import machine.services.MachineService;

@Controller
@RequestMapping("/machines")
public class MachineController {

	private MachineService machineService;
	@Autowired
	public MachineController(MachineService machineService) {
		super();
		this.machineService = machineService;
	}
	@GetMapping("/add")
	public ModelAndView getAddMachineForm(ModelAndView modelAndView) {
		modelAndView.addObject("machineType", new String());
		modelAndView.setViewName("addMachine");
		return modelAndView;
	}

	@PostMapping("/add") 
	public String addMachine(@ModelAttribute String machineType , BindingResult result, ModelAndView modelAndView) {

		return "redirect:/machines/add/"+ machineType;
	}


	@GetMapping("/add/SCREW_COMPRESSOR")
		//@GetMapping("/edit/{type}") @PathVariable String machineType
	public ModelAndView getAddScrewCompressorForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new ScrewCompressorDto());
		modelAndView.setViewName("addScrew");
		return modelAndView;
	}
	@PostMapping("/add/SCREW_COMPRESSOR")
	//@PostMapping("/edit/{type}") @PathVariable String type,
	public ModelAndView AddScrewCompressor(@Valid @ModelAttribute ("machine") ScrewCompressorDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addScrew");
			return modelAndView;
		}
		this.machineService.addMachine(machine);
		//			modelAndView.setViewName("index");
		return new ModelAndView("redirect:/");

	}

	@GetMapping("/add/PISTON_COMPRESSOR")
	public ModelAndView getAddPistonCompressorForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new PistonCompressorDto());
		modelAndView.setViewName("addPiston");
		return modelAndView;
	}
	@PostMapping("/add/PISTON_COMPRESSOR")
	public ModelAndView AddPistonCompressor(@Valid @ModelAttribute ("machine") PistonCompressorDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addPiston");
			return modelAndView;
		}
		this.machineService.addMachine(machine);
		//			modelAndView.setViewName("index");
		return new ModelAndView("redirect:/");

	}

	@GetMapping("/add/ADSORPTION_DRYER")
	public ModelAndView getAddAdDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new AdDryerDto());
		modelAndView.setViewName("addAdsorption");
		return modelAndView;
	}
	
	@PostMapping("/add/ADSORPTION_DRYER")
	public ModelAndView AddAdDryer(@Valid @ModelAttribute ("machine") AdDryerDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addAdsorption");
			return modelAndView;
		}
		this.machineService.addMachine(machine);
		//			modelAndView.setViewName("index");
		return new ModelAndView("redirect:/");

	}
	@GetMapping("/add/REFRIGERATION_DRYER")
	public ModelAndView getFfdAdDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new RfDryerDto());
		modelAndView.setViewName("addRefrigeneration");
		return modelAndView;
	}
	@PostMapping("/add/REFRIGERATION_DRYER")
	public ModelAndView AddRfDryer(@Valid @ModelAttribute ("machine") RfDryerDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addRefrigeneration");
			return modelAndView;
		}
		this.machineService.addMachine(machine);
		//			modelAndView.setViewName("index");
		return new ModelAndView("redirect:/");

	}
	@ModelAttribute("machineTypes")
	public List<MachineType> machineTypes() {
		List<MachineType> machineTypes=new ArrayList<>();
		machineTypes.addAll(Arrays.asList(MachineType.values()));
		return machineTypes;
	}




}