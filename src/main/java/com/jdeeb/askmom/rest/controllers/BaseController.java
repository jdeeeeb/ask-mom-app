package com.jdeeb.askmom.rest.controllers;

import com.jdeeb.askmom.rest.models.ErrorMessage;
import com.jdeeb.askmom.rest.models.ResponseModel;

public abstract class BaseController {

	protected ResponseModel prepareResponse(Object data, String errorMsg, String errorDesc, int status){
		ResponseModel model = new ResponseModel();
		if(errorMsg != null && !errorMsg.trim().equalsIgnoreCase("")) {
			ErrorMessage error = new ErrorMessage(errorMsg, errorDesc);
			model.setError(error);
		}
		model.setStatus(status);
		model.setData(data);
		
		return model;
	}
}
