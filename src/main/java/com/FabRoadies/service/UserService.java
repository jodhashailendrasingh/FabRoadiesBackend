package com.fabRoadies.service;

import java.util.List;

import com.fabRoadies.entity.User;

public interface UserService {

	List<User> getAllUser();

	User getByCode(int id);

	void updateUser(User user);

	void removeUser(int code);

	void addUser(User user, int roll);
	
	int getUserIdByEmail(String email);


}
