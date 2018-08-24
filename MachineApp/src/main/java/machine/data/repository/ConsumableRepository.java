package machine.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.enums.ConsumableType;

@Service
public interface ConsumableRepository extends CrudRepository<Consumable, Long>{

	Consumable findByConsumableType( ConsumableType type);
	@Query( value = "select * from consumables \r\n" + 
			"join consumable_machine on consumables.id =  consumable_machine.consumables_id\r\n" + 
			"#join machines on machines.id = consumable_machine.machines_id\r\n" + 
			"where consumable_machine.machines_id = ?1 and consumables.consumable_type = ?2;", nativeQuery = true)
	Consumable findByTypeAndMachine(Long machines_id, ConsumableType consumable_type);
	Consumable findByName(String name);
}
