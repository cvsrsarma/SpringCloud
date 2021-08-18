package com.appsdeveloper.app.ws.model.reqeust;


import javax.validation.constraints.NotNull;

import com.appsdeveloper.app.ws.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class UpdateStudent {
	
	@NotNull(message="Id shount not be null")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	public UpdateStudent(Student stdent) {
		this.firstName=stdent.getFirstName();
		this.lastName=stdent.getLastName();
		this.email=stdent.getEmail();
	}
	
	

}
