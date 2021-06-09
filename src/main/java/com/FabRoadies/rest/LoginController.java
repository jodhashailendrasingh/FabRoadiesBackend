package com.FabRoadies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.entity.User;
import com.FabRoadies.repo.UserRepo;
import com.FabRoadies.service.LoginService;
import com.FabRoadies.service.UserService;

@CrossOrigin
@RestController  
public class LoginController {
	@Autowired
	private LoginService service;

    
	@GetMapping(value="/login/{email}/{password}",produces="application/json")
	public int getUser(@PathVariable("email") String email,@PathVariable("password") String password) {
		
		User user= service.getByEmailPassword(email,password);
		System.out.println(user.getRoll().getRollid());
		return user.getRoll().getRollid();
		//return user;
		
	}

}
