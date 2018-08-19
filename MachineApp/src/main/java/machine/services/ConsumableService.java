package machine.services;


import java.util.List;

import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.entities.machines.Machine;
import machine.data.enums.AccessoryType;
import machine.dto.ConsumableDto;

@Service
public interface ConsumableService {

	public void addAccessory(ConsumableDto accessoryDto);
	//List<Accessory> findAllByModel(Machine machine);
	
	public Consumable findByType(AccessoryType type);
}
