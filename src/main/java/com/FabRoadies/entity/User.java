package com.FabRoadies.entity;



import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String name;
    private String phoneNumber;
    @OneToMany
    private List<Ticket> tickets;
    
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="roll_id")
	private Roles roll;
<<<<<<< HEAD

=======
	  @OneToMany
	    private List<Ticket> tickets;
>>>>>>> f882a68260f44186b2cb9aa833716a99ace8d06b
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Roles getRoll() {
		return roll;
	}
	public void setRoll(Roles roll) {
		this.roll = roll;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
}
