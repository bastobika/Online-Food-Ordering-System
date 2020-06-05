package com.developerground.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developerground.entities.Caterer;

@Repository
public class CatererDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Transactional
		public String signUp(Caterer caterer) {
			
			String status = null;
			Session session = sessionFactory.getCurrentSession();
			Query<Caterer> query = session.createQuery("from caterers where Email=:email or Phone=:phone", Caterer.class);
			query.setParameter("email",caterer.getEmail());
			query.setParameter("phone", caterer.getPhone());
			if( query.getResultList().isEmpty() ) {
				status = "pending";
				session.save(caterer);
			}else {
				status = "duplicateEntry";
			}
			return status;
		}
}
