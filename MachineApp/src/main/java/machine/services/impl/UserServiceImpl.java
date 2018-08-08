package machine.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import machine.data.entities.AuthGroup;
import machine.data.entities.User;
import machine.data.repository.AuthGroupRepository;
import machine.data.repository.UserRepository;
import machine.dto.UserDto;
import machine.services.UserService;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private AuthGroupRepository authGroupRepository;
	private PasswordEncoder passwordEncoder;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, AuthGroupRepository authGroupRepository,
			PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.authGroupRepository = authGroupRepository;
		this.passwordEncoder = passwordEncoder;
		this.modelMapper =  modelMapper;

	}

	/* (non-Javadoc)
	 * @see machine.services.UserService#isUserExists(java.lang.String)
	 */

	@Override
	public boolean isUsernameExist(String username) {
		if(this.userRepository.findByUsername(username) != null) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see machine.services.UserService#createUserAccount(machine.dto.UserDto)
	 */
	// the rest of the registration operation


	@Override
	public User createUserAccount(UserDto userDto) throws IllegalArgumentException {
		//User user = modelMapper.map(userDto, User.class);
		if(isUsernameExist(userDto.getUsername())) {
			throw new  IllegalArgumentException (
					"There is an account with username: "
							+  userDto.getUsername());
		}
		User user = new User();
		user.setUsername( userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		//user.setPassword(userDto.getPassword());
		this.userRepository.save(user);
		AuthGroup authGroup = new AuthGroup();
		authGroup.setUsername(user.getUsername());
		authGroup.setAuthGroup("USER");
		this.authGroupRepository.save(authGroup);
		List<User> users = (List<User>)userRepository.findAll();
		for(User user1 : users) {
			System.out.println("username: " + user1.getUsername());
			System.out.println("password: " + user1.getPassword());
		}
		return user;
		
	}

}
