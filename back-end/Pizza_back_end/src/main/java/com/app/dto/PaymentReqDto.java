package com.app.dto;

import com.app.pojos.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentReqDto {
	
	private double amount;

	private String paymentDesc;
	
	@JsonIgnore
	private Status paymentStatus;
}
