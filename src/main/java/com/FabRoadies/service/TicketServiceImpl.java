package com.fabRoadies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.BusRepository;
import com.fabRoadies.repo.TicketRepo;
import com.fabRoadies.repo.UserRepo;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	BusRepository busrepo;
	@Autowired
	UserRepo userrepo;
	@Autowired
	TicketRepo repo;
	
	@Override
	public Ticket bookTicket(String busId, int userId, int numberOfSeat) {
		Bus bus = busrepo.getById(busId);
		User user = userrepo.getById(userId);
		Ticket temp = new Ticket();
		temp.setBus(bus);
		temp.setUser(user);
		
		return repo.save(temp);
	}

	@Override
	public void cancelBookTicket(Long ticketId) {
		Ticket temp = new Ticket();
		temp.setBooked(false);
		repo.save(temp);
	}

	@Override
	public List<Ticket> getAllTicketsOfUser(int userId) {		
//		User user = userrepo.getById(userId);
//		return user.getTickets();
		return repo.findByUserId(userId);
	}

	@Override
	public void deleteTicket(Long id) {
		repo.delete(repo.getById(id));
	}

	@Override
	public List<Ticket> getAllTickets() {
		return repo.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		return repo.findById(id).get();
	}
}
