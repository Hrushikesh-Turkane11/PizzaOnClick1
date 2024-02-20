package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exp.CustomExp;
import com.app.dao.DeliveryDao;
import com.app.dao.PaymentDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.DeliveryReqDto;
import com.app.dto.DeliveryRespDto;
import com.app.dto.PaymentRespDto;
import com.app.pojos.Delivery;
import com.app.pojos.Payment;
import com.app.pojos.Status;
import com.app.pojos.User;

@Service
@Transactional
public class DeliveryServicesImpl implements DeliveryServices{

	@Autowired
	private DeliveryDao deldao;
	
	@Autowired
	private UserDao	userdao;
	
	@Autowired
	private PaymentDao paydao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<DeliveryRespDto> getAllDelivery() {
		return deldao.findAll().stream().map(e->mapper.map(e, DeliveryRespDto.class)).collect(Collectors.toList());
	}

	@Override
	public DeliveryRespDto getDeliveryByUser(Integer id) {
		
		User user=userdao.findById(id).orElseThrow(()->new CustomExp("user not exists"));
		Delivery del=deldao.findByPaymentUser(user);
		System.out.println(del);
		DeliveryRespDto deldto=new DeliveryRespDto();
		deldto.setDeliveredBy(del.getDeliveredBy());
		deldto.setDeliveryDesc(del.getDeliveryDesc());
		deldto.setDeliveryTime(del.getDeliveryTime());
		deldto.setPayment(mapper.map(del.getPayment(), PaymentRespDto.class));
		
		return deldto;
	}

	@Override
	public ApiResponse issueDelivery(Integer id, DeliveryReqDto delreqdto) {
		Payment payment=paydao.findById(id).orElseThrow(()->new CustomExp("Payment not done yet"));
		Delivery deli=deldao.findById(id).orElseThrow();
		if(deli==null) {
		Delivery del=mapper.map(delreqdto, Delivery.class);
		del.setDeliveredBy(delreqdto.getDeliveredBy());
		del.setDeliveryDesc(delreqdto.getDeliveryDesc());
		del.setDeliveryTime(LocalDate.now());
		del.setDeliveryStatus(Status.DELIVERED);
		del.setPayment(payment);
		deldao.save(del);
		return new ApiResponse("Delivery Successfull");
		}
		return new ApiResponse("Already Delivered");
	}

	
}
