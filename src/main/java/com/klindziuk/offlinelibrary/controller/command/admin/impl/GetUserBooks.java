package com.klindziuk.offlinelibrary.controller.command.admin.impl;

import org.apache.log4j.Logger;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.controller.util.ResponseBuilder;
import com.klindziuk.offlinelibrary.service.LibraryService;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;
import com.klindziuk.offlinelibrary.service.factory.ServiceFactory;

public class GetUserBooks implements Command {
	private static final Logger logger = Logger.getLogger(GetUserBooks.class);
	
	@Override
	public String execute(String request) {
		if (null == request || request.isEmpty()) {
			return INVALID_REQUEST_EXCEPTION_MESSAGE;
		}
		String response = UNSUCCESSFUL_OPERATION_MESSAGE;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		try {
			int userId = RequestParser.getId(request);
			response = ResponseBuilder.build(libraryService.getUserBooks(userId));
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
