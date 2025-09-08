package com.springbootexample.app.ws.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotBlank(message = "First Name cannot be blank")
	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, message = "First name must be atleast 2 characters")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank")
	@NotNull(message = "Last Name cannot be null")
	@Size(min = 2, message = "Last name must be atleast 2 characters")
	private String lastName;

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
	
	
}
