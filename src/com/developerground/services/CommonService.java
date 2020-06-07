package com.developerground.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CommonDao;

@Component
public class CommonService {
		
		@Autowired
		private CommonDao commonDao;
		
		public Map<String, String> authenticate(String email,String password){
			return commonDao.authenticate(email, password);		
		}
}
