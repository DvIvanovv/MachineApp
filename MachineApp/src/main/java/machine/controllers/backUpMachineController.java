package machine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import machine.data.entities.machines.Machine;
import machine.services.MachineService;

@RestController("/api")
public class backUpMachineController {
	private MachineService machineService;
	
	@Autowired
	public backUpMachineController(MachineService machineService) {
		super();
		this.machineService =  machineService;
	}


	@GetMapping("/backUpMachine")
	public List<Machine> backUp() {
			List<Machine> machines = this.machineService.getAllMachines();
			return machines;
	}
}
