package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MarkIssuanceTest extends BaseTest {
		
	@Test(priority = 0)
	public void markReturnSmokeTest() {
		String command = setCommand("markissuance/markissuance.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book issued successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] markIssuanceUserIdDp() {
		return new Object[][] {
				{ "markissuance/markissuancelettersuserid.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "markissuance/markissuancespecuserid.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "markissuance/markissuanceemptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "markissuance/markissuancenulluserid.xml", NUMBER_EXCEPTION_MESSAGE },
			    };
	}

	@Test(priority = 1,dataProvider = "markIssuanceUserIdDp")
	public void markIssuanceUserIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] markIssunaceBookIdDp() {
		return new Object[][] {
				{ "markissuance/markissuancelettersbookid.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "markissuance/markissuancespecbookid.xml",	NUMBER_EXCEPTION_MESSAGE },
				{ "markissuance/markissuanceemptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "markissuance/markissuancenullbookid.xml", NUMBER_EXCEPTION_MESSAGE },
				};
	}

	@Test(priority = 2,dataProvider = "markIssunaceBookIdDp")
	public void markIssuanceBookIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
