package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class CommandTest extends BaseTest {
	
	@Test(priority = 0, expectedExceptions = IllegalArgumentException.class)
	public void epmtyCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "emptycommand.xml");
		controller.executeAdminTask(request);
	}
	
	@Test(priority = 1)
	public void wrongCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "wrongcommand.xml");
		String actual = controller.executeLibraryTask(request);
		String expected = "thiscommandisunsupported - this command unfortunately unsupported.";
		Assert.assertEquals(actual, expected);
	}
}
