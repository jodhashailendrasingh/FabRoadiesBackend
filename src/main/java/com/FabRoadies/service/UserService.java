package com.FabRoadies.service;

import java.util.List;

import com.FabRoadies.entity.User;

public interface UserService {



	List<User> getAllUser();

	User getByCode(int id);

	void updateUser(int id, User user);

	void removeUser(int code);

	void addUser(User user, int roll);


}
