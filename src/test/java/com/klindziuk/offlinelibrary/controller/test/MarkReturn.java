package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class MarkReturn extends BaseTest {
	@Test(priority = 1)
	public void markReturnSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturn.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book returned successfully";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void markReturnNullBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnnullbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void markReturnNullUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnnulluserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void markReturnEmptyUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnemptyuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 5)
	public void markReturnEmptyBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnemptybookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void markReturnSpecUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnspecuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 7)
	public void markReturnSpecBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnspecbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 8)
	public void markReturnLettersBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnlettersbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 9)
	public void markReturnLettersUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markreturn/markreturnlettersuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
