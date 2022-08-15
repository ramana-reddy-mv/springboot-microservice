package com.nerchuko.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nerchuko.userservice.VO.ResponseTemplateVO;
import com.nerchuko.userservice.entity.Users;
import com.nerchuko.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public Users saveUser(@RequestBody Users users) {
		log.info("Inside saveuser UserController");
		return userService.saveUser(users);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside getUserWithDepartment  UserController");
		return userService.getUserWithDepartment(userId);
	}
	
}
