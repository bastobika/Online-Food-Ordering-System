package com.developerground.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity(name="food_items")
public class FoodItem {
		
		@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		@JoinColumn(name="Caterer_ID")
		private Caterer caterer;
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Food_ID", nullable=false, unique=true)
		private int ID;
		
		@Column(name="Name", nullable=false)
		private String name;
		
		@Column(name="Quantity", nullable=false)
		private int quantity;

		@Column(name="Price_In_Rupees", nullable=false)
		private int price;

		@Column(name="Rating", nullable=false)
		private double rating;
		
		@Column(name="Food_Type", nullable=false )
		private String foodType;
		
		public String getFoodType() {
			return foodType;
		}
		public void setFoodType(String foodType) {
			this.foodType = foodType;
		}
		
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
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		public Caterer getCaterer() {
			return caterer;
		}
		public void setCaterer(Caterer caterer) {
			this.caterer = caterer;
		}
		@Override
		public String toString() {
			return "FoodItem [ID=" + ID + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", rating="
					+ rating + "]";
		}
}
