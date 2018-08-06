package machine.services;

import org.springframework.stereotype.Service;

import machine.data.entities.User;
import machine.dto.UserDto;
@Service
public interface UserService {
	
	public boolean isUsernameExist(String username);
	
	public User createUserAccount(UserDto userDto);

}
