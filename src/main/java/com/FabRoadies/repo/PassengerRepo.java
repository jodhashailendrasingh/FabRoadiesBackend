package com.FabRoadies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabRoadies.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}