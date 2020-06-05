package com.developerground.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component("caterer")
@Entity(name="caterers")
public class Caterer {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Caterer_ID", nullable=false, unique=true )
		private int ID;
		
		@Column(name="Name", nullable=false )
		private String name;
		
		@Column(name="Email", nullable=false, unique=true )
		private String email;
		
		@Column(name="Phone", nullable=false, unique=true )
		private String phone;
		
		@Column(name="Food_Type", nullable=false )
		private String foodType;
		
		@Column(name="Rating", nullable=false )
		private double rating;
		
		@Column(name="Status", nullable=false )
		private String status;
		
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
		public String getFoodType() {
			return foodType;
		}
		public void setFoodType(String foodType) {
			this.foodType = foodType;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Caterer [ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", foodType="
					+ foodType + ", rating=" + rating + ", status=" + status + "]";
		}
}
