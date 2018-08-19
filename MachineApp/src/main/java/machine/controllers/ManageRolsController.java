package machine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import machine.services.UserService;

@Controller
@RequestMapping("/manage")
public class ManageRolsController {
	private UserService userSerrvice;
	
	@Autowired
	public ManageRolsController(UserService userSerrvice) {
		super();
		this.userSerrvice = userSerrvice;
	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getAllUsersManageForm(Model model) {
		
		model.addAttribute("users", this.userSerrvice.getAllUsers());
		return "showAllUsers";
	}
	
	 @GetMapping("/edit/{username}")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 public String addManagerRole(@PathVariable String username, Model model) {
		
		 String message = this.userSerrvice.addRole(username);
		model.addAttribute("message", message);
		 return "roleChange";
	    }
	 @GetMapping("/delete/{username}")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 public String removeManagerRole(@PathVariable String username, Model model) {
		
		 String message= this.userSerrvice.removeRole(username);
		 model.addAttribute("message", message);
		 return "roleChange";
	    }
	

}
