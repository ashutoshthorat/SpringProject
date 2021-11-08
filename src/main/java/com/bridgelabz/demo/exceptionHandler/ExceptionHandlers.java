package com.bridgelabz.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.demo.exception.ExceptionHandle;
import com.bridgelabz.demo.response.Response;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception e){
		log.error(e.getMessage(), e);
		ExceptionHandle he = new ExceptionHandle(100, e);
		return new ResponseEntity<>(he.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
