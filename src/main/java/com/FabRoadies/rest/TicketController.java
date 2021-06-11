package com.fabRoadies.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.entity.Ticket;
import com.fabRoadies.service.TicketService;

@CrossOrigin
@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	///////
	
	@PostMapping(value="/add/ticket/{busId}/{userId}/{noOfSeat}",consumes="application/json")
	public Ticket addTicket(@PathVariable("busId") String busId,@PathVariable("userId") int userId,@PathVariable int noOfSeat) {
		return service.bookTicket(busId, userId, noOfSeat);
	}
	
	@PutMapping(value="/cancel/{ticketId}")
	public void cancelBookTicket(@PathVariable("ticketId") Long ticketId) {
		service.cancelBookTicket(ticketId);
	}
	
	@GetMapping(value="/get/userTickets/{userId}",produces="application/json")
	public List<Ticket> getAllTicketOfUser(@PathVariable("userId") int userId){
		return service.getAllTicketsOfUser(userId);
	}
	
	@DeleteMapping(value="/delete/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Long ticketId) {
		service.deleteTicket(ticketId);
	}
	
	@GetMapping(value="/get/tickets",produces="application/json")
	public List<Ticket> getAllTicket(){
		return service.getAllTickets();
	}
	
	@GetMapping(value="/get/ticket/{ticketId}",produces="application/json")
	public Ticket getTicketById(@PathVariable("ticketId") Long ticketId){
		return service.getTicketById(ticketId);
	}
}
