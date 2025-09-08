package com.springbootexample.app.ws.ui.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.springbootexample.app.ws.exceptions.UserServiceException;
import com.springbootexample.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.springbootexample.app.ws.ui.model.request.UserDetailsRequestModel;
import com.springbootexample.app.ws.ui.model.response.UserRest;
import com.springbootexample.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
	
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	//Used for Dependency Injection
	
	@GetMapping
	/*required does not work well with primitive datatypes, not receiving them in the request parameter
	converts them to null
	best is to use it with String
	*/
	public String getUsers(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="20") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
			return "get users called with page: " + page + " and limit: " + limit + " and sort: " + sort;
	}
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	//return response in JSON or  format, need to pass ACCEPT header in the request
	public ResponseEntity getUser(@PathVariable String userId) {
		
		//String firstName = null;
		//int firstNameLength = firstName.length();
		
		if (true) throw new UserServiceException("A user service exception is thrown");
		
		if (users.containsKey(userId)) {
			System.out.println("Record with userId: " + userId + " exists");
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else {
			System.out.println("Record with userId: " + userId + " does not exist");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
	//consume and respond with both JSON and XML
	//save the input into userDetails
	//create returnValue by retrieving the values from userDetails
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		//Dependency Injection
		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(
			path= "/{userId}",
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		users.put(userId,  storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path= "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId){
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
