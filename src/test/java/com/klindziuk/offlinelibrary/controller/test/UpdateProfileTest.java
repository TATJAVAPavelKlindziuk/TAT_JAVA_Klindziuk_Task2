package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class UpdateProfileTest extends BaseTest{
private static final String UPDATE_XML_PATH = XMLFILEPATH + "libraryservice/updateprofile/";
	
	@Test(priority = 0)
	public void updateProfileSmokeTest() throws IOException {
		request = RequestParser.readFile(UPDATE_XML_PATH + "updateprofile.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Profile successfully updated.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] updateProfileDp() throws IOException {
		return new Object[][] { 
			    { UPDATE_XML_PATH + "idempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ UPDATE_XML_PATH + "idzero.xml", NUMBER_EXCEPTION_MESSAGE },
				{ UPDATE_XML_PATH + "idletters.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ UPDATE_XML_PATH + "idspec.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ UPDATE_XML_PATH + "nameempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE }, 
				{ UPDATE_XML_PATH + "namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ UPDATE_XML_PATH + "namespec.xml", SPEC_STRING_EXCEPTION_MESSAGE }, };
	}

	@Test(priority = 1, dataProvider = "updateProfileDp")
	public void updateProfileTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
