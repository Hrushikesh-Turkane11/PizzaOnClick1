package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exp.CustomExp;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.UserReqDto;
import com.app.dto.UserRespDto;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Autowired
	ModelMapper mapper;

	@Override
	public UserRespDto addUser(UserReqDto userdto) {

		User user = mapper.map(userdto, User.class);
		user = userdao.save(user);
		return mapper.map(user, UserRespDto.class);
	}

	@Override
	public List<UserRespDto> getAllUsers() {
		return userdao.findAll().stream().map(e -> mapper.map(e, UserRespDto.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteUser(Integer userId) {
		// remove user from list->payment,order
		// use remove method of list

		User user = userdao.findById(userId).orElseThrow(() -> new CustomExp("Id not exits"));
		userdao.delete(user);

		return new ApiResponse("User details with Id" + user.getId() + "deleted successfully");
	}

	@Override
	public UserRespDto updateUser(Integer userId, UserRespDto userdto) {

		User user = userdao.findById(userId).orElseThrow(() -> new CustomExp("Id not exists"));
		mapper.map(userdto, user);
		userdao.save(user);
		return mapper.map(user, UserRespDto.class);
	}

}
