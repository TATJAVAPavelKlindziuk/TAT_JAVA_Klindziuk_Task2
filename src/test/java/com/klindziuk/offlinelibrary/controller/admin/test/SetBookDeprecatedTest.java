package com.klindziuk.offlinelibrary.controller.admin.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.test.BaseTest;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class SetBookDeprecatedTest extends BaseTest{

	@Test(priority = 1)
	public void setBookDeprecatedByIdSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/setbookdeprecated/setbookdeprecated.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book deprecated successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void  setBookDeprecatedByIdEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/setbookdeprecated/setbookdeprecatedempty.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void  setBookDeprecatedByIdLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/setbookdeprecated/setbookdeprecatedletters.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void  setBookDeprecatedByIdZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/setbookdeprecated/setbookdeprecatedzero.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void  setBookDeprecatedByIdSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/setbookdeprecated/setbookdeprecatedspec.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
