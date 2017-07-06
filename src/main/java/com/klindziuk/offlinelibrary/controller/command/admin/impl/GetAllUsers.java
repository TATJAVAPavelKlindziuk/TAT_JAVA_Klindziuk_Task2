package com.klindziuk.offlinelibrary.controller.command.admin.impl;

import org.apache.log4j.Logger;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.util.ResponseBuilder;
import com.klindziuk.offlinelibrary.service.AdminService;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;
import com.klindziuk.offlinelibrary.service.factory.ServiceFactory;

public class GetAllUsers implements Command{
	private static final Logger logger = Logger.getLogger(GetAllUsers.class);
	
	@Override
	public String execute(String request) {
		if (null == request || request.isEmpty()) {
			return INVALID_REQUEST_EXCEPTION_MESSAGE;
		}
		String response = UNSUCCESSFUL_OPERATION_MESSAGE;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdminService adminService = serviceFactory.getAdminService();
		try {
			response = ResponseBuilder.build(adminService.getAllUsers());
		} catch (ServiceException seex) {
			logger.error(seex.getMessage(), seex);
			response = UNSUCCESSFUL_OPERATION_MESSAGE + seex.getMessage();
		}
		return response;
	}
}