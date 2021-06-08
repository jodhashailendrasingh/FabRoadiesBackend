package com.FabRoadies.service;

import java.util.List;

import com.FabRoadies.entity.Ticket;

public interface TicketService {
//	Ticket bookTicket(Long connectionId, String username);
    void cancelBookTicket(Long ticketId, String username);
    List<Ticket> getAllTicketsOfUser(String username);
    void deleteTicket(Long id);
    List<Ticket> getAllTickets();
    Ticket getTicket(Long id);
}
