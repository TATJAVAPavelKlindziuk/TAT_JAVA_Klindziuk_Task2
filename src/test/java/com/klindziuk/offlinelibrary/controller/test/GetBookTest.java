package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetBookTest extends BaseTest{
		
	@Test(priority = 0)
	public void getBookSmokeTest() {
		String command = setCommand("getbook/getbook.xml");
		int actual = controller.executeLibraryTask(command).length();
		int expected = 101;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getBookdDp() {
		return new Object[][] { { "getbook/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "getbook/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "getbook/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "getbook/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "getBookdDp")
	public void setBookDeprecatedTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
