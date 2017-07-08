package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class DeleteBookByIdTest extends BaseTest {
	private static final String DELETE_XML_PATH = XMLFILEPATH + "adminservice/deletebookbyid/";

	@Test(priority = 1)
	public void deleteBookByIdSmokeTest() throws IOException {
		request = RequestParser.readFile(DELETE_XML_PATH + "deletebookbyid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book deleted successfully.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] deleteBookByIdDp() throws IOException {
		return new Object[][] { { DELETE_XML_PATH + "empty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ DELETE_XML_PATH + "zero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ DELETE_XML_PATH + "letters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ DELETE_XML_PATH + "spec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "deleteBookByIdDp")
	public void deleteBookByIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
