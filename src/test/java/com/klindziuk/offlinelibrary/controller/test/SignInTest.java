package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class SignInTest extends BaseTest {
	private static final String SIGN_IN_XML_PATH = XMLFILEPATH + "clientservice/signin/";
	private static final String UNREGISTERED_MESSAGE = "Cannot perform this operation.Login error."
			+ "There are no users with this credentials.";

	// string variable "false" when client is logged as user
	@Test(priority = 0)
	public void signInAsUserSmokeTest() throws IOException {
		request = RequestParser.readFile(SIGN_IN_XML_PATH + "signinasuser.xml");
		String actual = controller.executeClientTask(request);
		String expected = "false";
		Assert.assertEquals(actual, expected);
	}

	// string variable "true" when client is logged as admin
	@Test(priority = 1)
	public void signInAsAdminSmokeTest() throws IOException {
		request = RequestParser.readFile(SIGN_IN_XML_PATH + "signinasadmin.xml");
		String actual = controller.executeClientTask(request);
		String expected = "true";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] signInDp() throws IOException {
		return new Object[][] { { SIGN_IN_XML_PATH + "emptylogin.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ SIGN_IN_XML_PATH + "emptypassword.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ SIGN_IN_XML_PATH + "speclogin.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ SIGN_IN_XML_PATH + "specpassword.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ SIGN_IN_XML_PATH + "unregistered.xml", UNREGISTERED_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "signInDp")
	public void signInTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeClientTask(command);
		Assert.assertEquals(actual, expected);
	}
}
