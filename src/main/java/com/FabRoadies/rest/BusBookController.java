package com.FabRoadies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FabRoadies.dto.BookingRequest;
import com.FabRoadies.entity.Ticket;
import com.FabRoadies.service.BusBookService;

@RestController
@CrossOrigin(origins= {"*"})
public class BusBookController {
	@Autowired
    private BusBookService reservationService;

	@RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
	 public String completeReservation(@RequestBody BookingRequest reservationRequest){
      
        Ticket reservation=reservationService.bookBus(reservationRequest);
        return null;
      
    }  
	
}
