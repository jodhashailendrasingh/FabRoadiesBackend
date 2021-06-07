package com.FabRoadies.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.entity.User;
import com.FabRoadies.repo.UserRepo;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getByCode(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void removeFlight(int code) {
		// TODO Auto-generated method stub
		repo.deleteById(code);
		
		
	}

	@Override
	public void updateFlight(int id, User user) {
		// TODO Auto-generated method stub
		for(int i=0;i<getAllUser().size();i++)
		{
			User u=getAllUser().get(i);
			if(u.equals(id)) 
			{	
				getAllUser().set(i, user);
				return;
			}
		}
		
		repo.save(user);
		
	}
	
	
	
	
}








	



	

	
	


