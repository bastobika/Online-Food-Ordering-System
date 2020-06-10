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
public class CatererDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Transactional
		public String signUp(Caterer caterer) {
			
			String status = "false";
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> catererQuery = session.createQuery("from caterer where Email=:email or Phone=:phone", Caterer.class);
			catererQuery.setParameter("email",caterer.getEmail());
			catererQuery.setParameter("phone", caterer.getPhone());
			Query<Customer> customerQuery = session.createQuery("from customer where Email=:email or Phone=:phone", Customer.class);
			customerQuery.setParameter("email",caterer.getEmail());
			customerQuery.setParameter("phone", caterer.getPhone());
			if( catererQuery.getResultList().isEmpty() && customerQuery.getResultList().isEmpty()) {
				status = "Pending";
				session.save(caterer);
			}else {
				status = "duplicateEntry";
			}
			return status;
		}
		
		@Transactional
		public String addFoodItem(FoodItem foodItem, String email) {
			String additionStatus = "failed";
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> query = session.createQuery("from caterer where Email=:email", Caterer.class);
			query.setParameter("email",email);
			if( !query.getResultList().isEmpty() ) {
					Caterer caterer = query.getResultList().get(0);
					caterer.addFoodItem(foodItem);
					session.save(caterer);
					additionStatus = "success";
			}
			return additionStatus;
		}
		
		@Transactional
		public List<FoodItem> viewFoodItems(String catererID) {
			Session session = sessionFactory.getCurrentSession();
			Query<FoodItem> query = session.createQuery("from food_item where Caterer_ID=:catererID", FoodItem.class);
			query.setParameter("catererID", catererID);
			List<FoodItem> foodItems = query.getResultList();
			return foodItems;
		}

}
