package com.developerground.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="food_items")
public class FoodItem {
		
		@Id
		@Column(name="Food_ID")
		private int ID;
		
		@Column(name="Name")
		private String name;
		
		@Column(name="Quantity")
		private int quantity;

		@Column(name="Price_In_Rupees")
		private int price;

		@Column(name="Rating")
		private double rating;
		
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
		@Override
		public String toString() {
			return "FoodItem [ID=" + ID + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", rating="
					+ rating + "]";
		}
}
