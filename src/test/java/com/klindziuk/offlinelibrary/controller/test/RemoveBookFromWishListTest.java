package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class RemoveBookFromWishListTest extends BaseTest {
private static final String FROMWISHLIST_XML_PATH = XMLFILEPATH + "libraryservice/removebookfromwishlist/";
	
	@Test(priority = 0)
	public void addBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(FROMWISHLIST_XML_PATH + "removebookfromwishlist.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book succefully removed from your wishlist.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] removeBookFromWishListDp() throws IOException {
		return new Object[][] { 
			    { FROMWISHLIST_XML_PATH + "emptyuserid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ FROMWISHLIST_XML_PATH + "emptybookid.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
				{ FROMWISHLIST_XML_PATH + "lettersuserid.xml", NUMBER_EXCEPTION_MESSAGE  }, 
				{ FROMWISHLIST_XML_PATH + "lettersbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ FROMWISHLIST_XML_PATH + "specuserid.xml", NUMBER_EXCEPTION_MESSAGE}, 
				{ FROMWISHLIST_XML_PATH + "specbookid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ FROMWISHLIST_XML_PATH + "nulluserid.xml", NUMBER_EXCEPTION_MESSAGE }, 
				{ FROMWISHLIST_XML_PATH + "nullbookid.xml", NUMBER_EXCEPTION_MESSAGE }, };
	}
	
	@Test(priority = 1, dataProvider = "removeBookFromWishListDp")
	public void addBookToWishListTest(String request, String expected) throws IOException {
		String command = RequestParser.readFile(request);
		String actual = controller.executeAdminTask(command);
		Assert.assertEquals(actual, expected);
	}
}
