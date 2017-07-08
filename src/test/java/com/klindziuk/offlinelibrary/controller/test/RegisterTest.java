package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class RegisterTest extends BaseTest {
	private static final String REGISTER_XML_PATH = XMLFILEPATH + "clientservice/registration/";
	
		//only letters allowed for registration
		@Test(priority = 0)
		public void registerSmokeTest() throws IOException {
			request = RequestParser.readFile(REGISTER_XML_PATH + "registration.xml");
			String actual = controller.executeClientTask(request);
			String expected = "Registration completed successfully.";
			Assert.assertEquals(actual, expected);
		}

		@DataProvider
		public Object[][] registerDp() throws IOException {
			return new Object[][] { 
					{ REGISTER_XML_PATH + "emptylogin.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "emptypassword.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "emptyname.xml", EMPTY_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "speclogin.xml", SPEC_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "specpassword.xml", SPEC_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "specname.xml", SPEC_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "numberslogin.xml", SPEC_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "numberspassword.xml", SPEC_STRING_EXCEPTION_MESSAGE },
					{ REGISTER_XML_PATH + "numbersname.xml", SPEC_STRING_EXCEPTION_MESSAGE },};
			}

		@Test(priority = 1, dataProvider = "registerDp")
		public void registerTest(String request, String expected) throws IOException {
			String command = RequestParser.readFile(request);
			String actual = controller.executeClientTask(command);
			Assert.assertEquals(actual, expected);
		}
}
