package com.nerchuko.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "User service taking longer than expected." + "Please try again later";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String dapartmentServiceFallBackMethod() {
		return "Departement service taking longer than expected." + "Please try again later";
	}
}
