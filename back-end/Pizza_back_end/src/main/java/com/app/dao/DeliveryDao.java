package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Delivery;
import com.app.pojos.User;

public interface DeliveryDao extends JpaRepository<Delivery, Integer> {

	
	Delivery findByPaymentUser(User user); 
}
