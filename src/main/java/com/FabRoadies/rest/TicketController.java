package com.FabRoadies.rest;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.entity.Ticket;
import com.FabRoadies.service.TicketService;

@CrossOrigin
@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	///////
	 @Autowired
	 private JavaMailSender sender;
	 /////
	 @GetMapping("sendmail")
	    private void sendEmail() throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setTo("shailendrasingh9649933029@gmail.com");
	        helper.setText("How are you?");
	        helper.setSubject("Hi");
	         
	        sender.send(message);
	    }
	    
	    
	

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
