package com.fabRoadies.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.repo.BusRepository;



@Service
public class BusService {

	@Autowired
	BusRepository busRepository;
	
	public void save(Bus bus)
	{  busRepository.save(bus);
		
	}
	
	public void delete(Bus bus)
	{  busRepository.delete(bus);
		
	}
	
	public List<Bus> findBuses(String source,String destination, LocalDate departDate)
	{
		return busRepository.findBuses(source,destination,departDate);
//		return null;
	}
	
	public List<Bus> findBuses()
	{
		return busRepository.findAll();

	}
	public Bus getBusById(String busno) {
		return busRepository.getById(busno);
	}
}
