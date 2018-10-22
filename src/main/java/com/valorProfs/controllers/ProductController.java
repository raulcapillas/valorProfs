package com.valorProfs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valorProfs.models.ErrorMessage;
import com.valorProfs.models.Product;
import com.valorProfs.services.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProduct() {
		return this.productService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProductById(@PathVariable(value = "id") Integer id) {
		return this.productService.getOne(id);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody int insert(@RequestBody Product product, HttpServletRequest request) {
		try {
			return this.productService.insert(product);
		} catch (Exception e) {
			return 0;
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody int update(@RequestBody Product product, HttpServletRequest request) {
		try {
			return this.productService.update(product);
		} catch (Exception e) {
			return 0;
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public @ResponseBody int delete(@RequestParam(value = "id", required = true) Integer id) {
		try {
			this.productService.delete(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorMessage handleException(IllegalArgumentException ex, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ErrorMessage(ex.getMessage());
	}

}
