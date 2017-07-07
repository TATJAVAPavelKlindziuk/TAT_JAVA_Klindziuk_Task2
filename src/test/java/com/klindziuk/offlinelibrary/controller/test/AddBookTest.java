package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class AddBookTest extends BaseTest {

	@Test(priority = 1)
	public void addBooksSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/addbook.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book added successfully.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2, expectedExceptions = IllegalArgumentException.class)
	public void epmtyCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/emptycommand.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book added successfully.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void epmtyNameCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/emptyname.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void epmtyAuthorCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/emptyauthor.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void epmtyYearCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/emptyyear.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void specNameCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/specname.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 7)
	public void specAuthorCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/specauthor.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 8)
	public void nullYearCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/addbook/emptyyear.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
}
