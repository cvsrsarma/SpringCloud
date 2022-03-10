package com.claimvantage.Style.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class Employee {
	private int id;
	private String name;
	private String designation;
	private String gender;
	public long salary;
}
