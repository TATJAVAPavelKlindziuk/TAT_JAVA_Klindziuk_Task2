package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBookToWishListTest extends BaseTest{
		
	@Test(priority = 0)
	public void addBooksSmokeTest() {
		String command = setCommand("addbooktowishlist/addbooktowishlist.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book succefully added to your wishlist.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] addBookToWishListDp() {
		return new Object[][] { 
			    { "addbooktowishlist/emptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "addbooktowishlist/emptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "addbooktowishlist/lettersuserid.xml", NUMBER_EXCEPTION_MESSAGE  }, 
				{ "addbooktowishlist/lettersbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "addbooktowishlist/specuserid.xml", NUMBER_EXCEPTION_MESSAGE}, 
				{ "addbooktowishlist/specbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "addbooktowishlist/nulluserid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "addbooktowishlist/nullbookid.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}
	
	@Test(priority = 1, dataProvider = "addBookToWishListDp")
	public void addBookToWishListTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
