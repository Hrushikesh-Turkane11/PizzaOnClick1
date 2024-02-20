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
import com.app.dao.ToppingDao;
import com.app.pojos.Topping;

@Service
@Transactional
public class ToppingImageServiceImpl implements ToppingImageService  {

	@Autowired
	private ToppingDao toppingDao;
	
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
	public String uploadImage(Integer toppingId,MultipartFile image) 
	{
		
		
		Topping topping=toppingDao.findById(toppingId).orElseThrow(()->new CustomExp("Invalid Topping Id"));
		String path=folderLocation.concat(image.getOriginalFilename());
		try {
			FileUtils.writeByteArrayToFile(new File(path), image.getBytes());
			topping.setToppingImagePath(path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Topping image added sucesfully";
	}
	
	
	@Override
	public byte[] serveImage(Integer toppingId)throws IOException
	{
		
			Topping topping=toppingDao.findById(toppingId).orElseThrow(()->new CustomExp("Invalid Topping Id"));
			String path = topping.getToppingImagePath();
		
			if (path != null) 
			{
				return readFileToByteArray(new File(path));
			} 
			else 
				throw new CustomExp("Image not assigned yet");
			
	}
}
