package com.klindziuk.offlinelibrary.controller.command.admin.impl;

import org.apache.log4j.Logger;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.service.AdminService;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;
import com.klindziuk.offlinelibrary.service.factory.ServiceFactory;

public class MarkReturn implements Command {
	private static final Logger logger = Logger.getLogger(MarkReturn.class);
	private static final String SUCCESSFUL_RETURN_MESSAGE = "Book returned successfully";
	
	@Override
	public String execute(String request) {
		if (null == request || request.isEmpty()) {
			return INVALID_REQUEST_EXCEPTION_MESSAGE;
		}
		String response = UNSUCCESSFUL_OPERATION_MESSAGE;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdminService adminService = serviceFactory.getAdminService();
		try {
			int[] id = RequestParser.getParameters(request);
			if (adminService.markReturn(id[0], id[1])) {
				response = SUCCESSFUL_RETURN_MESSAGE;
			}
		} catch (ServiceException seex) {
			logger.error(seex.getMessage(), seex);
			response = UNSUCCESSFUL_OPERATION_MESSAGE + seex.getMessage();
		} catch (IllegalArgumentException ieax) {
			logger.error(ieax.getMessage(), ieax);
			response = UNSUCCESSFUL_OPERATION_MESSAGE + ieax.getMessage();
		}
		return response;
	}
}
