package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Topping;

public interface ToppingDao extends JpaRepository<Topping, Integer> 
{
		
}
