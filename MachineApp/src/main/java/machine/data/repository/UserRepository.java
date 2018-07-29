package machine.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import machine.data.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
