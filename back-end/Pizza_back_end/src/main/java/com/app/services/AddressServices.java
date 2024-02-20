package com.app.services;

import java.util.List;

import com.app.dto.AddressReqDto;
import com.app.dto.AddressRespDto;
import com.app.dto.ApiResponse;

public interface AddressServices {

	List<AddressRespDto> getAllAdress();
	
	AddressRespDto getAddressByUser(Integer userid);
	
	AddressReqDto addAddress(Integer userid,AddressReqDto dto);
	
	AddressReqDto updateAddress(Integer addressid,AddressReqDto dto);
	
	ApiResponse deleteAddress(Integer addressid);
	
	
}
