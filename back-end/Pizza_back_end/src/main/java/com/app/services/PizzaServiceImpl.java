package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exp.CustomExp;
import com.app.dao.PizzaDao;
import com.app.dto.PizzaReqDto;
import com.app.dto.PizzaRespDto;
import com.app.pojos.Pizza;


@Service
@Transactional
public class PizzaServiceImpl implements PizzaService 
{
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PizzaDao pizzaDao;
	
	@Autowired
	PizzaImageService imageService;
	
	
		
	@Override
	public PizzaReqDto addNewPizzaWithImage(PizzaReqDto pizzaDto)  
	{
		System.out.println("In pizza service "+pizzaDto);
		Pizza pizza=mapper.map(pizzaDto, Pizza.class);
		pizzaDao.save(pizza);
		return mapper.map(pizza, PizzaReqDto.class);
	}

	@Override
	public String deletePizza(Integer pizzaId) {
		pizzaDao.deleteById(pizzaId);
		return "Pizza deleted Succesfully";
	}

	@Override
	public String updatePizza(Integer pizzaId, PizzaReqDto pizzaDto) {
		Pizza pizza=pizzaDao.findById(pizzaId).orElseThrow(()->new CustomExp("Invalid Id"));
		mapper.map(pizzaDto, pizza);
		pizzaDao.save(pizza);
		return "Pizza details updated Succesfully";
	}

	@Override
	public List<PizzaRespDto> getAllPizza() {
		
		return pizzaDao.findAll().stream().map(p->mapper.map(p, PizzaRespDto.class)).collect(Collectors.toList());
			
	}

	/*@Override
	public String addPizzaWithImage(PizzaReqDto pizzaDto, MultipartFile image) {
		
		Pizza pizza=mapper.map(pizzaDto, Pizza.class);
		
		imageService.uploadImage1(pizza, image);
		
		return "Pizza Added with image";
	}*/
	
	
	
	
		
}
