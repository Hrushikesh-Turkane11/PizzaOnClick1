package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryRespDto {

	private Integer Id;
	
	private String deliveredBy;

	private String deliveryDesc;

	private LocalDate deliveryTime;

	private Status deliveryStatus;

	private PaymentRespDto payment;
}
