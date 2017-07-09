package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteBookByIdTest extends BaseTest {
	
	@Test(priority = 1)
	public void deleteBookByIdSmokeTest() {
		String command = setCommand("deletebookbyid/deletebookbyid.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book deleted successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] deleteBookByIdDp() {
		return new Object[][] { { "deletebookbyid/empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "deletebookbyid/zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "deletebookbyid/letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "deletebookbyid/spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "deleteBookByIdDp")
	public void deleteBookByIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
