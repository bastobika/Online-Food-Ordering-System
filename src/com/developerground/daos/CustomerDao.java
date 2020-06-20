package com.developerground.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.CartItem;
import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;
import com.developerground.entities.FoodItem;
import com.developerground.entities.Order;
import com.developerground.entities.OrderedItem;

@Repository
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String signUp(Customer customer) {
		
		String status = null;
		Session session = sessionFactory.getCurrentSession();
		Query<Caterer> catererQuery = session.createQuery("from caterer where Email=:email or Phone=:phone", Caterer.class);
		catererQuery.setParameter("email",customer.getEmail());
		catererQuery.setParameter("phone", customer.getPhone());
		Query<Customer> customerQuery = session.createQuery("from customer where Email=:email or Phone=:phone", Customer.class);
		customerQuery.setParameter("email",customer.getEmail());
		customerQuery.setParameter("phone", customer.getPhone());
		if( catererQuery.getResultList().isEmpty() && customerQuery.getResultList().isEmpty()) {
			status = "success";
			session.save(customer);
		}else {
			status = "duplicateEntry";
		}
		return status;
	}
	
	@Transactional
	public List<Object[]> viewFood(String preference, String customerID) {
		Session session = sessionFactory.getCurrentSession();
		Query<Object[]> query = null;
		if(preference.equalsIgnoreCase("Both")) {
			query = session.createQuery("from caterer a,food_item b where a.ID=b.caterer.ID", Object[].class);
		}else {
			query = session.createQuery("from caterer a,food_item b where b.foodType in (:preference, 'Neutral') and b.caterer.ID = a.ID", Object[].class);		
			query.setParameter("preference", preference);
		}
		List<Object[]> foodItems = query.getResultList();
		System.out.println(foodItems);
		return foodItems;
	}

	@Transactional
	public void addToCart(int foodID, int customerID, int units) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> customerQuery = session.createQuery("from customer where ID=:customerID", Customer.class);
		customerQuery.setParameter("customerID",customerID);
		Customer customer = customerQuery.getSingleResult();
		Query<FoodItem> foodItemQuery = session.createQuery("from food_item where ID=:foodID", FoodItem.class);
		foodItemQuery.setParameter("foodID",foodID);
		FoodItem foodItem = foodItemQuery.getSingleResult();
		 customer.addToCart(foodItem,units);
		session.save(customer);
	}

	@Transactional
	public List<CartItem> viewCart(int customerID) {
		Session session = sessionFactory.getCurrentSession();
		Query<CartItem> query = session.createQuery("from cartItem where Customer_ID=:customerID", CartItem.class);
		query.setParameter("customerID", customerID);
		return query.getResultList();
	}

	@Transactional
	public boolean placeOrder(List<CartItem> cartItems) {
		Session session = sessionFactory.getCurrentSession();
		int catererID = cartItems.get(0).getFoodItem().getCaterer().getID();
		int customerID = cartItems.get(0).getCustomer().getID();
		Query<Caterer> catererQuery = session.createQuery("from caterer where ID=:catererID", Caterer.class);
		catererQuery.setParameter("catererID",catererID);
		Caterer caterer = catererQuery.getSingleResult();
		Query<Customer> customerQuery = session.createQuery("from customer where ID=:customerID", Customer.class);
		customerQuery.setParameter("customerID",customerID);
		Customer customer = customerQuery.getSingleResult();
		List<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		int orderTotal = 0;
		for(CartItem cartItem : cartItems) {
			OrderedItem orderedItem = new OrderedItem(cartItem.getFoodItem(),cartItem.getUnits());
			orderTotal += cartItem.getFoodItem().getPrice() * cartItem.getUnits();
			orderedItems.add(orderedItem);
			session.delete(cartItem);
		}
		Order order = new Order("Placed",orderTotal,orderedItems,"Not Rated");
		order.setCaterer(caterer);
		order.setCustomer(customer);
		session.save(order);
		return true;
	}

	@Transactional
	public List<Order> viewOrders(String customerID) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from order where Customer_ID=:customerID",Order.class);
		query.setParameter("customerID", Integer.parseInt(customerID));
		return query.getResultList() ;
	}

	@Transactional
	public void deleteCartItem(int cartItemID) {
		Session session = sessionFactory.getCurrentSession();
		Query<?> query = session.createQuery("delete from cartItem where ID=:cartItemID");
		query.setParameter("cartItemID", cartItemID);
		query.executeUpdate();
	}

	@Transactional
	public Customer getCustomer(int customerID) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from customer where ID=:customerID",Customer.class);
		query.setParameter("customerID", customerID);
		return query.getSingleResult();
	}

	@Transactional
	public void deleteCustomer(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<?> query = session.createQuery("delete from customer where email=:email");
		query.setParameter("email", email);
		query.executeUpdate();
	}

	@Transactional
	public void updateCustomerInfo(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@Transactional
	public Object getOrder(int orderID) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from order where ID=:orderID",Order.class);
		query.setParameter("orderID", orderID);
		return query.getSingleResult();
	}

	@Transactional
	public void submitRating(String[] foodItemRatings, String[] foodItemIDs, String catererRating,String orderID) {
		Session session = sessionFactory.getCurrentSession();
		int i = 0;
		int newRating = 0;
		FoodItem foodItem = new FoodItem();
		Query<FoodItem> foodItemQuery = null;
		List<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		Query<Object[]> foodItemRatingCountQuery  = null;
		for (String foodItemID : foodItemIDs) {
			foodItemRatingCountQuery = session.createQuery("from orderedItem item, order o where item.foodItem.ID=:foodItemID and item.order.ID=o.ID and o.ratingStatus='Rated'", Object[].class);
			foodItemRatingCountQuery.setParameter("foodItemID", Integer.parseInt(foodItemID));
			for (Object[] object : foodItemRatingCountQuery.getResultList()) {
				orderedItems.add((OrderedItem) object[0]);
			}
			foodItemQuery =  session.createQuery("from food_item where ID=:foodItemID",FoodItem.class);
			foodItemQuery.setParameter("foodItemID", Integer.parseInt(foodItemID));
			foodItem = foodItemQuery.getSingleResult();
			newRating = Integer.parseInt(foodItemRatings[i]);
			foodItem.setRating(((foodItem.getRating() *  orderedItems.size()) + newRating) / ( orderedItems.size() + 1));
			session.update(foodItem);
		}
		Query<Order> orderQuery = session.createQuery("from order where ID=:orderID",Order.class);
		orderQuery.setParameter("orderID", Integer.parseInt(orderID));
		Order order = orderQuery.getSingleResult();
		order.setRatingStatus("Rated");
		Caterer caterer = order.getCaterer();
		Query<Order> catererRatingCountQuery = session.createQuery("from order where Caterer_ID=:catererID and ratingStatus='Rated'", Order.class);
		catererRatingCountQuery.setParameter("catererID", caterer.getID());
		int newCatererRating = Integer.parseInt(catererRating);
		caterer.setRating((caterer.getRating()*catererRatingCountQuery.getResultList().size() + newCatererRating ) / (catererRatingCountQuery.getResultList().size() + 1 ));
		session.update(order);
		session.update(caterer);
	}
}
