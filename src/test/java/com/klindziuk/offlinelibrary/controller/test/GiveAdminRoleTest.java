package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

/**
 * Test cases are the same for RemoveAdminRole
 *
 */
public class GiveAdminRoleTest extends BaseTest {
	private static final String GIVEADMIN_XML_PATH = XMLFILEPATH + "adminservice/giveadminrole/";

	@Test(priority = 0)
	public void giveAdminRoleSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminrole.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Admin rights successfully granted.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] giveAdminRoleDp() throws IOException {
		return new Object[][] { { GIVEADMIN_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ GIVEADMIN_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GIVEADMIN_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GIVEADMIN_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "giveAdminRoleDp")
	public void giveAdminRoleTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
