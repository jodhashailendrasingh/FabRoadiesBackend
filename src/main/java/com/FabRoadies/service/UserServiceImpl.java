package com.fabRoadies.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Roles;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.RollRepo;
import com.fabRoadies.repo.UserRepo;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private RollRepo rollrepo;

	@Override
	public void addUser(User user,int roll) {
		// TODO Auto-generated method stub
		Roles rolls =getRoll(roll);
		user.setRoll(rolls);
	    repo.save(user);
		
		}
	public Roles getRoll(int roll)
	{
		return rollrepo.findById(roll).get();
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
	public void removeUser(int code) {
		// TODO Auto-generated method stub
		repo.deleteById(code);
		
		
	}

	@Override
	public void updateUser(int id, User user) {
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








	



	

	
	


