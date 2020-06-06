package com.developerground.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;

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
}
