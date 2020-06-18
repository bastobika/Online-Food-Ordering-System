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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="order")
@Table(name="orders")
public class Order {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Order_ID",nullable=false,unique=true)
		private int ID;
		
		@Column(name="Status",nullable=false)
		private String status;
		
		@Column(name="Order_Total",nullable=false)
		private int orderTotal;
		
		@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		@JoinColumn(name="Order_ID", referencedColumnName="Order_ID")
		private List<OrderedItem> orderedItems;                        //When we delete an order,all ordered items will also be deleted
		
		
		@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Customer_ID",referencedColumnName="Customer_ID")
		private Customer customer;
		
		@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="Caterer_ID",referencedColumnName="Caterer_ID")
		private Caterer caterer;
		
		public Order() {}

		public Order(String status, int orderTotal,List<OrderedItem> orderedItems) {
			this.status = status;
			this.orderTotal = orderTotal;
			this.orderedItems = orderedItems;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<OrderedItem> getOrderedItems() {
			return orderedItems;
		}

		public void setOrderedItems(List<OrderedItem> orderedItems) {
			this.orderedItems = orderedItems;
		}

		public void addOrderedItem(OrderedItem orderedItem) {
			if(this.orderedItems.isEmpty()) {
				this.orderedItems = new ArrayList<OrderedItem>();
			}
			orderedItems.add(orderedItem);
		}
		public int getOrderTotal() {
			return orderTotal;
		}

		public void setOrderTotal(int orderTotal) {
			this.orderTotal = orderTotal;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Caterer getCaterer() {
			return caterer;
		}

		public void setCaterer(Caterer caterer) {
			this.caterer = caterer;
		}

		@Override
		public String toString() {
			return "Order [ID=" + ID + ", status=" + status + ", orderTotal=" + orderTotal + ", orderedItems="
					+ orderedItems + "]";
		}
		
}
