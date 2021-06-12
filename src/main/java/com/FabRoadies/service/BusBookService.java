package com.fabRoadies.service;

import java.util.ArrayList;
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
import com.fabRoadies.utils.PdfGenerator;
import com.fabRoadies.utils.SendSms;
import com.itextpdf.text.DocumentException;

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

		List<Passenger> listOfPassenger = new ArrayList<>();
		for (int i = 0; i < reservationRequest.size(); i++) {

			///////// Passenger add///////////

			Passenger passenger = new Passenger();
			passenger.setSeatno(reservationRequest.get(i).getSeatno());
			passenger.setName(reservationRequest.get(i).getName());
			passenger.setGender(reservationRequest.get(i).getGender());
			passenger.setAge(reservationRequest.get(i).getAge());
			passenger.setTicket(reservation);
//			passenger.setTicket(reservationRepository.getById((long) 39));
			listOfPassenger.add(passenger);
			passengerRepository.save(passenger);
			// return null;
		}
		try

		{
			PdfGenerator.generateItenary(listOfPassenger,
					"C:\\Users\\ibmjfsdb209\\Desktop\\Pdf\\"
							+ "Passenger.pdf");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Message Sent
//		hello This is FabRoadies.Have a safe Journey
		SendSms.sendsms("Work Done Come Back", "9649933029");
		System.out.println("message sent");
		return savedReservation;
	}
}