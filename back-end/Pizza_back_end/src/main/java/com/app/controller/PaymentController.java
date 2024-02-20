package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentReqDto;
import com.app.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService payservice;
	
	
	@GetMapping
	public ResponseEntity<?> getAllPayments(){
		return ResponseEntity.ok(payservice.getAllPayments());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllPaymentsWithUser(@PathVariable Integer userId){
		return ResponseEntity.ok(payservice.getAllPaymentWithUSer(userId));
	}
	
	@PostMapping("/{userId}/{orderId}")
	public ResponseEntity<?> makePayment(@PathVariable Integer userId,@PathVariable Integer orderId,@RequestBody PaymentReqDto dto){
		try {
			return ResponseEntity.ok(payservice.makePayment(orderId, userId, dto));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
