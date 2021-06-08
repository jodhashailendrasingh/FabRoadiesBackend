package com.FabRoadies.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

/**
 * Reperesents Ticket entity
 * @author Dhruv Marothi
 * @version 1.0
 */
@Entity
public class Ticket {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;  
    @ManyToOne
    private Bus bus;
	@NotNull
    private double price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reservationDate;
    @ManyToOne
    private User user;
    private boolean booked=true;
    private int seat;
    
    //Getters and Setters
    public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
    public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
