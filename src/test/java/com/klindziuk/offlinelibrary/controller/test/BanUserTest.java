package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class BanUserTest extends BaseTest {
	private static final String BANUSER_XML_PATH = XMLFILEPATH + "adminservice/banuser/";

	@Test(priority = 0)
	public void banUserSmokeTest() throws IOException {
		request = RequestParser.readFile(BANUSER_XML_PATH + "banuser.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "User successfully banned.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] banUserDp() throws IOException {
		return new Object[][] { { BANUSER_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ BANUSER_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ BANUSER_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ BANUSER_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "banUserDp")
	public void banUserTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
