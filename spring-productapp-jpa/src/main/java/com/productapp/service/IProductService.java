package com.productapp.service;

import java.util.List;

import com.productapp.model.ProductDto;

public interface IProductService {

	
	void addproduct (ProductDto productdto);
	void updateproduct(ProductDto productdto);
	void deleteproduct(int producid);
	ProductDto getById(int productId);
	
	List<ProductDto> getAll();
}
