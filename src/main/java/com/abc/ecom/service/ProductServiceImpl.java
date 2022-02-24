package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {

		Product savedProduct = productRepository.save(product);

		return savedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {

		Optional<Product> optionalProduct = productRepository.findById(productId);

		if (optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: " + productId);
		}
		return optionalProduct.get();
	}

	@Override
	public Product updateProduct(Product product) {

		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());

		if (optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: " + product.getProductId());
		}

		Product updatedProduct = productRepository.save(product);

		return updatedProduct;
	}

	@Override
	public void deleteProduct(int productId) {

		Optional<Product> optionalProduct = productRepository.findById(productId);

		if (optionalProduct.isPresent()) {
			productRepository.deleteById(productId);
		} else {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: " + productId);
		}
	}

	@Override
	public Product getProductByName(String productName) {

		Product product = productRepository.findByProductName(productName);

		return product;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {

		return productRepository.findProductByCategory(category);

	}
}
