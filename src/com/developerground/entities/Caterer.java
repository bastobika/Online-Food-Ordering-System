package com.developerground.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="caterer")
@Table(name="caterers")
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
		
		@Column(name="Password", nullable=false)
		private String password;
		
		@Column(name="Rating", nullable=false )
		private double rating;
		
		@Column(name="Status", nullable=false )
		private String status;
		
		@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="caterer")
		private List<FoodItem> foodItems;
		
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
		public List<FoodItem> getFoodItems() {
			return foodItems;
		}
		public void setFoodItems(List<FoodItem> foodItems) {
			this.foodItems = foodItems;
		}
		public void addFoodItem(FoodItem foodItem) {
			if(this.foodItems.isEmpty()) {
				this.foodItems = new ArrayList<FoodItem>();
			}
			foodItems.add(foodItem);
		}
		
		@Override
		public String toString() {
			return "Caterer [foodItems=" + foodItems + ", ID=" + ID + ", name=" + name + ", email=" + email + ", phone="
					+ phone + ", password=" + password + ", rating=" + rating + ", status=" + status + "]";
		}
}
