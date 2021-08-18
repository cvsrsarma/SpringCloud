package com.appsdeveloper.app.ws.userservice;

import com.appsdeveloper.app.ws.model.reqeust.UserDetailsReqeust;
import com.appsdeveloper.app.ws.model.response.User;

public interface UserService {
	
	User createUser(UserDetailsReqeust userDetails);

}
