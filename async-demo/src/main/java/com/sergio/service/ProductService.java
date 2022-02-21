package com.sergio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.model.Product;

@Service
public class ProductService {

	public List<Product> getProducts1() throws Exception {
		Thread.sleep(1000);
		return Arrays.asList(new Product(1, "Product1"), new Product(2, "Product2"), new Product(3, "Product3"));
	}

	public List<Product> getProducts2() throws Exception {
		Thread.sleep(3000);

		return Arrays.asList(new Product(4, "Product4"), new Product(5, "Product5"), new Product(6, "Product6"));
	}

	public List<Product> getProducts3() throws Exception {
		Thread.sleep(2000);

		return Arrays.asList(new Product(7, "Product7"), new Product(8, "Product8"), new Product(9, "Product9"));
	}

}
