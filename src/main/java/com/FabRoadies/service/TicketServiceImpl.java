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
	public void cancelBookTicket(Long ticketId, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getAllTicketsOfUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Ticket getTicket(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
