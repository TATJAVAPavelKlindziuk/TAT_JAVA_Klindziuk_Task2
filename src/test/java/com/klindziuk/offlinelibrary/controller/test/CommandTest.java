package com.klindziuk.offlinelibrary.controller.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommandTest extends BaseTest {
	
	@Test(priority = 0, expectedExceptions = IllegalArgumentException.class)
	public void epmtyCommandTest() {
		String command = setCommand("emptycommand.xml");
		controller.executeAdminTask(command);
	}
	
	@Test(priority = 1)
	public void wrongCommandTest() {
		String command = setCommand("wrongcommand.xml");
		String actual = controller.executeLibraryTask(command);
		String expected = "thiscommandisunsupported - this command unfortunately unsupported.";
		Assert.assertEquals(actual, expected);
	}
}
