package machine.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import machine.data.entities.User;
import machine.security.auth.MachineAppUserDetailsService;

@Controller
public class LoginController {
	
	//private MachineAppUserDetailsService userService;
	
	@Autowired
	public LoginController(MachineAppUserDetailsService userService) {
		super();
	//	this.userService = userService;
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		//model.addAttribute("user", new User());
		return "login";
	}
	
	
	
	@GetMapping("/logout")
	public String logoutUser() {
		
		return "index";
	}

}
