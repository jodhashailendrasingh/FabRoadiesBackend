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
import com.FabRoadies.service.UserService;



@CrossOrigin
@RestController
public class UserController 
{
	@Autowired
	private UserService service;
	
	@PostMapping(value="/add",consumes="application/json")
	public void addFlight(@RequestBody User user)
	{
		service.addUser(user);
	}
	
	@GetMapping(value="/users/{code}",produces="application/json")
	public User getUser(@PathVariable("code") int code) {
		return service.getByCode(code);
	}

	@GetMapping(value="/users",produces="application/json")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	@DeleteMapping(value="del/{id}")
	public void deleteFlight(@PathVariable("id") int id)
	{
		service.removeFlight(id);
	}
	
	@PutMapping(value="upd/{id}")
	public User updateFlight(@RequestBody User user,@PathVariable("id") int id)
	{
		service.updateFlight(id,user);
		return user;
	}
}


	


	
