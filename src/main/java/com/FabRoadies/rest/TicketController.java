package com.FabRoadies.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.entity.Ticket;
import com.FabRoadies.service.TicketService;

@CrossOrigin
@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	
	@PostMapping(value="/add/ticket/{busId}/{userId}/{noOfSeat}",consumes="application/json")
	public Ticket addTicket(@PathVariable("busId") String busId,@PathVariable("userId") int userId,@PathVariable int noOfSeat) {
		return service.bookTicket(busId, userId, noOfSeat);
	}
	
	@GetMapping(value="/get/tickets",produces="application/json")
	public List<Ticket> getAllTicket(){
		return service.getAllTickets();
	}
}
