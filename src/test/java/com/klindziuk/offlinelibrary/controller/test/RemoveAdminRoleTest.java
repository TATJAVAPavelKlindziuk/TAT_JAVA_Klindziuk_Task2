package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveAdminRoleTest extends BaseTest {
	
	@Test(priority = 0)
	public void giveAdminRoleSmokeTest() {
		String command = setCommand("removeadminrole/removeadminrole.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Admin rights successfully removed.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] removeAdminRoleDp() {
		return new Object[][] { { "removeadminrole/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "removeadminrole/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "removeadminrole/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "removeadminrole/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "removeAdminRoleDp")
	public void removeAdminRoleTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
