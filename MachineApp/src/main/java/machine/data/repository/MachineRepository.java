package machine.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import machine.data.entities.machines.Machine;
import machine.data.enums.MachineType;

@Repository
public interface MachineRepository extends CrudRepository<Machine, Long> {

	List<Machine> findAllByMachineType(MachineType machineType);
	
	List<Machine> findAllByMachineIdentifierIn(List<String> types);
	
	Machine findByModel(String model);
}
