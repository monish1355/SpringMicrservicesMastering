package com.productapp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappJpaApplication.class, args);
	}
	
	
	@Autowired
	private IProductService productservice;

	@Override
	public void run(String... args) throws Exception {
		// call service layer
		//create a dto classobject
		
		ProductDto productDTO =  new ProductDto("Mobile",null,20000,"Electronics","Pixel");
		productservice.addproduct(productDTO);
		
		ProductDto idproductDTO = productservice.getById(2);
		System.out.println(idproductDTO);
		
		idproductDTO.setBrand("Samsung");
		productservice.updateproduct(idproductDTO);
		
	}

}
