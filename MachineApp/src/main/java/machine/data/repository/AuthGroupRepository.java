package machine.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import machine.data.entities.AuthGroup;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long>{

	List<AuthGroup> findByUsername(String username);
	AuthGroup findByUsernameAndAuthGroup(String username, String authGroup);
}
