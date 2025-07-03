package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	@Column(length=100)
	private String productName;
	@Id
	@GeneratedValue //id will be auto generated
	private Integer productId;
	@Column(name ="cost")
	private double price;
	@Column(length=30)
	private String category;
	private String brand;

}
