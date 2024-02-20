package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.dto.PizzaReqDto;
import com.app.services.PizzaImageService;
import com.app.services.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController 
{
	

	@Autowired 
	PizzaService pizzaService;
	
	@Autowired
	PizzaImageService imgService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewPizza(@RequestBody PizzaReqDto pizzaDto )
	{	
		System.out.println("In pizza Controller");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pizzaService.addNewPizzaWithImage(pizzaDto));
		
	}
	
	
	@PostMapping(value = "/images/{pizzaId}", consumes = "multipart/form-data")//it is required for swagger only
	public ResponseEntity<?> uploadImage(@PathVariable Integer pizzaId, @RequestParam MultipartFile imageFile)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(pizzaId, imageFile));
	}
	
	/*@PostMapping(value = "/pizzaWithImage", produces = APPLICATION_JSON_VALUE)//it is required for swagger only
	public ResponseEntity<?> uploadImage(@RequestPart PizzaReqDto pizzaDto, @RequestParam MultipartFile imageFile)
	{
		System.out.println("In pizza Controller "+pizzaDto+"  "+imageFile);
		return ResponseEntity.status(HttpStatus.CREATED).body(pizzaService.addPizzaWithImage(pizzaDto, imageFile));
	}*/
	
	@DeleteMapping("/{pizzaId}")
	public ResponseEntity<?> deletePizza(@PathVariable Integer pizzaId)
	{
		return ResponseEntity.ok(pizzaService.deletePizza(pizzaId));
	}
	
	@PutMapping("/{pizzaId}")
	public ResponseEntity<?> updatePizza(@PathVariable Integer pizzaId,@RequestBody PizzaReqDto pizzaDto )
	{
		return ResponseEntity.status(HttpStatus.OK).body(pizzaService.updatePizza(pizzaId,pizzaDto));
	}
	
	
	@GetMapping(value = "/images/{pizzaId}", produces = { IMAGE_GIF_VALUE,IMAGE_JPEG_VALUE,IMAGE_PNG_VALUE})
	public ResponseEntity<?> downloadImage(@PathVariable Integer pizzaId) throws IOException {
		//System.out.println("in download image " + empId);
		return ResponseEntity.ok(imgService.serveImage(pizzaId));
	}
	
	@GetMapping(value="/getallPizza" /*,produces = { MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE}*/)
	public ResponseEntity<?> getAllPizza()
	{
		return ResponseEntity.ok(pizzaService.getAllPizza());
	}
	
		
}
