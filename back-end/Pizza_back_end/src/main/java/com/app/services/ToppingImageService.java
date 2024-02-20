package com.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ToppingImageService {

	public String uploadImage(Integer pizzaId,MultipartFile image) ;
	public byte[] serveImage(Integer pizzaId)throws IOException;
}
