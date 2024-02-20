package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRespDto {

	private String fullAddress;

	private String landmark;

	private String city;

	private String country;

	private int pincode;

	private UserRespDto user;
}
