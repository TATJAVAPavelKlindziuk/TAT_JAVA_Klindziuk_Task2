package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * GetAll, GetAllSubscriptions, GetAllUsers, GetUserBooks tests
 */
public class GetAllTest extends BaseTest {
	
	// compare size of strings to check equals
	@Test(priority = 1)
	public void getAllBooksSmokeTest() {
		String command = setCommand("get/getallbooks.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 1040;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 2)
	public void getAllUsersSmokeTest() {
		String command = setCommand("get/getallusers.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 1339;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 3)
	public void getAllSubscriptionsSmokeTest() {
		String command = setCommand("get/getallsubscriptions.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 684;
		Assert.assertEquals(actual, expected);
	}
	
	// compare size of strings to check equals
	@Test(priority = 4)
	public void getUserBooksSmokeTest() {
		String command = setCommand("get/getuserbooks.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 102;
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] getUserBooksIdDp() {
		return new Object[][] { { "get/getuserbooksempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "get/getuserbookszero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "get/getuserbooksletters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "get/getuserbooksspec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 5, dataProvider = "getUserBooksIdDp")
	public void getUserBooksIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
