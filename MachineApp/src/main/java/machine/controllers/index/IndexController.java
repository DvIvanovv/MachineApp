package machine.controllers.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import machine.data.enums.MachineType;

@Controller
public class IndexController {
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}

}
