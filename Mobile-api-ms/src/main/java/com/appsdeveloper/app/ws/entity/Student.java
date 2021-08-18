package com.appsdeveloper.app.ws.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.appsdeveloper.app.ws.model.reqeust.CreateStudent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@Entity(name="Student")
@AllArgsConstructor@NoArgsConstructor
public class Student {

	public Student(CreateStudent student) {
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.email=student.getEmail();
	}
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy = "student")
	private List<Subject> learningSubjects;
	
}
