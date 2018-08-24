package machine;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import machine.controllers.RegisterController;
import machine.data.entities.User;
import machine.dto.UserDto;
import machine.services.UserService;
@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
@AutoConfigureMockMvc(secure = false)
public class RegisterControllerTest {
	
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserService userService;
	
	@InjectMocks
	private RegisterController registerController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void registerUserTest() throws Exception {
		String password = "password";
		String username = "Username";
		UserDto user = new UserDto();
		user.setUsername(username);
		user.setPassword(password);
		user.setConfirmPassword(password);
		User result = new User();
		result.setUsername(username);
		result.setPassword(password);
		
		Mockito.when( userService.createUserAccount(user)).thenReturn(result);
		
		mvc
		.perform(post("/register",user))
		.andExpect(status().isOk()).andReturn();
		
	}
}
