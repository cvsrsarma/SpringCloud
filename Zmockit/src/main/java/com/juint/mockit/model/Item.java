package com.juint.mockit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter@Getter@ToString@NoArgsConstructor
public class Item {
	
	public Item(int id, String name, int price, int quanity) {
		this.id=id; this.name=name;this.price=price;this.quanity=quanity;
	}
	@Id
	private int id;
	private String name;
	private int price;
	private int quanity;
	
	@Transient
	private int value;

}
