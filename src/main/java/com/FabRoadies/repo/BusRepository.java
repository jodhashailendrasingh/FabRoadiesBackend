package com.FabRoadies.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabRoadies.entity.Bus;

public interface BusRepository extends JpaRepository<Bus,String> {

	//List<Bus> findBuses(String source, String destination, Date departDate);

}
