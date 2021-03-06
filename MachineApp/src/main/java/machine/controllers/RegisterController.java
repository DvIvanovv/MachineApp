package machine.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		if(bindingResult.hasErrors()) {
			if (bindingResult.hasGlobalErrors()) {
				bindingResult.rejectValue("confirmPassword", "404", bindingResult.getGlobalError().getDefaultMessage());
			}
			return "register";
		}
		try {
			this.userService.createUserAccount(userDto);
		} catch (IllegalArgumentException e) {
			bindingResult.rejectValue("username","404", e.getMessage());
			model.addAttribute("user", userDto);
			return "register";
		}
		return "/login";
	}
}
