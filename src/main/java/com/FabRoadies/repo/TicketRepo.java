package com.FabRoadies.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FabRoadies.entity.Ticket;

/**
 * @author ibmjfsdb209
 * @version 1.0
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer>{
	List<Ticket> findByUserId(int userId);
}
