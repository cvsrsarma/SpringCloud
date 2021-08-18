package com.appsdeveloper.app.ws.exception;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsdeveloper.app.ws.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {IOException.class})
	public ResponseEntity<Object> handlerException(Exception ex, WebRequest request){
		return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class, ArrayIndexOutOfBoundsException.class})
	public ResponseEntity<Object> handlerNullPointerExceptionTest(Exception ex, WebRequest request){
		String errorMsg =  ex.getLocalizedMessage();
		if(null==errorMsg)
			errorMsg = ex.toString();
		ErrorMessage errorObj= new ErrorMessage(new Date(), errorMsg);
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> userServiceException(Exception ex, WebRequest request){
		String errorMsg =  ex.getLocalizedMessage();
		if(null==errorMsg)
			errorMsg = ex.toString();
		ErrorMessage errorObj= new ErrorMessage(new Date(), errorMsg);
		return new ResponseEntity<>(errorObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
