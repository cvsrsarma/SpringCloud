package com.appsdeveloper.app.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appsdeveloper.app.ws.model.reqeust.CreateStudent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@NoArgsConstructor@AllArgsConstructor@Getter
@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String street;
	private String city;

	public Address(CreateStudent student) {
		this.street=student.getStreet();
		this.city=student.getCity();
	}
}
