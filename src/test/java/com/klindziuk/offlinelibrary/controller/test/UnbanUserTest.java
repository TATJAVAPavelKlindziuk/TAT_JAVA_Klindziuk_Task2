package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnbanUserTest extends BaseTest {
	
	@Test(priority = 0)
	public void unBanUserSmokeTest() {
		String command = setCommand("unbanuser/unbanuser.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "User successfully unbanned.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] unBanUserDp()  {
		return new Object[][] { { "unbanuser/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "unbanuser/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "unbanuser/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "unbanuser/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "unBanUserDp")
	public void banUserTest(String request, String expected)  {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
