package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	//DTO class
	private String productName;
	private Integer productId;
	private double price;
	private String category;
	private String brand;

	
}
