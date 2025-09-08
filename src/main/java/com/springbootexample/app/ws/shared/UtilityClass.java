package com.springbootexample.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UtilityClass {
	public String generateUserID() {
		String userId = UUID.randomUUID().toString();
		return userId;
	}
}
