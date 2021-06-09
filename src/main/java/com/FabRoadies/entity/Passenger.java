package com.FabRoadies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passenger {
	    @Id
	    private int seatno;
	    private String name;
	    private boolean gender;
	    private int age;
	    
	    
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
		public boolean isGender() {
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
