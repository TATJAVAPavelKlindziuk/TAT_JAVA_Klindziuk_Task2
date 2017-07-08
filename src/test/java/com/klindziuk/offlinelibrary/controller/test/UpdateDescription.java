package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class UpdateDescription extends BaseTest {
	private static final String UPDATEDECRIPTION_XML_PATH = XMLFILEPATH + "adminservice/updatebookdescription/";
	
	@Test(priority = 0)
	public void updateDescriptionSmokeTest() throws IOException {
		request = RequestParser.readFile(UPDATEDECRIPTION_XML_PATH + "updatebookdescription.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book description successfully updated.";
		Assert.assertEquals(actual, expected);
	}
		
	@DataProvider
	public Object[][] updateDescriptionIdDp() throws IOException {
		return new Object[][] { 
			    { UPDATEDECRIPTION_XML_PATH + "idempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "idletters.xml", NUMBER_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "idspec.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "updateDescriptionIdDp")
	public void updateDescriptionIdTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] updateDescriptionNameDp() throws IOException {
		return new Object[][] { 
			    { UPDATEDECRIPTION_XML_PATH + "nameempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "namespec.xml", SPEC_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 2, dataProvider = "updateDescriptionNameDp")
	public void updateDescriptionNameTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] updateDescriptionAuthorDp() throws IOException {
		return new Object[][] { 
			    { UPDATEDECRIPTION_XML_PATH + "authorempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "authornumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ UPDATEDECRIPTION_XML_PATH + "authorspec.xml", SPEC_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 3, dataProvider = "updateDescriptionAuthorDp")
	public void addBookEmptyFieldsTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
