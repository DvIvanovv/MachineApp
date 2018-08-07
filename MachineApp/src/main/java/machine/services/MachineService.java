package machine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import machine.data.entities.machines.Machine;
import machine.dto.MachineDto;
@Transactional
@Service
public interface MachineService {

	void addMachine(MachineDto machineDto);
	List<Machine> getAllMachines();
	Machine findByModel(String model);

}
