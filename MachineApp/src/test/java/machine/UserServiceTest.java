package machine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import machine.data.entities.User;
import machine.data.repository.AuthGroupRepository;
import machine.data.repository.UserRepository;
import machine.services.UserService;
import machine.services.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	//@MockBean
	private  static UserRepository userRepository = Mockito.mock(UserRepository.class);
//	@MockBean
	private  AuthGroupRepository authGroupRepository = Mockito.mock(AuthGroupRepository.class);
//	@MockBean
	private  PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
//	@MockBean
	private  ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
	
	@TestConfiguration
	static class UserServiceImplTestConfig{
		@Bean
		public UserService userService() {
			
			return new UserServiceImpl(userRepository ,  Mockito.mock(AuthGroupRepository.class),
					 Mockito.mock(PasswordEncoder.class),  Mockito.mock(ModelMapper.class));
		}
	}
	
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		String username = "Username";
		String password = "password";
		User user = new User();
		
		user.setPassword(password);
		user.setUsername(username);
		
		Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
	}
	
	@Test
	public void whenUsernameexistsThenUserShoudBrFound() {
		String username = "Username";
		User result = userService.findByUsername(username);
		assertThat(result.getUsername()).isEqualTo(username);
	}
}
