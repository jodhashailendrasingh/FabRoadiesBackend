package com.FabRoadies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FabRoadies.entity.Ticket;

@Service
public interface TicketService {
	Ticket bookTicket(String busId, int userId,int numberOfSeat);
    void cancelBookTicket(Long ticketId);
    List<Ticket> getAllTicketsOfUser(int userId);
    void deleteTicket(Long id);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
}
