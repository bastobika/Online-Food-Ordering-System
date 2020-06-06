package com.developerground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CatererDao;
import com.developerground.entities.Caterer;
import com.developerground.entities.FoodItem;

@Component
public class CatererService {
		
		@Autowired
		private CatererDao catererDao;
		
		public String signUp(Caterer caterer) {
			
			caterer.setRating(0);
			caterer.setStatus("Pending");
			return catererDao.signUp(caterer);
		}

		public String addFoodItem(FoodItem foodItem, String email) {
			return catererDao.addFoodItem(foodItem,email);
		}

		public List<FoodItem> viewFoodItems() {
			return catererDao.viewFoodItems();
		}
}
