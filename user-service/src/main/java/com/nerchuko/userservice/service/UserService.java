
package com.nerchuko.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nerchuko.userservice.VO.Department;
import com.nerchuko.userservice.VO.ResponseTemplateVO;
import com.nerchuko.userservice.entity.Users;
import com.nerchuko.userservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	public Users saveUser(Users users) {
		log.info("inside saveUser of UserService");
		return userRepository.save(users);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Users users = userRepository.findByUserId(userId);
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + users.getDepartmentId(),Department.class);
		vo.setUsers(users);
		vo.setDepartment(department);
		return vo;
		
	}

}
