package com.appsdeveloper.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utlity {
	
	public String generateUserId() {
		String userId=UUID.randomUUID().toString();
		return userId;
	}

}
