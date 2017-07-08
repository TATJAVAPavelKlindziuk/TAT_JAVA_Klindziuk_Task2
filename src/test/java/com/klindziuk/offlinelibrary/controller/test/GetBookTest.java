package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class GetBookTest extends BaseTest{
	private static final String GETBOOK_XML_PATH = XMLFILEPATH + "libraryservice/getbook/";
	
	@Test(priority = 0)
	public void getBookSmokeTest() throws IOException {
		request = RequestParser.readFile(GETBOOK_XML_PATH + "getbook.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 101;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getBookdDp() throws IOException {
		return new Object[][] { { GETBOOK_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ GETBOOK_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GETBOOK_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ GETBOOK_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "getBookdDp")
	public void setBookDeprecatedTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
