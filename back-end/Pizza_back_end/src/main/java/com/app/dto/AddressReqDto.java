package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressReqDto {

	private String fullAddress;
	
	private String landmark;
	
	private String city;
	
	private String country;
	
	private int pincode;
	
	
}
