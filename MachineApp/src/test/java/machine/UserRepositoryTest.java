package machine;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import machine.data.entities.User;
import machine.data.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByUsernameThenReturnUser() {
		String username = "Username";
		String password = "password";
		User user = new User();
		
		user.setPassword(password);
		user.setUsername(username);
		entityManager.persist(user);
		entityManager.flush();
		
		User result = userRepository.findByUsername(username);
		assertThat(result.getUsername()).isEqualTo(user.getUsername());
	}

}
