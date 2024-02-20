package com.app.services;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PaymentReqDto;
import com.app.dto.PaymentRespDto;

public interface PaymentService {

	 List<PaymentRespDto> getAllPaymentWithUSer(Integer userId);
	
	 ApiResponse makePayment(Integer orderId,Integer userId,PaymentReqDto paydto);
	 
	 List<PaymentRespDto> getAllPayments();
}
