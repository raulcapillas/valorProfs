package com.valorProfs.mapper;

import java.util.List;

import com.valorProfs.models.Product;

public interface ProductMapper {
	List<Product> selectAll();

	Product selectOneById(Integer id);

	void insertProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Integer id);

}