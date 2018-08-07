package machine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import machine.data.entities.Accessory;

@Service
public interface AccessoryRepository extends CrudRepository<Accessory, Long>{

}
