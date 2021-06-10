package com.FabRoadies.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.entity.User;
import com.FabRoadies.repo.UserRepo;
import com.FabRoadies.service.UserService;



@CrossOrigin
@RestController  
public class UserController 
{
	@Autowired
	private UserService service;
    @Autowired
    private UserRepo userRepository;
	
	@PostMapping(value="/add/{roll}",consumes="application/json")
	public void addUser(@RequestBody User user,@PathVariable("roll") int roll)
	{
		 User foundUser = userRepository.findOneByEmail(user.getEmail());
	        if (foundUser != null) {
	            throw new RuntimeException();
	        }  
		service.addUser(user,roll);
		
		
		
	}
	
	//////////////
	
	@GetMapping(value="/users/{code}",produces="application/json")
	public User getUser(@PathVariable("code") int code) {
		return service.getByCode(code);
	}

	@GetMapping(value="/users",produces="application/json")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	@DeleteMapping(value="del/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		service.removeUser(id);
	}
	
	@PutMapping(value="upd/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id)
	{
		service.updateUser(id,user);
		return user;
	}
}


	


	
