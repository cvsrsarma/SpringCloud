package com.appsdeveloper.app.ws.eurekaservices.api.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.app.ws.eurekaservices.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@RequestMapping("/stauts/check")
	public String status() {
		return "Users Working";
	}
	
	@PostMapping()
	public String createUser(@RequestBody CreateUserRequestModel createUSer) {
		return "User created";
	}

}
