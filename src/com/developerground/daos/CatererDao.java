package com.developerground.daos;

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
public class CatererDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Transactional
		public String signUp(Caterer caterer) {
			
			String status = null;
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> catererQuery = session.createQuery("from caterers where Email=:email or Phone=:phone", Caterer.class);
			catererQuery.setParameter("email",caterer.getEmail());
			catererQuery.setParameter("phone", caterer.getPhone());
			Query<Customer> customerQuery = session.createQuery("from customers where Email=:email or Phone=:phone", Customer.class);
			customerQuery.setParameter("email",caterer.getEmail());
			customerQuery.setParameter("phone", caterer.getPhone());
			if( catererQuery.getResultList().isEmpty() && customerQuery.getResultList().isEmpty()) {
				status = "pending";
				session.save(caterer);
			}else {
				status = "duplicateEntry";
			}
			return status;
		}

		public String addFoodItem(FoodItem foodItem, String email) {
			String additionStatus = "failed";
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> query = session.createQuery("from caterers where Email=:email", Caterer.class);
			query.setParameter("email",email);
			if( !query.getResultList().isEmpty() ) {
				foodItem.setCaterer(query.getResultList().get(0));
				session.save(foodItem);
				additionStatus = "success";
			}
			return additionStatus;
		}

		public List<FoodItem> viewFoodItems() {
			Session session = sessionFactory.getCurrentSession();
			Query<FoodItem> query = session.createQuery("from food_items", FoodItem.class);
			List<FoodItem> foodItems = query.getResultList();
			return foodItems;
		}
}
