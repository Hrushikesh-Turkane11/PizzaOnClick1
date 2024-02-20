package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ToppingReqDto;
import com.app.services.ToppingImageService;
import com.app.services.ToppingService;

@RestController
@RequestMapping("/toppings")
public class ToppingController 
{
	
	@Autowired
	private ToppingService toppingService;
	
	@Autowired
	private ToppingImageService toppingImage;
	
	@PostMapping("/{pizzaId}")
	public ResponseEntity<?> addNewTopping(@RequestBody ToppingReqDto toppingDto , @PathVariable Integer pizzaId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(toppingService.addTopping(toppingDto,pizzaId));
	}
	
	@PostMapping(value = "/images/{toppingId}", consumes = "multipart/form-data")//it is required for swagger only
	public ResponseEntity<?> uploadImage(@PathVariable Integer toppingId, @RequestParam MultipartFile imageFile)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(toppingImage.uploadImage(toppingId, imageFile));
	}
	
	@PutMapping("/{toppingId}")
	public ResponseEntity<?> updateTopping(@PathVariable Integer toppingId , @RequestBody ToppingReqDto toppingDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(toppingService.updateTopping(toppingId,toppingDto));
	}
	
	@DeleteMapping("/{toppingId}")
	public ResponseEntity<?> deleteTopping(@PathVariable Integer toppingId)
	{
		return ResponseEntity.ok(toppingService.deletePizza(toppingId));
	}
	
	@GetMapping//(produces = { MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(toppingService.getAllTopping());
	}
	
	@GetMapping(value="image/{toppingId}",produces = { MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<?> getToppingImages(@PathVariable Integer toppingId)throws IOException
	{
		return ResponseEntity.status(HttpStatus.OK).body( toppingImage.serveImage(toppingId));
	}
	
	@GetMapping(value="/{toppingId}")
	public ResponseEntity<?> getTopping(@PathVariable Integer toppingId)
	{
		return ResponseEntity.status(HttpStatus.OK).body( toppingService.getToppingById(toppingId));
	}
	
	
	
	
	
	
	
}
