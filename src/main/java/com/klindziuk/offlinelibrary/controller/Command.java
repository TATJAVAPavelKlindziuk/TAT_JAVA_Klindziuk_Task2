package com.klindziuk.offlinelibrary.controller;

public interface Command {
	public static final String INVALID_REQUEST_EXCEPTION_MESSAGE = "Invalid request parameters.";
	public static final String UNSUCCESSFUL_OPERATION_MESSAGE = "Cannot perform this operation.";
	public String execute(String request) ;
}
