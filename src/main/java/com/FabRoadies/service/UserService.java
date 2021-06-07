package com.FabRoadies.service;

import java.util.List;

import com.FabRoadies.entity.User;

public interface UserService {

	void addUser(User user);

	List<User> getAllUser();

	User getByCode(int id);

	void removeFlight(int code);

	void updateFlight(int id, User user);

}
