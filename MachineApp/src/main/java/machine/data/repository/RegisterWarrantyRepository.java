package machine.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import machine.data.entities.Warranty;

@Repository
public interface RegisterWarrantyRepository extends JpaRepository<Warranty, Long>{

}
