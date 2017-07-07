package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

/**
 * GetAll, GetAllSubscriptions, GetAllUsers, GetUserBooks tests
 */
public class GetAllTest extends BaseTest {

	// compare size of strings to check equals
	@Test(priority = 1)
	public void getAllBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getallbooks.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 1040;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 2)
	public void getAllUsersSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getallUsers.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 1339;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 3)
	public void getAllSubscriptionsSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getallsubscriptions.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 684;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 4)
	public void getUserBooksTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getuserbooks.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 102;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void getUserBooksLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getuserbooksletters.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void getUserBooksZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getuserbookszero.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 7)
	public void getUserBooksSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/get/getuserbooksspec.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
