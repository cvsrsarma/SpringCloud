package com.appsdeveloper.app.ws.model.reqeust;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetailsReqeust {
	@NotNull(message = "First Name can't be null")
	private String firstName;
	@NotNull(message = "Last Name can't be null")
	private String lastName;
	@NotNull(message = "User id can't be null")
	private String userId;
	@NotNull(message = "email can't be null")
	@Email(message = "Email id not valid")
	private String email;
	@NotNull(message = "Passwrod can't be null")
	@Size(min = 8, max = 16, message = "Password must be 8 chars or more")
	private String password;
}
