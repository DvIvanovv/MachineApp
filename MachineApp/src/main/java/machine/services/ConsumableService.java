package machine.services;

import org.springframework.stereotype.Service;
import machine.data.entities.Consumable;
import machine.data.enums.ConsumableType;
import machine.dto.ConsumableDto;

@Service
public interface ConsumableService {

	public boolean addConsumable(ConsumableDto consumableDto);
	
	public Consumable findByType(ConsumableType type);

}
