package com.FabRoadies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.dto.BookingRequest;
import com.FabRoadies.entity.Bus;
import com.FabRoadies.entity.Passenger;
import com.FabRoadies.entity.Ticket;
import com.FabRoadies.entity.User;
import com.FabRoadies.repo.BusRepository;
import com.FabRoadies.repo.PassengerRepo;
import com.FabRoadies.repo.TicketRepo;
import com.FabRoadies.repo.UserRepo;

@Service
public class BusBookService {

	@Autowired
	private BusRepository busRepository;
	@Autowired
	private PassengerRepo passengerRepository;

	@Autowired
	private TicketRepo reservationRepository;
	@Autowired
	private UserRepo userRepository;

	public Ticket bookBus(BookingRequest reservationRequest) {

		///////// Ticket add///////////

		String busno = reservationRequest.getBusno();
		int userid = reservationRequest.getUserid();

		Optional<Bus> busOptional = busRepository.findById(busno);

		if (!busOptional.isPresent()) {
			throw new RuntimeException();
		}

		Bus bus = busOptional.get();
		Optional<User> userOptional = userRepository.findById(userid);
		User user = userOptional.get();
		Ticket reservation = new Ticket();
		reservation.setBus(bus);
		reservation.setUser(user);
		Ticket savedReservation = reservationRepository.save(reservation);

		///////// Passenger add///////////

		Passenger passenger = new Passenger();
		passenger.setSeatno(reservationRequest.getSeatno());
		passenger.setName(reservationRequest.getName());
		passenger.setGender(reservationRequest.isGender());
		passenger.setAge(reservationRequest.getAge());
		// passenger.setTicket(reservation);
		passenger.setTicket(reservationRepository.getById((long) 39));
		passengerRepository.save(passenger);

		return savedReservation;

		// return null;
	}
}