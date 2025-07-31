package com.springbootexample.app.ws.ui.model.request;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public class UserDetailsRequestModel {
	//override default messages
	@NotBlank(message = "First Name cannot be blank")
	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, message = "First name must be atleast 2 characters")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank")
	@NotNull(message = "Last Name cannot be null")
	@Size(min = 2, message = "Last name must be atleast 2 characters")
	private String lastName;
	
	@NotBlank(message = "Email cannot be blank")
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message="Password cannot be null")
	@Size(min=8,max=16, message="Password must be equal or grater than 8 characters and less than 16 chaeracters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		System.out.println("setPassword called");
		this.password = password;
	}
	
}
