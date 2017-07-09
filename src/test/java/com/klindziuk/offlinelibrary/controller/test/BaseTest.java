package com.klindziuk.offlinelibrary.controller.test;

import com.klindziuk.offlinelibrary.controller.Controller;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.controller.util.SqlScriptRunner;
import com.klindziuk.offlinelibrary.dao.util.DBconnector;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class BaseTest {
	private static final Logger logger = Logger.getLogger(BaseTest.class);
	protected static final String XMLFILEPATH = "C:/Users/Pavel_Klindziuk/Program_Files/eclipse/workspace/offlinelibrary/requests/";
	protected static final String SQLFILEPATH = "C:/Users/Pavel_Klindziuk/Program_Files/eclipse/workspace/offlinelibrary/sql/";
	protected static final String START_PREPARING_MESSAGE = "Preparing test environment...";
	protected static final String FINISH_PREPARING_MESSAGE = "Environment prepared successfully.";
	protected static final String PERFORMING_MESSAGE = "Performing test case from - ";
	protected static final String TEST_FINISH_MESSAGE = "Tests runs are finished";
	protected static final String EMPTY_STRING_EXCEPTION_MESSAGE = "Cannot perform this operation.Parameters cannot be null or empty.";
	protected static final String SPEC_STRING_EXCEPTION_MESSAGE = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
	protected static final String NUMBER_EXCEPTION_MESSAGE = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
	protected static final String NO_FILE_EXCEPTION_MESSAGE = "Cannot find file ";
	protected Controller controller;
	protected DBconnector connector;
	protected Connection connection;
	
	@BeforeClass
	public void beforeClass() throws ClassNotFoundException, SQLException {
		logger.info(START_PREPARING_MESSAGE);
		System.out.println();
		controller = new Controller();
		connector = DBconnector.getInstance();
		connector.connect();
		connection = connector.getJdbcConnection();
		SqlScriptRunner.run(connection, SQLFILEPATH + "fillsb.sql");
		SqlScriptRunner.run(connection, SQLFILEPATH + "fillbooks.sql");
		SqlScriptRunner.run(connection, SQLFILEPATH + "fillusers.sql");
		SqlScriptRunner.run(connection, SQLFILEPATH + "fillwish.sql");
		try {
			connection.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			connector.disconnect();
		} catch (Exception e) {
			/* ignored */ }
		logger.info(FINISH_PREPARING_MESSAGE);
	}

	@AfterClass
	public void afterClass() {
		controller = null;
		connector = null;
		logger.info(TEST_FINISH_MESSAGE);
	}
	
	protected String setCommand(String xmlPath) {
		String result = "";
		try {
			result = RequestParser.readFile(XMLFILEPATH + xmlPath);
			logger.info(PERFORMING_MESSAGE + XMLFILEPATH + xmlPath);
		} catch (IOException ioex) {
			logger.error(NO_FILE_EXCEPTION_MESSAGE + XMLFILEPATH + xmlPath, ioex);
		}
		return result;
	}
}
