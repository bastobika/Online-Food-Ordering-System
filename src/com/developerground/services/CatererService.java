package com.developerground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CatererDao;
import com.developerground.entities.Caterer;
import com.developerground.entities.FoodItem;
import com.developerground.entities.Order;

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

		public List<FoodItem> viewFoodItems(String catererID) {
			return catererDao.viewFoodItems(catererID);
		}

		public List<Order> viewOrders(String catererID) {
			return catererDao.viewOrders(Integer.parseInt(catererID));
		}

		public FoodItem updateFood(String foodItemID) {
			return catererDao.updateFood(Integer.parseInt(foodItemID));
		}

		public String updateFoodItem(FoodItem foodItem,String email) {
			return catererDao.updateFoodItem(foodItem,email);
		}

		public void deleteFood(String foodItemID) {
			catererDao.deleteFood(Integer.parseInt(foodItemID));
		}

		public Caterer getCaterer(String catererID) {
			return catererDao.getCaterer(Integer.parseInt(catererID));
		}

		public void deleteCaterer(String email) {
			catererDao.deleteCaterer(email);
		}

		public void updateCatererInfo(Caterer caterer) {
			catererDao.updateCatererInfo(caterer);
		}

		public void updateOrderStatus(String orderID) {
			catererDao.updateOrderStatus(Integer.parseInt(orderID));
		}

}
