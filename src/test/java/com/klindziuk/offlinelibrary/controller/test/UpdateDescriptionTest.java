package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateDescriptionTest extends BaseTest {
		
	@Test(priority = 0)
	public void updateDescriptionSmokeTest() {
		String command = setCommand("updatebookdescription/updatebookdescription.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book description successfully updated.";
		Assert.assertEquals(actual, expected);
	}
		
	@DataProvider
	public Object[][] updateDescriptionIdDp() {
		return new Object[][] { 
			    { "updatebookdescription/idempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "updatebookdescription/idletters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ "updatebookdescription/idspec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "updateDescriptionIdDp")
	public void updateDescriptionIdTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] updateDescriptionNameDp() {
		return new Object[][] { 
			    { "updatebookdescription/nameempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "updatebookdescription/namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "updatebookdescription/namespec.xml", SPEC_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "updateDescriptionNameDp")
	public void updateDescriptionNameTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] updateDescriptionAuthorDp() {
		return new Object[][] { 
			    { "updatebookdescription/authorempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "updatebookdescription/authornumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "updatebookdescription/authorspec.xml", SPEC_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 3, dataProvider = "updateDescriptionAuthorDp")
	public void addBookEmptyFieldsTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
