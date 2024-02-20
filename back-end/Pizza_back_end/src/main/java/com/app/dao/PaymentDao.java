package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.User;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {

	List<Payment> findByUser(User user);
	
	 boolean existsByOrder(Order order);
}
