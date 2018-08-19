package machine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.enums.AccessoryType;

@Service
public interface AccessoryRepository extends CrudRepository<Consumable, Long>{

	Consumable findByAccessoryType( AccessoryType type);

}
