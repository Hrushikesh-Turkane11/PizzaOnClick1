package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.User;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

	Address findByUser(User user);
}
