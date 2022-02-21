package com.sergio.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sergio.model.Product;

@Service
public class ProductAsyncService {

	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts1() throws Exception {
		Thread.sleep(1000);
		List<Product> list= Arrays.asList(new Product(1, "Product1"), new Product(2, "Product2"), new Product(3, "Product3"));
		return CompletableFuture.completedFuture(list);
	}

	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts2() throws Exception {
		Thread.sleep(3000);

		List<Product> list2= Arrays.asList(new Product(4, "Product4"), new Product(5, "Product5"), new Product(6, "Product6"));
		return CompletableFuture.completedFuture(list2);
	}

	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts3() throws Exception {
		Thread.sleep(2000);

		List<Product> list3= Arrays.asList(new Product(7, "Product7"), new Product(8, "Product8"), new Product(9, "Product9"));
		
		return CompletableFuture.completedFuture(list3);
	}
	
}
