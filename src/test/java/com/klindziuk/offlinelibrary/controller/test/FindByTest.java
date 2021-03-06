package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindByTest extends BaseTest {
	
	// compare size of strings to check equals
	@Test(priority = 0)
	public void FindByNameSmokeTest() {
		String command = setCommand("findby/findbyname.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 99;
		Assert.assertEquals(actual, expected);
	}
	
	// compare size of strings to check equals
	@Test(priority = 1)
	public void FindByAuthorSmokeTest() {
		String command = setCommand("findby/findbyauthor.xml");
		int actual = controller.executeAdminTask(command).length();
		int expected = 104;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] findBytDp() {
		return new Object[][] { 
			    { "findby/nameempty.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "findby/authorempty.xml", SPEC_STRING_EXCEPTION_MESSAGE },
				{ "findby/namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, 
				{ "findby/authornumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, 
				{ "findby/namespec.xml", SPEC_STRING_EXCEPTION_MESSAGE}, 
				{ "findby/namenumbers.xml", SPEC_STRING_EXCEPTION_MESSAGE }, }; 
		}
	
	@Test(priority = 2, dataProvider = "findBytDp")
	public void addBookToWishListTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
