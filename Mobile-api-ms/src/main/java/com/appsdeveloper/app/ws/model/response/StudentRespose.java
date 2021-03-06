package com.appsdeveloper.app.ws.model.response;

import java.util.ArrayList;
import java.util.List;

import com.appsdeveloper.app.ws.entity.Student;
import com.appsdeveloper.app.ws.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class StudentRespose {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private List<SubjectResponse> subList;
	
	public StudentRespose(Student student) {
		this.id=student.getId();
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.email=student.getEmail();
		this.street=student.getAddress().getStreet();
		this.city=student.getAddress().getCity();
	}
}
