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
import javax.persistence.Table;

@Entity(name="cartItem")
@Table(name="cart_items")
public class CartItem {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Cart_Items_ID", nullable=false)
		private int ID;
		
		@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Food_ID")
		private FoodItem foodItem;            //cascade : If we delete a cart item,we should not delete the foodItem 
		
		@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Customer_ID", referencedColumnName="Customer_ID")
		private Customer customer;            //cascade : If we delete a cart item,we should not delete the Customer 
		
		@Column(name="Cart_Units",nullable=false)
		private int units;
		
		public CartItem() {
			
		}
		public CartItem(FoodItem foodItem, int units) {
			this.foodItem = foodItem;
			this.units = units;
		}

		public FoodItem getFoodItem() {
			return foodItem;
		}

		public void setFoodItem(FoodItem foodItem) {
			this.foodItem = foodItem;
		}

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}
		
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		@Override
		public String toString() {
			return "CartItem [ID=" + ID + ", foodItem=" + foodItem + ", customer=" + customer + ", units=" + units
					+ "]";
		}
		
}
