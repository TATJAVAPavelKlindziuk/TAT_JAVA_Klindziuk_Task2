package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class DeleteBookByIdTest extends BaseTest {
	
	@Test(priority = 1)
	public void deleteBookByIdSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/deletebookbyid/deletebookbyid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book deleted successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void deleteBookByIdEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/deletebookbyid/deletebookbyidempty.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void deleteBookByIdLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/deletebookbyid/deletebookbyidletters.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void deleteBookByIdZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/deletebookbyid/deletebookbyidzero.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void deleteBookByIdSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/deletebookbyid/deletebookbyidspec.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
