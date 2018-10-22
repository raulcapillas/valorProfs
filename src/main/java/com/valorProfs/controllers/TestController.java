package com.valorProfs.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valorProfs.models.ErrorMessage;

@Controller
public class TestController {    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String POJO() {
		return "Great! It's working!";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleException(IllegalArgumentException ex, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ErrorMessage(ex.getMessage());
    }

}
