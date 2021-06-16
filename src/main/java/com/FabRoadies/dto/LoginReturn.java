package com.fabRoadies.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

<<<<<<< HEAD
@Entity
public class LoginReturn {
	
	@Id
=======
//@Entity
public class LoginReturn {
	
//	@Id
>>>>>>> e703b34c9d5aed27342ad42952b0580585c28754
	private int roleId;
	
	private int userId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
