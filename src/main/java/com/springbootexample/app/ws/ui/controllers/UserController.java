package com.springbootexample.app.ws.ui.controllers;

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

import com.springbootexample.app.ws.ui.model.request.UserDetailsRequestModel;
import com.springbootexample.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
	
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
		UserRest returnValue = new UserRest();
		returnValue.setEmail("xyz@email.com");
		returnValue.setFirstName("abc");
		returnValue.setLastName("sfd");
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		//return body and status code
	}
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
	//consume and respond with both JSON and XML
	//save the input into userDetails
	//create returnValue by retrieving the values from userDetails
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		System.out.println(userDetails);
		System.out.println(userDetails.getPassword());
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setUserId("1");
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser(){
		return "delete user was called";
	}
}
