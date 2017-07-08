package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class SetBookDeprecatedTest extends BaseTest {
	private static final String DEPRECATED_XML_PATH = XMLFILEPATH + "adminservice/setbookdeprecated/";

	@Test(priority = 0)
	public void setBookDeprecatedSmokeTest() throws IOException {
		request = RequestParser.readFile(DEPRECATED_XML_PATH + "setbookdeprecated.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book deprecated successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] setBookDeprecatedDp() throws IOException {
		return new Object[][] { { DEPRECATED_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ DEPRECATED_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ DEPRECATED_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ DEPRECATED_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "setBookDeprecatedDp")
	public void setBookDeprecatedTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
