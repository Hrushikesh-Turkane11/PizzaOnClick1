package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exp.CustomExp;
import com.app.dao.OrderDao;
import com.app.dao.PaymentDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PaymentReqDto;
import com.app.dto.PaymentRespDto;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.Status;
import com.app.pojos.User;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paydao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private OrderDao orderdao;
	
	@Override
	public List<PaymentRespDto> getAllPaymentWithUSer(Integer userId) {
	
		User user=userdao.findById(userId).orElseThrow(()->new CustomExp("Id not exists"));
//		System.out.println(user);
		List<Payment> payment=paydao.findByUser(user);
		System.out.println(payment);
		
		List<PaymentRespDto> lst= payment.stream().map(e->mapper.map(e, PaymentRespDto.class)).collect(Collectors.toList()); 
		return lst;
	}

	@Override
	public ApiResponse makePayment(Integer orderId, Integer userId,PaymentReqDto paydto) {
		User user = userdao.findById(userId).orElseThrow(()->new CustomExp("Id not exists"));
		Order order = orderdao.findById(orderId).orElseThrow(()->new CustomExp("Id not exists"));
		Payment payment = mapper.map(paydto, Payment.class);
		user.addPayment(payment);
		payment.setOrder(order);
		payment.setPaymentStatus(Status.PAYEMNT_RECEIVED);
		payment.setPaymentDate(LocalDate.now());
	    paydao.save(payment);
		return new ApiResponse("Payment Successfull");
	}
	
	public List<PaymentRespDto> getAllPayments(){
		return paydao.findAll().stream().map(e->mapper.map(e, PaymentRespDto.class)).collect(Collectors.toList());
	}


}
