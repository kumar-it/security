package com.security1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {

	@Id
	private int id;
	private String name;
	private String pswd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}
