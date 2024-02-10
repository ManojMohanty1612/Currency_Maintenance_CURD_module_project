package com.mashreq.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalAdviceExceptionHandler {

	@ExceptionHandler(UserIdNotAvailableInOutRecord.class)

	public ResponseEntity<String> idNotFoundException(UserIdNotAvailableInOutRecord  userIdNotAvailableInOutRecord) {

		return new ResponseEntity<String>(userIdNotAvailableInOutRecord.getMessage(), HttpStatus.BAD_REQUEST);

	}
}
