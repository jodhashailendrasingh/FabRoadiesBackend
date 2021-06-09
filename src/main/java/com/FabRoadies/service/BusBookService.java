package com.FabRoadies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.dto.BookingRequest;
import com.FabRoadies.entity.Bus;
import com.FabRoadies.entity.Passenger;
import com.FabRoadies.entity.Ticket;
import com.FabRoadies.repo.BusRepository;
import com.FabRoadies.repo.PassengerRepo;


@Service
public class BusBookService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private PassengerRepo passengerRepository;

    @Autowired
    private Ticket reservationRepository;
	public Ticket bookBus(BookingRequest reservationRequest) {
		
      
        String busno=reservationRequest.getBusno();
     
		Optional<Bus> busOptional=busRepository.findById(busno);
        if (!busOptional.isPresent()) {
            throw new RuntimeException();
        }
      
        Bus bus=busOptional.get();
        Passenger passenger=new Passenger();
        passenger.setSeatno(reservationRequest.getSeatno());
        passenger.setName(reservationRequest.getName());
        passenger.setGender(reservationRequest.isGender());
        passenger.setAge(reservationRequest.getAge());

        passengerRepository.save(passenger);
       

       // Ticket reservation=new Ticket();
        // reservation.setBus(bus);
        // reservation.setUser();
         
         
      //  reservation.setPassenger(passenger);
      //  reservation.setCheckedin(false);
       // Ticket savedReservation = reservationRepository.save(reservation);
       


      
       // return savedReservation;
return null;
    }
}
