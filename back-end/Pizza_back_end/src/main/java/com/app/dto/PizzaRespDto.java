package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PizzaRespDto {
	
	private Integer Id;
	
	private String pizzaName;
	
	private double pizzaPrice;
	
	private String pizzaImagePath;
	
	//private byte[] image;
	

}
