package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BanUserTest extends BaseTest {
	
	@Test(priority = 0)
	public void banUserSmokeTest() {
		String command = setCommand("banuser/banuser.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "User successfully banned.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] banUserDp() {
		return new Object[][] { { "banuser/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "banuser/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "banuser/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "banuser/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "banUserDp")
	public void banUserTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
