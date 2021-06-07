package com.FabRoadies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabRoadies.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>
	{
	

	}
