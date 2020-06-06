package com.developerground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.AdminDao;
import com.developerground.entities.Caterer;

@Component("adminService")
public class AdminService {
		
	@Autowired
	private AdminDao adminDao;
	
	public boolean authenticate(String name, String password) {
		return adminDao.authenticate(name,password);
	}

	public List<Caterer> getRequests() {
		return adminDao.getRequests();		
	}

	public void updateStatus(int catererID, String status) {
		adminDao.updateStatus(catererID,status);
	}
}
