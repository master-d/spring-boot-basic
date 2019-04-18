package bsb.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BsbControllerAdvice {

	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> globalExceptionHandler(Exception ex) {
		String msg = Optional.of(ex.getMessage()).orElse(ex.getClass().getSimpleName());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
	}
}
