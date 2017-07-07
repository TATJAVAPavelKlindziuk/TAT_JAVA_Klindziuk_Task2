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
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturn.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book returned successfully";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] markReturnUserId() throws IOException {
		return new Object[][] {
				{ MARKRETRUN_XML_PATH + "markreturnlettersuserid.xml","Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
				{ MARKRETRUN_XML_PATH + "markreturnspecuserid.xml",	"Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
				{ MARKRETRUN_XML_PATH + "markreturnemptyuserid.xml","Cannot perform this operation.Parameters cannot be null or empty."},
				{ MARKRETRUN_XML_PATH + "markreturnnulluserid.xml","Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
			    };
	}

	@Test(priority = 1,dataProvider = "markReturnUserId")
	public void markReturnUserIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] markReturnBookId() throws IOException {
		return new Object[][] {
				{ MARKRETRUN_XML_PATH + "markreturnlettersbookid.xml","Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
				{ MARKRETRUN_XML_PATH + "markreturnspecbookid.xml",	"Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
				{ MARKRETRUN_XML_PATH + "markreturnemptybookid.xml","Cannot perform this operation.Parameters cannot be null or empty."},
				{ MARKRETRUN_XML_PATH + "markreturnnullbookid.xml","Cannot perform this operation.Only numbers allowed.Id cannot be zero."},
				};
	}

	@Test(priority = 2,dataProvider = "markReturnBookId")
	public void markReturnBookIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
