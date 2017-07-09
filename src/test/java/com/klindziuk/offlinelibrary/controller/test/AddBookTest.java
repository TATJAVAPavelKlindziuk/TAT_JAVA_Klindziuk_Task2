package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBookTest extends BaseTest {
		
	@Test(priority = 0)
	public void addBooksSmokeTest() {
		String command = setCommand("addbook/addbook.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book added successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] addBookEmptyFieldsDp() {
		return new Object[][] { 
			    { "addbook/emptyname.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "addbook/emptyauthor.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "addbook/emptyyear.xml", EMPTY_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "addBookEmptyFieldsDp")
	public void addBookEmptyFieldsTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] addBookSpecFieldsDp() {
		return new Object[][] {
			    { "addbook/specname.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "addbook/specauthor.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "addbook/specyear.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "addBookSpecFieldsDp")
	public void addBookSpecFieldsTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] addBookNullFieldsDp() {
		return new Object[][] {
			    { "addbook/nullname.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "addbook/nullauthor.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "addbook/nullyear.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 3, dataProvider = "addBookNullFieldsDp")
	public void addBookNullFieldsTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
