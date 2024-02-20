package com.app.services;

import com.app.dto.ApiResponse;
import com.app.dto.OrderRespDto;

public interface OrderService {

	ApiResponse PlaceOrder(Integer userId,OrderRespDto orderDto);
	
	ApiResponse DeleteOrder(OrderRespDto orderDto);
	
}
