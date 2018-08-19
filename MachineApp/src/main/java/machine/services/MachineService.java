package machine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import machine.data.entities.machines.Machine;
import machine.data.enums.MachineType;
import machine.dto.Machine1Dto;
import machine.dto.MachineDto;
@Transactional
@Service
public interface MachineService {

	void addMachine(MachineDto machineDto);
	void addMachine(Machine1Dto machineDto);
	List<Machine> getAllMachines();
	List<MachineDto> getAllMachinesDto();
	Machine findByModel(String model);
	List<Machine> getAllMachinesByType(MachineType machineType);

}
