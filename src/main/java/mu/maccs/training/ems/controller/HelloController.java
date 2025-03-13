package mu.maccs.training.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class HelloController {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! Your Employee Management app is running!";
	}
}
