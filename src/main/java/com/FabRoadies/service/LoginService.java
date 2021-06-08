package com.FabRoadies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.entity.User;
import com.FabRoadies.repo.UserRepo;

@Service
public class LoginService {

	@Autowired
    private UserRepo userRepository;
	public User getByEmailPassword(String uemail, String upassword) {
		// TODO Auto-generated method stub
		return userRepository.getByEmailPassword(uemail,upassword);
	
		
	}

}
