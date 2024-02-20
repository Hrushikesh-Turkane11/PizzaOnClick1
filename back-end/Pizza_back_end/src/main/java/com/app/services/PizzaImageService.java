package com.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface PizzaImageService 
{
	
	public String uploadImage(Integer pizzaId,MultipartFile image) ;
	
	//public void uploadImage1(Pizza pizza, MultipartFile image);
	
	public byte[] serveImage(Integer pizzaId)throws IOException;

	
}
