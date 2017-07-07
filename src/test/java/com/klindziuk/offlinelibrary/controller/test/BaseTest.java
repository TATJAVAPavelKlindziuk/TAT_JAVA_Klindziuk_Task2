package com.klindziuk.offlinelibrary.controller.test;

import com.klindziuk.offlinelibrary.controller.Controller;
import com.klindziuk.offlinelibrary.dao.util.DBconnector;

import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;

public class BaseTest {
	private static final Logger logger = Logger.getLogger(BaseTest.class);
	protected static final String XMLFILEPATH = "C:/Users/Pavel_Klindziuk/Program_Files/eclipse/workspace/offlinelibrary/requests/";
	protected static final String SQLFILEPATH = "C:/Users/Pavel_Klindziuk/Program_Files/eclipse/workspace/offlinelibrary/sql/";
	protected Controller controller;
	protected DBconnector connector;
	protected Connection connection;
	protected String request;

	@BeforeClass
	public void beforeClass() throws ClassNotFoundException, SQLException {
		logger.info("Preparing test environment...");
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
		logger.info("Environment prepared successfully.");
	}

	@AfterClass
	public void afterClass() {
		controller = null;
		connector = null;
		request = null;
		logger.info("Tests runs are finished");
	}
}
