package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

/**
 * GetAll, GetAllSubscriptions, GetAllUsers, GetUserBooks tests
 */
public class GetAllTest extends BaseTest {
	private static final String GET_XML_PATH = XMLFILEPATH + "adminservice/get/";

	// compare size of strings to check equals
	@Test(priority = 1)
	public void getAllBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(GET_XML_PATH + "getallbooks.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 1040;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 2)
	public void getAllUsersSmokeTest() throws IOException {
		request = RequestParser.readFile(GET_XML_PATH + "getallusers.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 1339;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 3)
	public void getAllSubscriptionsSmokeTest() throws IOException {
		request = RequestParser.readFile(GET_XML_PATH + "getallsubscriptions.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 684;
		Assert.assertEquals(actual, expected);
	}
	
	// compare size of strings to check equals
	@Test(priority = 4)
	public void getUserBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(GET_XML_PATH + "getuserbooks.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 102;
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] getUserBooksIdDp() throws IOException {
		return new Object[][] { { GET_XML_PATH + "getuserbooksempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ GET_XML_PATH + "getuserbookszero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GET_XML_PATH + "getuserbooksletters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GET_XML_PATH + "getuserbooksspec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 5, dataProvider = "getUserBooksIdDp")
	public void getUserBooksIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
