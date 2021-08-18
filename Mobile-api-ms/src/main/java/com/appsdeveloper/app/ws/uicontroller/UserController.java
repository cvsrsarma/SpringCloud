package com.appsdeveloper.app.ws.uicontroller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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

import com.appsdeveloper.app.ws.exception.UserServiceException;
import com.appsdeveloper.app.ws.model.reqeust.UserDetailsReqeust;
import com.appsdeveloper.app.ws.model.response.User;
import com.appsdeveloper.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, User> users;
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public ResponseEntity<Map<String, User>> getUsers(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50",required = false) int limit,
			@RequestParam(value="sort", defaultValue = "desc",required = false) String sort) {
		
		
			
		ResponseEntity<Map<String, User>> resp = new ResponseEntity<Map<String, User>>(users, HttpStatus.OK);
		return resp;
	}
	@GetMapping(path = "/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		if(null!=users  && users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else
		
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(consumes =  {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsReqeust userDetails) {
		
		if(users==null)
			users = new HashMap<String, User>();
		User user= userService.createUser(userDetails);
		users.put(user.getUserId(), user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser(@RequestBody UserDetailsReqeust userDetails) {
		
		
		return "Update user";
	}
	
	@DeleteMapping
	public String deleteUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			users.remove(userId);
		}
		return "Delete user";
	}
	
	@GetMapping(path = "/null",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getNullPointer(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50",required = false) int limit,
			@RequestParam(value="sort", defaultValue = "desc",required = false) String sort) {
			
		User user = users.get(users.keySet().iterator().next());
		user.setFirstName(null);
		user.getFirstName().length();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping(path = "/userExcep",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUsersException(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50",required = false) int limit,
			@RequestParam(value="sort", defaultValue = "desc",required = false) String sort) {
			
		if(true)
			throw new UserServiceException("UserDefineExceptiom");
		
		return new ResponseEntity<User>(new User("","","",""), HttpStatus.OK);
	}

}
