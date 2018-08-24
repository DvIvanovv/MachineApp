package machine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.enums.ConsumableType;

@Service
public interface ConsumableRepository extends CrudRepository<Consumable, Long>{

	Consumable findByConsumableType( ConsumableType type);
	
	Consumable findByName(String name);
}
