package com.FabRoadies.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FabRoadies.entity.Bus;

public interface BusRepository extends JpaRepository<Bus,String> {
	
	@Query("FROM Bus WHERE arrivalCity= :destination and departureCity= :source and dateOfDeparture= :departDate")
	List<Bus> findBuses( @Param("source") String source, @Param("destination")String destination, @Param("departDate") LocalDate departDate);
	

	

}
