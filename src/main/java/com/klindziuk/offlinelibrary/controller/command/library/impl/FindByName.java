package com.klindziuk.offlinelibrary.controller.command.library.impl;

import org.apache.log4j.Logger;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.controller.util.ResponseBuilder;
import com.klindziuk.offlinelibrary.service.LibraryService;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;
import com.klindziuk.offlinelibrary.service.factory.ServiceFactory;

public class FindByName implements Command {
	private static final Logger logger = Logger.getLogger(FindByName.class);
	
	@Override
	public String execute(String request) {
		if (null == request || request.isEmpty()) {
			return INVALID_REQUEST_EXCEPTION_MESSAGE;
		}
		String response = UNSUCCESSFUL_OPERATION_MESSAGE;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		try {
			String name = RequestParser.getName(request);
			response = ResponseBuilder.build(libraryService.findByName(name));
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