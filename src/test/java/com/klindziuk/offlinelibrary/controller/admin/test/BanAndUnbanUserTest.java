package com.klindziuk.offlinelibrary.controller.admin.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.test.BaseTest;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;

/**
 * Ban and Unban user have same test cases
 *
 */
public class BanAndUnbanUserTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void banUserSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/banuser/banuser.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "User successfully banned.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void banUserEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/banuser/banuserempty.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void banUserLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/banuser/banuserletters.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void banUserZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/banuser/banuserzero.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void banUserSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/banuser/banuserspec.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}
}
