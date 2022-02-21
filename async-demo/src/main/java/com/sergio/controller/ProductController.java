package com.sergio.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.model.Product;
import com.sergio.service.ProductAsyncService;
import com.sergio.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {


	ProductService productService;
	private final ProductAsyncService productAsyncService;
	
	
	public ProductController(ProductService productService, ProductAsyncService productAsyncService) {
		this.productService=productService;
		this.productAsyncService =productAsyncService;
	}
	
	@GetMapping
	public List<Product> getAllProducts() throws Exception{
		long start=System.currentTimeMillis();
		List<Product> list1=productService.getProducts1();
		List<Product> list2=productService.getProducts2();
		List<Product> list3=productService.getProducts3();
		
		List<Product> list4=Stream.of(list1, list2, list3).flatMap(Collection::stream).collect(Collectors.toList());
		long end=System.currentTimeMillis();
		
		System.out.println("Time spent with synchronized method --> " + (end-start));
		
		return list4;
		
		
	}
	
	@GetMapping("/async")
	public List<Product> getAllProductsAsync() throws Exception{
		long start=System.currentTimeMillis();
		CompletableFuture<List<Product>> c1= productAsyncService.getProducts1();
		CompletableFuture<List<Product>> c2= productAsyncService.getProducts2();
		CompletableFuture<List<Product>> c3= productAsyncService.getProducts3();
		
		CompletableFuture.allOf(c1,c2,c3).join();
		
		List<Product> c4=Stream.of(c1.get(), c2.get(), c3.get()).flatMap(Collection::stream).collect(Collectors.toList());
		long end=System.currentTimeMillis();
		
		System.out.println("Time spent with asynchronized method--> " + (end-start));
		
		return c4;

		
	}
	
	
}
