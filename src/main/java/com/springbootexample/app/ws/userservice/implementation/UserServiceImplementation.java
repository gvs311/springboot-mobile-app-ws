package com.springbootexample.app.ws.userservice.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.app.ws.shared.UtilityClass;
import com.springbootexample.app.ws.ui.model.request.UserDetailsRequestModel;
import com.springbootexample.app.ws.ui.model.response.UserRest;
import com.springbootexample.app.ws.userservice.UserService;

@Service
//Used for Dependency Injection
public class UserServiceImplementation implements UserService{
	
	Map<String, UserRest> users;
	UtilityClass utils;
	
	public UserServiceImplementation() {
		
	}
	
	@Autowired
	//Dependency Injection through Constructor
	public UserServiceImplementation(UtilityClass utils) {
		this.utils = utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserID();
		returnValue.setUserId(userId);
		
		if(users == null) {
			users = new HashMap();
		}
		
		users.put(userId, returnValue);
		
		return returnValue;
	}

}
