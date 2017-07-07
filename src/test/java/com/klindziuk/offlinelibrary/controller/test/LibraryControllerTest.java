package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class LibraryControllerTest extends BaseTest {

	// compare size of strings to check equals
	@Test(priority = 1)
	public void getAllBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getallbooks.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 1040;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 2)
	public void getBookSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getbook/getbook.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 101;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void getBookEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getbook/getbookempty.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void getBookLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getbook/getbookletters.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void getBookZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getbook/getbookzero.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void getBookSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getbook/getbookspec.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 7)
	public void addToWishListSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/addbooktowishlist/addbooktowishlist.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Book succefully added to your wishlist.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 8)
	public void findByNameSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/findby/findbyname.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 99;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 9)
	public void findByNameEmptyTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/findby/findbynameempty.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 10)
	public void findByNameNumbersTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/findby/findbynamenumbers.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 11)
	public void findByNameSpecTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/findby/findbynamespec.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 12)
	public void findByAuthorTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/findby/findbyauthor.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 104;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 13)
	public void getUserBooksTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/getuserbooks.xml");
		int actual = controller.executeLibraryTask(request).length();
		int expected = 102;
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 14)
	public void removeBookFromWishListTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlist.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Book succefully removed from your wishlist.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 15)
	public void updateProfileSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/updateprofile/updateprofile.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Profile successfully updated.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 16)
	public void updateProfileEmptyNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/updateprofile/updateprofileempty.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 17)
	public void updateProfileNumbersNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/updateprofile/updateprofilenumbers.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 18)
	public void updateProfileSpecNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/updateprofile/updateprofilespec.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 19)
	public void addToWishListEmptyUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/addbooktowishlist/addbooktowishlistemptyuserid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 20)
	public void addToWishListEmptyBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/addbooktowishlist/addbooktowishlistemptybookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 21)
	public void addToWishListNullUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/addbooktowishlist/addbooktowishlistnulluserid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 22)
	public void addToWishListNullBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/addbooktowishlist/addbooktowishlistnullbookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	// compare size of strings to check equals
	@Test(priority = 23)
	public void removeFromWishListEmptyBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistemptybookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 24)
	public void removeFromWishListNullUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistnullbookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 25)
	public void removeFromWishListNullBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistnullbookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 26)
	public void removeWishListEmptyUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistemptyuserid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 27)
	public void addToWishListSpecUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistspecuserid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 28)
	public void removeWishListSpecBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/removebookfromwishlist/removebookfromwishlistspecbookid.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 29)
	public void wrongCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "libraryservice/wrongcommand.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "updateProfileg - this command unfortunately unsupported.";
		Assert.assertEquals(actual, expected);
	}
}
