package com.FabRoadies.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.entity.Bus;
import com.FabRoadies.repo.BusRepository;



@Service
public class BusService {

	@Autowired
	BusRepository busRepository;
	
	public void save(Bus bus)
	{  busRepository.save(bus);
		
	}
	public List<Bus> findBuses(String source,String destination, Date departDate)
	{
		return busRepository.findBuses(source,destination,departDate);
	}
	public List<Bus> findBuses()
	{
		return busRepository.findAll();

	}
}
