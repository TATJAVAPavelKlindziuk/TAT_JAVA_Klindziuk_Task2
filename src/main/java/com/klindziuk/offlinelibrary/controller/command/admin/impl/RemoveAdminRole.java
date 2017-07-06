package com.klindziuk.offlinelibrary.controller.command.admin.impl;

import org.apache.log4j.Logger;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.service.AdminService;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;
import com.klindziuk.offlinelibrary.service.factory.ServiceFactory;

public class RemoveAdminRole implements Command {
	private static final Logger logger = Logger.getLogger(RemoveAdminRole.class);
	private static final String SUCCESSFULl_UPDATE_MESSAGE = "Admin rights successfully removed.";
	
	@Override
	public String execute(String request) {
		if (null == request || request.isEmpty()) {
		return INVALID_REQUEST_EXCEPTION_MESSAGE;
		}
		String response = UNSUCCESSFUL_OPERATION_MESSAGE;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdminService adminService = serviceFactory.getAdminService();
		try {
			int userId = RequestParser.getId(request);
			if (adminService.removeAdminRole(userId)) {
				response = SUCCESSFULl_UPDATE_MESSAGE;
			}
		} catch (ServiceException seex) {
			logger.error(seex.getMessage(), seex);
		} catch (IllegalArgumentException ieax) {
			logger.error(ieax.getMessage(), ieax);
		}
		return response;
	}
}