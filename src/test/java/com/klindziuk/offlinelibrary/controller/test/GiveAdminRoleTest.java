package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GiveAdminRoleTest extends BaseTest {
	
	@Test(priority = 0)
	public void giveAdminRoleSmokeTest() {
		String command = setCommand("giveadminrole/giveadminrole.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Admin rights successfully granted.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] giveAdminRoleDp() {
		return new Object[][] { { "giveadminrole/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "giveadminrole/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "giveadminrole/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "giveadminrole/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "giveAdminRoleDp")
	public void giveAdminRoleTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
