package com.fabRoadies.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.dto.BookingRequest;
import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.Passenger;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.BusRepository;
import com.fabRoadies.repo.PassengerRepo;
import com.fabRoadies.repo.TicketRepo;
import com.fabRoadies.repo.UserRepo;

@Service
@Transactional
public class BusBookService {


	@Autowired
	private BusRepository busRepository;
	@Autowired
	private PassengerRepo passengerRepository;

	@Autowired
	private TicketRepo reservationRepository;
	@Autowired
	private UserRepo userRepository;
	

	public Ticket bookBus(List<BookingRequest> reservationRequest) {

		///////// Ticket add///////////
		String busno = reservationRequest.get(0).getBusno();
		int userid = reservationRequest.get(0).getUserid();

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

		for(int i=0;i<reservationRequest.size();i++) {

			///////// Passenger add///////////

			Passenger passenger = new Passenger();
			passenger.setSeatno(reservationRequest.get(i).getSeatno());
			passenger.setName(reservationRequest.get(i).getName());
			passenger.setGender(reservationRequest.get(i).isGender());
			passenger.setAge(reservationRequest.get(i).getAge());
			passenger.setTicket(reservation);
//			passenger.setTicket(reservationRepository.getById((long) 39));
			passengerRepository.save(passenger);
			// return null;
		}
		return savedReservation;
	}
}