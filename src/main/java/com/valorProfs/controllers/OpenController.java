package com.valorProfs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valorProfs.models.ErrorMessage;
import com.valorProfs.models.Product;
import com.valorProfs.services.IProductService;

@Controller
@RequestMapping("/open")
public class OpenController {
	
	@Autowired
	private IProductService productService;
	
    @RequestMapping(value = "/gridName", method = RequestMethod.GET)
    @ResponseBody
    public String getTitleGrid() {
		return "This is the GRID of Products";
    }
    
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProduct() {
		return this.productService.getAll();
	}

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleException(IllegalArgumentException ex, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ErrorMessage(ex.getMessage());
    }

}
