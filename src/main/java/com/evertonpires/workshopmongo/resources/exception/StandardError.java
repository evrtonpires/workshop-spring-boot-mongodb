package com.evertonpires.workshopmongo.resources.exception;

import java.io.Serializable;
//classe de erros da API
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String messae;
	private String path;
	
	
	public StandardError() {
		
	}


	public StandardError(Long timestamp, Integer status, String error, String messae, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.messae = messae;
		this.path = path;
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessae() {
		return messae;
	}


	public void setMessae(String messae) {
		this.messae = messae;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
}
