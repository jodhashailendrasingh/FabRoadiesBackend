package com.FabRoadies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Passenger {
	    @Id
	    private int seatno;
	    private String name;
	    private boolean gender;
	    private int age;
		@JsonBackReference
		@ManyToOne
		@JoinColumn(name="ticket_id")
		private Ticket ticket;
	    
		public int getSeatno() {
			return seatno;
		}
		public void setSeatno(int seatno) {
			this.seatno = seatno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean getGender() {
			return gender;
		}
		public void setGender(boolean gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	   
	    
}