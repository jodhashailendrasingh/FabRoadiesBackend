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
    private String departureCity;
    private String arrivalCity;
    @Temporal(TemporalType.DATE)
    private Date dateofDeparture;
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
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departurecity) {
		this.departureCity = departurecity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalcity) {
		this.arrivalCity = arrivalcity;
	}
	
	public Date getDateofDeparture() {
		return dateofDeparture;
	}
	public void setDateofDeparture(Date dateofDeparture) {
		this.dateofDeparture = dateofDeparture;
	}
	public Date getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}
	
	
	
	
	
    
    
    
}