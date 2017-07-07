package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;


public class MarkIssuanceTest extends BaseTest {
	
	@Test(priority = 1)
	public void markIssuanceSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuance.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book issued successfully.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void markIssuanceNullBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancenullbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void markIssuanceNullUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancenulluserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void markIssuanceEmptyUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuanceemptyuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 5)
	public void markIssuanceEmptyBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuanceemptybookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void markIssuanceSpecUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancespecuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void markIssuanceSpecBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancespecbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 7)
	public void markIssuanceLettersBookIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancelettersbookid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 8)
	public void markIssuanceLettersUserIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/markissuance/markissuancelettersuserid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
