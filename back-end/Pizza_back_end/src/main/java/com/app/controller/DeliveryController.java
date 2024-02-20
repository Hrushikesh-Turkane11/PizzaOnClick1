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

import com.app.dto.DeliveryReqDto;
import com.app.dto.DeliveryRespDto;
import com.app.services.DeliveryServices;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	DeliveryServices delservice;
	
	
	@GetMapping
	public ResponseEntity<?> getAllDelivery(){
		return ResponseEntity.ok(delservice.getAllDelivery());
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getDeliveryByUser(@PathVariable Integer userid){
		DeliveryRespDto del=delservice.getDeliveryByUser(userid);
		
		
		if(del!=null) return ResponseEntity.ok(del);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not exist");
	}
	
	@PostMapping("/{userid}")
	public ResponseEntity<?> postDelivery(@PathVariable Integer userid,@RequestBody DeliveryReqDto dto){
		return ResponseEntity.ok(delservice.issueDelivery(userid, dto));
	}
}
