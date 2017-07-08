package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;


public class MarkIssuanceTest extends BaseTest {
	private static final String MARKISSUANCE_XML_PATH = XMLFILEPATH + "adminservice/markissuance/";
	
	@Test(priority = 0)
	public void markReturnSmokeTest() throws IOException {
		request = RequestParser.readFile(MARKISSUANCE_XML_PATH + "markissuance.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book issued successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] markIssuanceUserIdDp() throws IOException {
		return new Object[][] {
				{ MARKISSUANCE_XML_PATH + "markissuancelettersuserid.xml", NUMBER_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuancespecuserid.xml", NUMBER_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuanceemptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuancenulluserid.xml", NUMBER_EXCEPTION_MESSAGE},
			    };
	}

	@Test(priority = 1,dataProvider = "markIssuanceUserIdDp")
	public void markIssuanceUserIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] markIssunaceBookIdDp() throws IOException {
		return new Object[][] {
				{ MARKISSUANCE_XML_PATH + "markissuancelettersbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuancespecbookid.xml",	NUMBER_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuanceemptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ MARKISSUANCE_XML_PATH + "markissuancenullbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				};
	}

	@Test(priority = 2,dataProvider = "markIssunaceBookIdDp")
	public void markIssuanceBookIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}

}
