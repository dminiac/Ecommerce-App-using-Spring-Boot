package com.abc.ecom.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<Product> fetchAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;

	}

	@GetMapping("/get/{pid}")
	public ResponseEntity<?> fetchProductDetails(@PathVariable("pid") int productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/getbyname/{pname}")
	public ResponseEntity<?> fetchProductDetailsByName(@PathVariable("pname") String pname) {
		Product product = productService.getProductByName(pname);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/getbycategory/{category}")
	public ResponseEntity<List<Product>> fetchProductDetailsByCategory(@PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted with id: " + productId, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

}