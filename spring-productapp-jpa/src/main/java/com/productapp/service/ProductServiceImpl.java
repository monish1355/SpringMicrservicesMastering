package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IProductRepository productRepository;
	
	

	@Override
	public void addproduct(ProductDto productdto) {
		// dto from main /user--->Entity
		 Product product = mapper.map(productdto, Product.class);
		 productRepository.save(product);
	}

	@Override
	public void updateproduct(ProductDto productdto) {
		// TODO Auto-generated method stub
		Product product = mapper.map(productdto, Product.class); 
		
		productRepository.save(product);
	}

	@Override
	public void deleteproduct(int producid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDto getById(int productId) {
		// TODO Auto-generated method stub
		
		Optional <Product> productid = productRepository.findById(productId);
		if(productid.isPresent())
		{
			Product product=  productid.get();
			ProductDto productdto =mapper.map(product, ProductDto.class);
			return productdto;
		}
		return null;
	}

	@Override
	public List<ProductDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
