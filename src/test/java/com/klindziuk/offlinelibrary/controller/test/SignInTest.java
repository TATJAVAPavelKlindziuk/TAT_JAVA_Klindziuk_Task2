package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
	private static final String UNREGISTERED_MESSAGE = "Cannot perform this operation.Login error."
			+ "There are no users with this credentials.";

	// string variable "false" when client is logged as user
	@Test(priority = 0)
	public void signInAsUserSmokeTest() {
		String command = setCommand("signin/signinasuser.xml");
		String actual = controller.executeClientTask(command);
		String expected = "false";
		Assert.assertEquals(actual, expected);
	}

	// string variable "true" when client is logged as admin
	@Test(priority = 1)
	public void signInAsAdminSmokeTest() {
		String command = setCommand("signin/signinasadmin.xml");
		String actual = controller.executeClientTask(command);
		String expected = "true";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] signInDp() {
		return new Object[][] { { "signin/emptylogin.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "signin/emptypassword.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "signin/speclogin.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "signin/specpassword.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "signin/unregistered.xml", UNREGISTERED_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "signInDp")
	public void signInTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeClientTask(command);
		Assert.assertEquals(actual, expected);
	}
}
