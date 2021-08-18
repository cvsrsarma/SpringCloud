package com.appsdeveloper.app.ws.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor
public class User {
	private String firstName;
	private String lastName;
	private String userId;
	private String email;
}
