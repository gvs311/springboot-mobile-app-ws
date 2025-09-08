package com.springbootexample.app.ws.userservice;

import com.springbootexample.app.ws.ui.model.request.UserDetailsRequestModel;
import com.springbootexample.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userRequest);
	
}
