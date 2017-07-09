package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SetBookDeprecatedTest extends BaseTest {
	
	@Test(priority = 0)
	public void setBookDeprecatedSmokeTest() {
		String command = setCommand("setbookdeprecated/setbookdeprecated.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book deprecated successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] setBookDeprecatedDp() {
		return new Object[][] { { "setbookdeprecated/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "setbookdeprecated/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "setbookdeprecated/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "setbookdeprecated/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "setBookDeprecatedDp")
	public void setBookDeprecatedTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
