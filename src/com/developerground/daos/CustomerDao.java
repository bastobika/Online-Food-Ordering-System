package com.developerground.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;
import com.developerground.entities.FoodItem;

@Repository
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String signUp(Customer customer) {
		
		String status = null;
		Session session = sessionFactory.getCurrentSession();
		Query<Caterer> catererQuery = session.createQuery("from caterers where Email=:email or Phone=:phone", Caterer.class);
		catererQuery.setParameter("email",customer.getEmail());
		catererQuery.setParameter("phone", customer.getPhone());
		Query<Customer> customerQuery = session.createQuery("from customers where Email=:email or Phone=:phone", Customer.class);
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
	public List<Object> orderFood(String preference) {
		Session session = sessionFactory.getCurrentSession();
		Query<Object> query = session.createQuery("select a.name as catererName, a.rating as catererRating, b.ID , b.name as FoodName, b.quantity, b.price, b.rating as FoodRating from caterers a,food_items b where b.foodType in (:preference, 'Neutral') and b.ID = a.ID", Object.class);
		query.setParameter("preference", preference);
		List<Object> foodItems = query.getResultList();
		System.out.println( query.getResultList().get(0));
		return foodItems;
	}
}
