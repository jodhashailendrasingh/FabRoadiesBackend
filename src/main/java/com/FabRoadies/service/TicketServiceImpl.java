package com.FabRoadies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FabRoadies.entity.Bus;
import com.FabRoadies.entity.Ticket;
import com.FabRoadies.entity.User;
import com.FabRoadies.repo.BusRepository;
import com.FabRoadies.repo.TicketRepo;
import com.FabRoadies.repo.UserRepo;

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
		temp.setSeat(numberOfSeat);
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
		User user = userrepo.getById(userId);
		return user.getTickets();
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
		return repo.getById(id);
	}
}