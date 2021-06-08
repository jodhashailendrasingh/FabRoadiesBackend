package com.FabRoadies.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FabRoadies.entity.Bus;

public interface BusRepository extends JpaRepository<Bus,String> {
	
	@Query("from Bus where arrivalCity=:source and departureCity=:destination and dateOfDeparture=:departDate")
	List<Bus> findBuses(String source, String destination, Date departDate);
	

}
