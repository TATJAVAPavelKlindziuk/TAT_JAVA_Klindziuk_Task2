package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MarkReturnTest extends BaseTest {
	
	@Test(priority = 0)
	public void markReturnSmokeTest() {
		String command = setCommand("markreturn/markreturn.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book returned successfully";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] markReturnUserIdDp() {
		return new Object[][] {
				{ "markreturn/markreturnlettersuserid.xml",NUMBER_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnspecuserid.xml",	NUMBER_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnemptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnnulluserid.xml", NUMBER_EXCEPTION_MESSAGE},
			    };
	}

	@Test(priority = 1,dataProvider = "markReturnUserIdDp")
	public void markReturnUserIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] markReturnBookIdDp() {
		return new Object[][] {
				{ "markreturn/markreturnlettersbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnspecbookid.xml",	NUMBER_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnemptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE},
				{ "markreturn/markreturnnullbookid.xml", NUMBER_EXCEPTION_MESSAGE},
				};
	}

	@Test(priority = 2,dataProvider = "markReturnBookIdDp")
	public void markReturnBookIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
