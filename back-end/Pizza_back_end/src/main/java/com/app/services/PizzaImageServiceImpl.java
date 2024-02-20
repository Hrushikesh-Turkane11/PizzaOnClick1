package com.app.services;

import static org.apache.commons.io.FileUtils.readFileToByteArray;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exp.CustomExp;
import com.app.dao.PizzaDao;
import com.app.pojos.Pizza;

@Service//("image_folder")
@Transactional
public class PizzaImageServiceImpl implements PizzaImageService
{
	@Autowired
	PizzaDao pizzaDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Value("${folder.location}")//using SpEL : Spring expr language
	String folderLocation;
	
	
	@PostConstruct
	public void init()  
	{
		System.out.println("in init " + folderLocation);
		// chk if folder exists --yes --continue
		File folder = new File(folderLocation);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}
		
	@Override
	public String uploadImage(Integer pizzaId,MultipartFile image) 
	{
		
		Pizza pizza=pizzaDao.findById(pizzaId).orElseThrow();
		String path=folderLocation.concat(image.getOriginalFilename());
		try {
			FileUtils.writeByteArrayToFile(new File(path), image.getBytes());
			pizza.setPizzaImagePath(path);
			//pizza.setPizzaImagePath(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "image added succesfully";
	}
	
	
	@Override
	public byte[] serveImage(Integer pizzaId)throws IOException
	{
		
		Pizza pizza=pizzaDao.findById(pizzaId).orElseThrow(()->new CustomExp("Invalid pizza Id"));
		String path = pizza.getPizzaImagePath();
		
			if (path != null) 
			{
				return readFileToByteArray(new File(path));
			} 
			else 
				throw new CustomExp("Image not assigned yet");
			
	}
	
	
	/*@Override
	public void uploadImage1(Pizza pizza, MultipartFile image)
	{
		String path=folderLocation.concat(image.getOriginalFilename());
		try {
			FileUtils.writeByteArrayToFile(new File(path), image.getBytes());
			pizza.setPizzaImagePath(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}*/
	
	
	
}
