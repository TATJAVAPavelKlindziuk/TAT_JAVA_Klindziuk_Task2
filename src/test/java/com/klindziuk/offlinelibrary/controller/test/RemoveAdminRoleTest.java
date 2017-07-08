package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class RemoveAdminRoleTest extends BaseTest {
	private static final String REMOVEADMIN_XML_PATH = XMLFILEPATH + "adminservice/removeadminrole/";

	@Test(priority = 0)
	public void giveAdminRoleSmokeTest() throws IOException {
		request = RequestParser.readFile(REMOVEADMIN_XML_PATH + "removeadminrole.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Admin rights successfully removed.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] removeAdminRoleDp() throws IOException {
		return new Object[][] { { REMOVEADMIN_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ REMOVEADMIN_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ REMOVEADMIN_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ REMOVEADMIN_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "removeAdminRoleDp")
	public void removeAdminRoleTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
