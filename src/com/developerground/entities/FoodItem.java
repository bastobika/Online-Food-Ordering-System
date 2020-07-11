package com.developerground.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity(name="food_item")
@Table(name="food_items")
public class FoodItem {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Food_ID", nullable=false, unique=true)
		private int ID;
		
		@Column(name="Name", nullable=false)
		@NotNull(message="Name is required.")
		@Size(min=1,message="Name cannot be empty.")
		private String name;
		
		@Column(name="Quantity", nullable=false)
		@NotNull(message="Quantity is required.")
		@Size(min=1,message="Quantity cannot be empty.")
		private String quantity;

		@Column(name="Price_In_Rupees", nullable=false)
		@NotNull(message="Price is required.")
		private Integer price;

		@Column(name="Rating", nullable=false)
		private double rating;
		
		@Column(name="Food_Type", nullable=false )
		private String foodType;
		
		@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
		@JoinColumn(name="Caterer_ID", referencedColumnName="Caterer_ID")
		private Caterer caterer;
		
		@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="foodItem")
		private List<OrderedItem> orderedItems;
		
		public String getFoodType() {
			return foodType;
		}
		public void setFoodType(String foodType) {
			this.foodType = foodType;
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
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
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
