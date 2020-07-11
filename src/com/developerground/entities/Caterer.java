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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="caterer")
@Table(name="caterers")
public class Caterer {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Caterer_ID", nullable=false, unique=true )
		private int ID;
		
		@Column(name="Name", nullable=false )
		@NotNull(message="Name is required.")
		@Size(min=1,message="Name cannot be empty.")
		private String name;
		
		@Column(name="Email", nullable=false, unique=true )
		@NotNull(message="Email is required.")
		@Size(min=1,message="Email cannot be empty.")
		@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message="Please enter a valid email address.")
		private String email;
		 
		@Column(name="Phone", nullable=false, unique=true )
		@NotNull(message="Phone is required.")
		@Size(min=10,max=10,message="Phone number should have 10 digits.")
		@Pattern(regexp="^[0-9]*$",message="Phone number should only have numbers.")
		private String phone;
		
		@Column(name="Password", nullable=false)
		@NotNull(message="Password is required.")
		@Size(min=6,message="Password should have minimum 6 characters.")
		private String password;
		
		@Column(name="Rating", nullable=false )
		private double rating;
		
		@Column(name="Status", nullable=false )
		private String status;
		
		@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="caterer")
		private List<FoodItem> foodItems;
		
		@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="caterer")
		private List<Order> orders;            
		
		public List<Order> getOrders() {
			return orders;
		}
		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		public int getID() {
			return ID;
		}
		public void setID(int ID) {
			this.ID = ID;
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
		public void addOrder(Order order) {
			if(orders.isEmpty()) {
				orders = new ArrayList<Order>();
			}
			orders.add(order);
		}
		@Override
		public String toString() {
			return "Caterer [ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
					+ password + ", rating=" + rating + ", status=" + status + "]";
		}
}
