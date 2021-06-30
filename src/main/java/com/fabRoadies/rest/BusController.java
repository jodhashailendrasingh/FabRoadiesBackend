package com.fabRoadies.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.Busquery;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.service.BusService;

/**
 * This modules controls all bus activities.
 * @author Dhruv Marothi & Shailendra
 * @version 2.5
 */
@RestController
@CrossOrigin(origins = { "*" })
public class BusController {

	@Autowired
	BusService busService;

	//List all Buses wrt their source,destination,dateOfDeparture
	@PostMapping("/findBuses")
	public List<Bus> findBusesByRoute(@RequestBody Busquery query){
		List<Bus> buses = busService.findBuses(query.getSource(),query.getDestination(),query.getDateOfDeparture());
		return buses;
	}

	@GetMapping("/admin/showAllBuses")
	public List<Bus> showAllBuses() {
		return busService.findBuses();
	}

	@PostMapping("/admin/addBus")
	public void addBus(@RequestBody Bus bus) {
		busService.save(bus);
	}
	
	@DeleteMapping("/admin/deleteBus/{id}")
	public void deleteBus(@PathVariable("id") String id) {
		busService.delete(id);
	}
	
	//Updates the Bus Details
	@PutMapping(path = "/bus/edit", produces = "application/json")
	public void updateEmp(@RequestBody Bus bus) {
		busService.update(bus);
	}
	
	@GetMapping(value="/get/bus/{busid}",produces="application/json")
	public Bus getBustById(@PathVariable("busid") String busid){
		return busService.getBusById(busid);
	}
}