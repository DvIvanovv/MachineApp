package machine.services;


import java.util.List;

import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.entities.machines.Machine;
import machine.data.enums.ConsumableType;
import machine.dto.ConsumableDto;

@Service
public interface ConsumableService {

	public boolean addConsumable(ConsumableDto consumableDto);
	//List<Consumable> findAllByModel(Machine machine);
	
	public Consumable findByType(ConsumableType type);
	public Consumable findByMachineAndType(Long machineId, ConsumableType type);
}
