package com.FabRoadies.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabRoadies.entity.Roles;

public interface RollRepo extends JpaRepository<Roles,Integer>  {

	
}
