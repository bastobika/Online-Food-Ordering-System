package com.developerground.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;

@Repository
public class CommonDao {
	
		@Autowired
		private SessionFactory sessionFactory;

		@Transactional
		public Map<String, String> authenticate(String email,String password) {
			String loginFlag = null;
			HashMap<String,String> map = new HashMap<String,String>();
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> catererQuery = session.createQuery("from caterer where email=:email", Caterer.class);
			catererQuery.setParameter("email", email);
			List<Caterer> caterers = catererQuery.getResultList();
			Query<Customer> customerQuery = session.createQuery("from customer where email=:email", Customer.class);
			customerQuery.setParameter("email", email);
			List<Customer> customers = customerQuery.getResultList(); 
			if( caterers.isEmpty() && customers.isEmpty()) {
				loginFlag = "notRegistered";
			}else if ( !caterers.isEmpty() ) {
				if(caterers.get(0).getPassword().equalsIgnoreCase(password)) {
					loginFlag = "success";
					map.put("name" , caterers.get(0).getName());
					map.put("id" , Integer.toString(caterers.get(0).getID()));
					map.put("status", caterers.get(0).getStatus());
					map.put("userType","Caterer");
				}else {
					loginFlag = "failed";
				}
			}else if ( !customers.isEmpty() ) {
				if(customers.get(0).getPassword().equalsIgnoreCase(password)) {
					loginFlag = "success";
					map.put("name" , customers.get(0).getName());
					map.put("id" , Integer.toString(customers.get(0).getID()));
					map.put("preference" , customers.get(0).getPreference());
					map.put("userType","Customer");
				} else {
					loginFlag = "failed";
				}
			} 
			map.put("loginFlag", loginFlag);
			return map;
		}
}
