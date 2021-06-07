package com.FabRoadies.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Role {
	private String name;

    @OneToMany(mappedBy = "roles")
    private Set<User> users;
    

	@OneToMany(mappedBy = "roles")
    private Admin admin;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	

}
