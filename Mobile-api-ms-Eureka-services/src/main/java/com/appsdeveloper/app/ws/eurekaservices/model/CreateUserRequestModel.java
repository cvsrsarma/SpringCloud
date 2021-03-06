package com.appsdeveloper.app.ws.eurekaservices.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class CreateUserRequestModel {
	
	@NotNull(message="First name cant be null.")
	@Size(min=2, message="First name cant be less than 2 chars")
	private String firstName;
	@NotNull(message="Last name cant be null.")
	@Size(min=2, message="Last name cant be less than 2 chars")
	private String lastName;
	@Email(message="Email is mandatory")
	private String email;
	@NotNull(message="First name cant be null.")
	@Size(min=8, max=16, message="Password cant be less than 8 chars and Cant be gater than 16 chars" )
	private String password;

}
