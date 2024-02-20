package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exp.CustomExp;
import com.app.dao.PizzaDao;
import com.app.dao.ToppingDao;
import com.app.dto.ToppingReqDto;
import com.app.dto.ToppingRespDto;
import com.app.pojos.Pizza;
import com.app.pojos.Topping;

@Transactional
@Service
public class ToppingServiceImpl implements ToppingService{
	
	@Autowired
	private ToppingDao toppingDao;
	
	@Autowired
	private PizzaDao pizzaDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addTopping(ToppingReqDto toppingDto , Integer pizzaId) {
		
		Pizza pizza=pizzaDao.findById(pizzaId).orElseThrow(()->new CustomExp("Invalid Pizza Id"));
		Topping topping=mapper.map(toppingDto, Topping.class);
		topping.setPizza(pizza);
		toppingDao.save(topping);
		return "Topping Added Succesfully";
	}

	@Override
	public String updateTopping(Integer toppingId, ToppingReqDto toppingDto) {
		
		Topping topping=toppingDao.findById(toppingId).orElseThrow(()->new CustomExp("Invalid Topping id"));
		mapper.map(toppingDto, topping);
		toppingDao.save(topping);
		return "Topping updated Succesfully";
	}

	@Override
	public String deletePizza(Integer toppingId) {
		toppingDao.deleteById(toppingId);
		return "Topping deleted Succesfully";
	}

	@Override
	public List<ToppingRespDto> getAllTopping() {
			
		return toppingDao.findAll().stream().map(e->mapper.map(e, ToppingRespDto.class)).collect(Collectors.toList());
	}

	@Override
	public ToppingRespDto getToppingById(Integer toppingId) {
		
		Topping topping= toppingDao.findById(toppingId).orElseThrow(()->new CustomExp("Invalid Id"));
		return mapper.map(topping, ToppingRespDto.class);
	}

}
