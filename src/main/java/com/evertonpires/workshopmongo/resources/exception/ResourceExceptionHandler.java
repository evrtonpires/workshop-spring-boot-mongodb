package com.evertonpires.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.evertonpires.workshopmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice//classe responsavel por tratar possiveis erros nas requisições
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objeticNotFound(ObjectNotFoundException e,HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(
				System.currentTimeMillis()//pega o instante atual do sistema
				, status.value()//converte o erro para numero inteiro
				, "Não Encontrado"//erro
				, e.getMessage()//mensagem do erro
				, request.getRequestURI());//caminho do erro
		return ResponseEntity.status(status).body(err);
		
	}
}
