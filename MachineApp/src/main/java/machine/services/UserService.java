package machine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import machine.data.entities.User;
import machine.dto.UserDto;
@Service
public interface UserService {
	
	public boolean isUsernameExist(String username);
	public User createUserAccount(UserDto userDto);
	public User findByUsername(String username);
	public List<UserDto> getAllUsers();
	public String addRole(String username);
	public String removeRole(String username);
}
