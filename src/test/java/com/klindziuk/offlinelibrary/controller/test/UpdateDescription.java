package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class UpdateDescription extends BaseTest {
	
	@Test(priority = 1)
	public void updateDescriptionSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/updatebookdescription.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Book description successfully updated.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void updateDescriptionEmptyNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/emptyname.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void updateDescriptionNumbersNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/numbersname.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void updateDescriptionSpecNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/specname.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 5)
	public void updateDescriptionEmptyAuthorTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/emptyauthor.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void updateDescriptionNumbersAuthorTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/numbersauthor.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 7)
	public void updateDescriptionSpecAuthorTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/specauthor.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 8)
	public void updateDescriptionEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/emptyid.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 9)
	public void updateDescriptionLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/lettersId.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 10)
	public void updateDescriptionSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/updatedescription/specId.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
