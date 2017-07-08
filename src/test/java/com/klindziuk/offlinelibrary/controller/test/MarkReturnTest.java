package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class MarkReturnTest extends BaseTest {
	private static final String MARKRETRUN_XML_PATH = XMLFILEPATH + "adminservice/markreturn/";
	@Test(priority = 0)
	public void markReturnSmokeTest() throws IOException {
		request = RequestParser.readFile(MARKRETRUN_XML_PATH + "markreturn.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book returned successfully";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] markReturnUserIdDp() throws IOException {
		return new Object[][] {
				{ MARKRETRUN_XML_PATH + "markreturnlettersuserid.xml",NUMBER_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnspecuserid.xml",	NUMBER_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnemptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnnulluserid.xml", NUMBER_EXCEPTION_MESSAGE},
			    };
	}

	@Test(priority = 1,dataProvider = "markReturnUserIdDp")
	public void markReturnUserIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] markReturnBookIdDp() throws IOException {
		return new Object[][] {
				{ MARKRETRUN_XML_PATH + "markreturnlettersbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnspecbookid.xml",	NUMBER_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnemptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ MARKRETRUN_XML_PATH + "markreturnnullbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				};
	}

	@Test(priority = 2,dataProvider = "markReturnBookIdDp")
	public void markReturnBookIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
