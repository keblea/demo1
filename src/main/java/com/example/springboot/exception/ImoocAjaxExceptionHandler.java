package com.example.springboot.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboot.pojo.ImoocJsonResult;


@RestControllerAdvice
public class ImoocAjaxExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ImoocJsonResult defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return ImoocJsonResult.errorException(e.getMessage());
	}
}
