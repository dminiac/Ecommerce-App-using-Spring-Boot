package com.abc.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abc.ecom.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public Product findByProductName(String productName);
	
	@Query("Select p from Product p where p.productCategory = :pcategory ")
	public List<Product> findProductByCategory(@Param("pcategory") String category);
	
	

}
