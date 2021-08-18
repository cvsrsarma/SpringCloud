package com.appsdeveloper.app.ws.model.reqeust;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor@ToString
public class CreateStudent {
	
	//@JsonProperty("first_name")
	@NotNull(message = "First Name can't be null")
	@NotBlank(message = "First Name can't be blank")
	@NotEmpty(message = "First Name can't be empty")
	private String firstName;
	private String lastName;
	@NotNull(message = "email can't be null")
	@Email(message = "Email id not valid")
	private String email;
	
	private String street;
	private String city;
	
	private List<SubjectRequest> subjectLearning;

}
