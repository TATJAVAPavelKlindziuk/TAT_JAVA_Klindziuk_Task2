package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveBookFromWishListTest extends BaseTest {
	
	@Test(priority = 0)
	public void addBooksSmokeTest() {
		String command = setCommand("removebookfromwishlist/removebookfromwishlist.xml");
		String actual = controller.executeAdminTask(command);
		String expected = "Book succefully removed from your wishlist.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] removeBookFromWishListDp() {
		return new Object[][] { 
			    { "removebookfromwishlist/emptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "removebookfromwishlist/emptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ "removebookfromwishlist/lettersuserid.xml", NUMBER_EXCEPTION_MESSAGE  }, 
				{ "removebookfromwishlist/lettersbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "removebookfromwishlist/specuserid.xml", NUMBER_EXCEPTION_MESSAGE}, 
				{ "removebookfromwishlist/specbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "removebookfromwishlist/nulluserid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ "removebookfromwishlist/nullbookid.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}
	
	@Test(priority = 1, dataProvider = "removeBookFromWishListDp")
	public void addBookToWishListTest(String request, String expected) {
		String command = setCommand(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
