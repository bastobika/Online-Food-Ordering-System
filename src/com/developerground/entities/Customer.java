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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity(name="customer")
@Table(name="customers")
public class Customer {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Customer_ID", nullable=false, unique=true )
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
		
		@Column(name="Preference", nullable=false)
		private String preference;
		
		@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="customer")
		private List<CartItem> cartItems;   //If we delete a customer, we delete all her/his cart items
		
		@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="customer")
		private List<Order> orders;            

		
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
		public List<CartItem> getCartItems() {
			return cartItems;
		}
		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}
		public void addToCart(FoodItem foodItem, int units) {
			boolean added = false;
			if(cartItems.isEmpty()) {
				cartItems = new ArrayList<CartItem>();
			}
			for (CartItem cartItem : cartItems) {
				if (cartItem.getFoodItem().getID() == foodItem.getID()) {
					cartItem.setUnits(cartItem.getUnits() + units);
					added = true;
					break;
				}
			}
			if (!added) {
				CartItem cartItem = new CartItem(foodItem,units);
				cartItem.setCustomer(this);
				cartItems.add(cartItem);
			}
		}
		public List<Order> getOrders() {
			return orders;
		}
		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		
		public void addOrder(Order order) {
			if(orders.isEmpty()) {
				orders = new ArrayList<Order>();
			}
			orders.add(order);
		}
		@Override
		public String toString() {
			return "Customer [ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
					+ password + ", preference=" + preference + "]";
		}

}
