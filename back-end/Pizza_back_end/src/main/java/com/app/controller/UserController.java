package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserReqDto;
import com.app.dto.UserRespDto;
import com.app.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody UserReqDto userdto) {
		return ResponseEntity.ok(userservice.addUser(userdto));
	}

	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.ok(userservice.getAllUsers());
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		try {
			return ResponseEntity.ok(userservice.deleteUser(userId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Integer userId, @RequestBody UserRespDto dto) {
		try {
			return ResponseEntity.ok(userservice.updateUser(userId, dto));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
