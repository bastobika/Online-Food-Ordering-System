package com.developerground.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name="admin")
@Table(name="admin")
public class Admin implements Serializable {
		
	/**
	 Adding generated Serial Version ID
	 */
	private static final long serialVersionUID = 6350079479188841161L;

	@Id
	@Column(name="Admin_ID", nullable=false)
	private int ID;
	
	@Id
	@Column(name="Name", unique=true)
	private String name;
	
	@Column(name="password")
	private String password;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", name=" + name + ", password=" + password + "]";
	}
	
}
