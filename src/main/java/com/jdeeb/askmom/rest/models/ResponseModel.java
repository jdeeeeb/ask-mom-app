package com.jdeeb.askmom.rest.models;

public class ResponseModel {

	private int status;
	private ErrorMessage error;
	private Object data;
	/************************/
	public ErrorMessage getError() {
		return error;
	}
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	/************************/
}
