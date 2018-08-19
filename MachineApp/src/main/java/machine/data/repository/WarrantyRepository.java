package machine.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import machine.data.entities.Warranty;

@Repository
public interface WarrantyRepository extends CrudRepository<Warranty, Long>{

	List<Warranty> findAllByUsername(String username);

	Warranty findBySerialNumber(String serialNumber);
	
	
}
