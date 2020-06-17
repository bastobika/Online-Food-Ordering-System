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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="orderedItem")
@Table(name="ordered_items")
public class OrderedItem {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Ordered_Items_ID", nullable=false)
		private int ID;
		
		@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Food_ID")
		private FoodItem foodItem;            //cascade : If we delete an ordered item,we should not delete the foodItem  
		
		@Column(name="Units",nullable=false)
		private int units;
		
		
		@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Order_ID", referencedColumnName="Order_ID")
		private Order order;
		
		public OrderedItem() {
			
		}
		public OrderedItem(FoodItem foodItem, int units) {
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

		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		@Override
		public String toString() {
			return "CartItem [ID=" + ID + ", foodItem=" + foodItem + ", units=" + units
					+ "]";
		}
		
}
