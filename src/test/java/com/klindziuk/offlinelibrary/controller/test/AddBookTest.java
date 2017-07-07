package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class AddBookTest extends BaseTest {
	private static final String ADDBOOK_XML_PATH = XMLFILEPATH + "adminservice/addbook/";
	
	@Test(priority = 0)
	public void addBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(ADDBOOK_XML_PATH + "addbook.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book added successfully.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1, expectedExceptions = IllegalArgumentException.class)
	public void epmtyCommandTest() throws IOException {
		request = RequestParser.readFile(ADDBOOK_XML_PATH + "emptycommand.xml");
		controller.executeAdminTask(request);
	}

	@DataProvider
	public Object[][] addBookEmptyFieldsDp() throws IOException {
		return new Object[][] { 
			    { ADDBOOK_XML_PATH + "emptyname.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "emptyauthor.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "emptyyear.xml", EMPTY_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "addBookEmptyFieldsDp")
	public void addBookEmptyFieldsTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] addBookSpecFieldsDp() throws IOException {
		return new Object[][] {
			    { ADDBOOK_XML_PATH + "specname.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "specauthor.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "specyear.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 3, dataProvider = "addBookSpecFieldsDp")
	public void addBookSpecFieldsTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] addBookNullFieldsDp() throws IOException {
		return new Object[][] {
			    { ADDBOOK_XML_PATH + "nullname.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "nullauthor.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ ADDBOOK_XML_PATH + "nullyear.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 4, dataProvider = "addBookNullFieldsDp")
	public void addBookNullFieldsTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
