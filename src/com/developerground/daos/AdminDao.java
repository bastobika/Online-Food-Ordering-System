package com.developerground.daos;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.Admin;
import com.developerground.entities.Caterer;

@Repository("adminDao")
public class AdminDao {
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean authenticate(String name, String password) {
		
		boolean loginFlag = false;
		Session session = sessionFactory.getCurrentSession();
		Query<Admin> query = session.createQuery("from admin where name=:name and password=:password",Admin.class);
		query.setParameter("name", name);
		query.setParameter("password", password);
		if( !query.getResultList().isEmpty() ) {
			loginFlag = true;
		}
		return loginFlag;
	}
	
	@Transactional
	public List<Caterer> getRequests() {
		Session session = sessionFactory.getCurrentSession();
		Query<Caterer> query = session.createQuery("from caterers where status='Pending'",Caterer.class);
		List<Caterer> catererRequests = query.getResultList();
		return catererRequests;
	}

	@Transactional
	public void updateStatus(Caterer caterer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(caterer);
	}
}
