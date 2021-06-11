package com.fabRoadies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabRoadies.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}