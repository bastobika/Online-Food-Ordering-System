package com.developerground.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CatererDao;
import com.developerground.entities.Caterer;

@Component
public class CatererService {
		
		@Autowired
		private CatererDao catererDao;
		
		public String signUp(Caterer caterer) {
			
			caterer.setRating(0);
			caterer.setStatus("Pending");
			return catererDao.signUp(caterer);
		}
}
