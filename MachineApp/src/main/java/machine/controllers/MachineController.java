package machine.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import machine.data.enums.MachineType;
import machine.dto.AdDryerDto;
import machine.dto.Machine1Dto;
import machine.dto.MachineDto;
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
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView getAddMachineForm(ModelAndView modelAndView) {
		modelAndView.addObject("machineType", new String());
		modelAndView.setViewName("addMachine");
		return modelAndView;
	}
	@GetMapping("/add1")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView getAddMachineForm1(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new Machine1Dto());
		modelAndView.setViewName("addMachineAjax");
		return modelAndView;
	}
	@PostMapping("/add1")
	public ModelAndView addMachine(@Valid @ModelAttribute ("machine") Machine1Dto machine, BindingResult bindingResult, ModelAndView modelAndView) {	
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addMachineAjax");
			return modelAndView;
		}
		switch(machine.getMachineType().name()) {
		case "SCREW_COMPRESSOR" : 
				if(machine.getVolumeAt10Bars() == 0.0 || machine.getVolumeAt10Bars() == 0.0 ||
				machine.getVolumeAt13Bars() == 0.0) {
					modelAndView.addObject("machine", machine);
					modelAndView.setViewName("addMachineAjax");
					return modelAndView;
				}
				this.machineService.addMachine(machine);
			break;
		case "PISTON_COMPRESSOR" : 
			if(machine.getNumberOfPistons() == 0|| machine.getNumberOfStages() == 0) {
				modelAndView.addObject("machine", machine);
				modelAndView.setViewName("addMachineAjax");
				return modelAndView;
			}
			this.machineService.addMachine(machine);
			break;
		case "ADSORPTION_DRYER" : 
			break;
		case "REFRIGERATION_DRYER" : 
			break;
			default:
				break;
		}
		modelAndView.setViewName("/");
		return modelAndView;
		
	}


	@GetMapping("/add/SCREW_COMPRESSOR")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
		//@GetMapping("/edit/{type}") @PathVariable String machineType
	public ModelAndView getAddScrewCompressorForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new ScrewCompressorDto());
		modelAndView.setViewName("addScrew");
		return modelAndView;
	}
	
	@PostMapping("/add/SCREW_COMPRESSOR")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView AddScrewCompressor(@Valid @ModelAttribute ("machine") ScrewCompressorDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addScrew");
			return modelAndView;
		}
		try {
			this.machineService.addMachine(machine);
			return new ModelAndView("redirect:/machines/showAll/SCREW_COMPRESSOR");
		} catch (IllegalArgumentException e) {
			bindingResult.rejectValue("model","404", e.getMessage());
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addScrew");
			return modelAndView;
		}
	}

	@GetMapping("/add/PISTON_COMPRESSOR")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView getAddPistonCompressorForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new PistonCompressorDto());
		modelAndView.setViewName("addPiston");
		return modelAndView;
	}
	
	@PostMapping("/add/PISTON_COMPRESSOR")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView AddPistonCompressor(@Valid @ModelAttribute ("machine") PistonCompressorDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addPiston");
			return modelAndView;
		}
		try {
			this.machineService.addMachine(machine);
			return new ModelAndView("redirect:/machines/showAll/PISTON_COMPRESSOR");
		} catch (IllegalArgumentException e) {
			bindingResult.rejectValue("model","404", e.getMessage());
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addPiston");
			return modelAndView;
		}
	}

	@GetMapping("/add/ADSORPTION_DRYER")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView getAddAdDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new AdDryerDto());
		modelAndView.setViewName("addAdsorption");
		return modelAndView;
	}
	
	@PostMapping("/add/ADSORPTION_DRYER")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView AddAdDryer(@Valid @ModelAttribute ("machine") AdDryerDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addAdsorption");
			return modelAndView;
		}
		try {
			this.machineService.addMachine(machine);
			return new ModelAndView("redirect:/machines/showAll/ADSORPTION_DRYER");
		} catch (IllegalArgumentException e) {
			bindingResult.rejectValue("model","404", e.getMessage());
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addAdsorption");
			return modelAndView;
		}
	}
	
	@GetMapping("/add/REFRIGERATION_DRYER")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView getFfdAdDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machine", new RfDryerDto());
		modelAndView.setViewName("addRefrigeneration");
		return modelAndView;
	}
	
	@PostMapping("/add/REFRIGERATION_DRYER")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	public ModelAndView AddRfDryer(@Valid @ModelAttribute ("machine") RfDryerDto machine, BindingResult bindingResult, ModelAndView modelAndView) {
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addRefrigeneration");
			return modelAndView;
		}
		try {
			this.machineService.addMachine(machine);
			return new ModelAndView("redirect:/machines/showAll/REFRIGERATION_DRYER");
		} catch (IllegalArgumentException e) {
			bindingResult.rejectValue("model","404", e.getMessage());
			modelAndView.addObject("machine", machine);
			modelAndView.setViewName("addRefrigeneration");
			return modelAndView;
		}
	}
	@GetMapping("/showAll/REFRIGERATION_DRYER")
	public ModelAndView getShowAllRfDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machines", this.machineService.getAllMachinesByType(MachineType.REFRIGERATION_DRYER));
		modelAndView.addObject("machineType", "Show all Refrigeration Dryers");
		modelAndView.setViewName("showAllFromType");
		return modelAndView;
	}
	@GetMapping("/showAll/ADSORPTION_DRYER")
	public ModelAndView getShowAllAdDryerForm(ModelAndView modelAndView) {
		modelAndView.addObject("machines", this.machineService.getAllMachinesByType(MachineType.ADSORPTION_DRYER));
		modelAndView.addObject("machineType", "Show all Adsorption Dryers");
		modelAndView.setViewName("showAllFromType");
		return modelAndView;
	}
	
	@GetMapping("/showAll/PISTON_COMPRESSOR")
	public ModelAndView getShowAllPistonCompressors(ModelAndView modelAndView) {
		modelAndView.addObject("machines", this.machineService.getAllMachinesByType(MachineType.PISTON_COMPRESSOR));
		modelAndView.addObject("machineType", "Show all Piston Compressors");
		modelAndView.setViewName("showAllFromType");
		return modelAndView;
	}
	@GetMapping("/showAll/SCREW_COMPRESSOR")
	public ModelAndView getShowAllScrewCompressors(ModelAndView modelAndView) {
		modelAndView.addObject("machines", this.machineService.getAllMachinesByType(MachineType.SCREW_COMPRESSOR));
		modelAndView.addObject("machineType", "Show all Screw Compressors");
		modelAndView.setViewName("showAllFromType");
		return modelAndView;
	}
	
	@ModelAttribute("machineTypes")
	public List<MachineType> machineTypes() {
		List<MachineType> machineTypes=new ArrayList<>();
		machineTypes.addAll(Arrays.asList(MachineType.values()));
		return machineTypes;
	}
}
