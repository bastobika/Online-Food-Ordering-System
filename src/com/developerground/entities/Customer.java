package com.developerground.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customer")
@Entity(name="customers")
public class Customer {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Customer_ID", nullable=false, unique=true )
		private int ID;
		
		@Column(name="Name", nullable=false )
		private String name;
		
		@Column(name="Email", nullable=false, unique=true )
		private String email;
		
		@Column(name="Phone", nullable=false, unique=true )
		private String phone;
		
		@Column(name="Password", nullable=false)
		private String password;
		
		@Column(name="Preference", nullable=false)
		private String preference;

		
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPreference() {
			return preference;
		}
		public void setPreference(String preference) {
			this.preference = preference;
		}
		@Override
		public String toString() {
			return "Customer [ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
					+ password + ", preference=" + preference + "]";
		}

}
