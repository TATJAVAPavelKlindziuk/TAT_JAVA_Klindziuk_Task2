package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class FindByTest extends BaseTest {
private static final String FINDBY_XML_PATH = XMLFILEPATH + "libraryservice/findby/";
	
	// compare size of strings to check equals
	@Test(priority = 0)
	public void FindByNameSmokeTest() throws IOException {
		request = RequestParser.readFile(FINDBY_XML_PATH + "findbyname.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 99;
		Assert.assertEquals(actual, expected);
	}
	
	// compare size of strings to check equals
	@Test(priority = 1)
	public void FindByAuthorSmokeTest() throws IOException {
		request = RequestParser.readFile(FINDBY_XML_PATH + "findbyauthor.xml");
		int actual = controller.executeAdminTask(request).length();
		int expected = 104;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] findBytDp() throws IOException {
		return new Object[][] { 
			    { FINDBY_XML_PATH + "nameempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ FINDBY_XML_PATH + "authorempty.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ FINDBY_XML_PATH + "namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, 
				{ FINDBY_XML_PATH + "authornumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, 
				{ FINDBY_XML_PATH + "namespec.xml", SPEC_STRING_EXCEPTION_MESSAGE}, 
				{ FINDBY_XML_PATH + "namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, }; 
		}
	
	@Test(priority = 2, dataProvider = "findBytDp")
	public void addBookToWishListTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
