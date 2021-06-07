package com.FabRoadies.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bus {



    @Id
    private String busno;
    private String agency;
    private String departurecity;
    private String arrivalcity;
    @Temporal(TemporalType.DATE)
    private Date dateofdeparture;
    //localtime(temporalValue)
    //@Temporal(TemporalType.TIME)
   // private LocalTime departuretime;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    private Date departuretime;
    
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(String departurecity) {
		this.departurecity = departurecity;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	
	public Date getDateofdeparture() {
		return dateofdeparture;
	}
	public void setDateofdeparture(Date dateofdeparture) {
		this.dateofdeparture = dateofdeparture;
	}
	public Date getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}
	
	
	
	
	
    
    
    
}