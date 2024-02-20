package com.app.services;

import java.util.List;

import com.app.dto.PizzaReqDto;
import com.app.dto.PizzaRespDto;

public interface PizzaService 
{
	
	public PizzaReqDto addNewPizzaWithImage(PizzaReqDto dto);
	
	public String deletePizza(Integer pizzaId);
	
	public String updatePizza(Integer pizzaId, PizzaReqDto pizzaDto);
	
	public List<PizzaRespDto> getAllPizza();
	
	//public String addPizzaWithImage(PizzaReqDto pizzaDto, MultipartFile image);
}
