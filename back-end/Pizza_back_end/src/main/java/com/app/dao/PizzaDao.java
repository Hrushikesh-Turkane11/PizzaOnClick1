package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Pizza;

public interface PizzaDao extends JpaRepository<Pizza, Integer> {

}
