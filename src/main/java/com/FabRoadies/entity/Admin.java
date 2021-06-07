package com.FabRoadies.entity;

<<<<<<< HEAD:src/main/java/com/FabRoadies/entity/User.java


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
//@JsonIgnoreProperties({"tickets"})
public class User {
    @Id
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
>>>>>>> f5efda80272d03354a0fa60834abf8e040a81568:src/main/java/com/FabRoadies/entity/Admin.java
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;
    @Column(nullable = false)
    private String password;
<<<<<<< HEAD:src/main/java/com/FabRoadies/entity/User.java
    private String name;
=======
>>>>>>> f5efda80272d03354a0fa60834abf8e040a81568:src/main/java/com/FabRoadies/entity/Admin.java
    private String phoneNumber;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

<<<<<<< HEAD:src/main/java/com/FabRoadies/entity/User.java
    


=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}
	
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
>>>>>>> f5efda80272d03354a0fa60834abf8e040a81568:src/main/java/com/FabRoadies/entity/Admin.java
}
