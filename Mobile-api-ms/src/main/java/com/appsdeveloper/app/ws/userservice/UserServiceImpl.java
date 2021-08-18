package com.appsdeveloper.app.ws.userservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.app.ws.model.reqeust.UserDetailsReqeust;
import com.appsdeveloper.app.ws.model.response.User;
import com.appsdeveloper.app.ws.shared.Utlity;

@Service
public class UserServiceImpl implements UserService{
	
	Utlity utlity;
	Map<String, User> userMap = null;
	
	public UserServiceImpl(){	}
	
	@Autowired
	public UserServiceImpl(Utlity utility) {
		this.utlity=utility;
	}
	
	
	public User createUser(UserDetailsReqeust userDetails) {
		
		userDetails.setUserId(utlity.generateUserId());
		User user = new User(userDetails.getFirstName(),userDetails.getLastName(),
				userDetails.getUserId(),userDetails.getEmail());
		return user;
	}
	

}
