package com.jdeeb.askmom.rest.models;

public class ErrorMessage {
	private String errorMsg;
	private String errorDesc;
	public ErrorMessage() {}
	public ErrorMessage(String errorMsg, String errorDesc) {
		this.errorDesc = errorDesc;
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	@Override
	public String toString() {
		return "ErrorMessage [errorMsg=" + errorMsg + ", errorDesc=" + errorDesc + "]";
	}
}
