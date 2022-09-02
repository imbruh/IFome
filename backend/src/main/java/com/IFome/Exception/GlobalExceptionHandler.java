package com.IFome.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> erroInterno (Throwable cause) {
		System.out.println(cause.getClass().getName().contains("IFMException"));
		System.out.println("ERRO INTERNO (BACK)");
		System.out.println(cause);
		return new ResponseEntity<String>(cause.getClass().getName().contains("IFMException")?cause.getMessage():"ERRO INTERNO (BACK)",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<?> teste2 (TransactionSystemException cause) {
		System.out.println("ERRO NO 'BANCO'");
		return new ResponseEntity<String>("ERRO NO 'BANCO'",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> teste3 (DataIntegrityViolationException cause) {
		System.out.println("ERRO NO DATA INTREGATION 'BANCO'");
		System.out.println("causeSpecificed: " + cause.getMostSpecificCause().getMessage());
		return new ResponseEntity<String>("ERRO NO DATA INTREGATION 'BANCO'",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
