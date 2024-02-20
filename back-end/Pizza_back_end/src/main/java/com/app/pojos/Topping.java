package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "toppings")
public class Topping extends BaseEntity {

	private String toppingName;
	
	private String toppingPrice;
	
	private String toppingImagePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;
}
