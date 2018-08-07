package machine.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import machine.data.entities.User;
import machine.dto.UserDto;
import machine.services.UserService;

@Controller
public class RegisterController {

	private UserService userService;
	
	@Autowired
	public RegisterController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		model.addAttribute("user", new UserDto());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
		User registered = new User();
		if(!bindingResult.hasErrors()) {
			registered = this.userService.createUserAccount(userDto);
		}
	    if( registered == null) {
	    	bindingResult.rejectValue("username", "message.regError");
	    	model.addAttribute("user", userDto);
	    	return "register";
	    }
		if(bindingResult.hasErrors()) {
			model.addAttribute("user", userDto);
			return "register";
		}
		return "/login";
	}
}
