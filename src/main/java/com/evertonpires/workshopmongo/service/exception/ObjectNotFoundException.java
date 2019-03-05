package com.evertonpires.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{
	//RunTimeException - excecao padrao do java que o compilador nao exige que ela seja tratada
	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	

}
