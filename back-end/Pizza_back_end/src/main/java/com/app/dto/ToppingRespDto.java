package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ToppingRespDto 
{
	private Integer Id;
	
	private String toppingName;
	
	private String toppingPrice;
	
	private String toppingImagePath;
}
