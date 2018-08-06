package machine.security.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import machine.data.entities.AuthGroup;
import machine.data.entities.User;
import machine.data.repository.AuthGroupRepository;
import machine.data.repository.UserRepository;

@Service
public class MachineAppUserDetailsService  implements UserDetailsService{

	
	private UserRepository userRepository;
	private AuthGroupRepository authGroupRepository;
	@Autowired
	public MachineAppUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
		super();
		this.userRepository = userRepository;
		this.authGroupRepository = authGroupRepository;
	}
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);	
		if(null!= user) {
			throw new UsernameNotFoundException("Username: " + username + " not found!");
		}
		List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
		return new MachineAppUserPrincipal(user, authGroups);
	}
	
	
	
	
}
