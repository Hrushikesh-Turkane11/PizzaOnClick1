package com.app.services;

import java.util.List;

import com.app.dto.ToppingReqDto;
import com.app.dto.ToppingRespDto;

public interface ToppingService 
{
	public String addTopping(ToppingReqDto toppingDto , Integer pizzaId);
	
	public String updateTopping(Integer toppingId,ToppingReqDto toppingDto);
	
	public String deletePizza(Integer toppingId);
	
	public List<ToppingRespDto> getAllTopping();
	
	public ToppingRespDto getToppingById(Integer toppingId);
	
}
