package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

/**
 * Test cases are the same for RemoveAdminRole
 *
 */
public class GiveAndRemoveAdminRole extends BaseTest {
	
	@Test(priority = 1)
	public void giveAdminRoleSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminrole.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Admin rights successfully granted.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void giveAdminRoleEmptyIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminroleempty.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void giveAdminRoleLettersIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminroleletters.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void giveAdminRoleZeroIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminrolezero.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void giveAdminRoleSpecIdTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "adminservice/giveadminrole/giveadminrolespec.xml");
		String actual = controller.executeAdminTask(request);
		String expected = "Cannot perform this operation.Only numbers allowed.Id cannot be zero.";
		Assert.assertEquals(actual, expected);
	}

}
