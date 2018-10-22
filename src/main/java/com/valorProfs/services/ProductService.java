package com.valorProfs.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valorProfs.mapper.ProductMapper;
import com.valorProfs.models.Product;

@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	private MyBatisService myBatisService;

	public ProductService() {
	}

	public List<Product> getAll() {
		List<Product> products = null;
		try (SqlSession session = myBatisService.getSession()) {
			ProductMapper productMapper = session.getMapper(ProductMapper.class);
			products = productMapper.selectAll();
		}

		if (products == null) {
			products = new ArrayList<>();
		}

		return products;
	}

	public Product getOne(Integer id) {
		Product product = null;
		try (SqlSession session = myBatisService.getSession()) {
			ProductMapper productMapper = session.getMapper(ProductMapper.class);
			product = productMapper.selectOneById(id);
		}

		return product;
	}

	public int insert(Product product) throws IllegalArgumentException {
		try (SqlSession session = myBatisService.getSession()) {
			ProductMapper productMapper = session.getMapper(ProductMapper.class);
			productMapper.insertProduct(product);
			session.commit();
		}
		return 1;
	}

	public int update(Product product) throws IllegalArgumentException {
		try (SqlSession session = myBatisService.getSession()) {
			ProductMapper productMapper = session.getMapper(ProductMapper.class);
			productMapper.updateProduct(product);
			session.commit();
		}
		return 1;
	}

	public int delete(Integer id) throws IllegalArgumentException {
		try (SqlSession session = myBatisService.getSession()) {
			ProductMapper productMapper = session.getMapper(ProductMapper.class);
			productMapper.deleteProduct(id);
			session.commit();
		}
		return 1;
	}
}
