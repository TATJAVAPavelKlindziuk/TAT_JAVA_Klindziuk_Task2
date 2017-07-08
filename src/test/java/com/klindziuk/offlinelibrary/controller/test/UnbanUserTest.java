package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class UnbanUserTest extends BaseTest {
	private static final String UNBANUSER_XML_PATH = XMLFILEPATH + "adminservice/unbanuser/";

	@Test(priority = 0)
	public void unBanUserSmokeTest() throws IOException {
		request = RequestParser.readFile(UNBANUSER_XML_PATH + "unbanuser.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "User successfully unbanned.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] unBanUserDp() throws IOException {
		return new Object[][] { { UNBANUSER_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ UNBANUSER_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ UNBANUSER_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ UNBANUSER_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "unBanUserDp")
	public void banUserTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
