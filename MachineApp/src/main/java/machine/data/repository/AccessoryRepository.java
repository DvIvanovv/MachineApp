package machine.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import machine.data.entities.Consumable;
import machine.data.enums.AccessoryType;

@Service
public interface AccessoryRepository extends CrudRepository<Consumable, Long>{

	Consumable findByAccessoryType( AccessoryType type);
	@Query( value = "select * from accessories \r\n" + 
			"join accessory_machine on accessories.id =  accessory_machine.consumables_id\r\n" + 
			"#join machines on machines.id = accessory_machine.machines_id\r\n" + 
			"where accessory_machine.machines_id = ?1 and accessories.accessory_type = ?2;", nativeQuery = true)
	Consumable findByTypeAndMachine(Long machines_id, AccessoryType accessory_type);
	Consumable findByName(String name);
}
