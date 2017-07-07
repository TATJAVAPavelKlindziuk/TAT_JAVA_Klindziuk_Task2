package com.klindziuk.offlinelibrary.controller.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class ClientControllerTest extends BaseTest {
	
	// compare size of strings to check equals
	@Test(priority = 1)
	public void getAllBooksTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/getallbooks.xml");
		int actual = controller.executeClientTask(request).length();
		int expected = 1040;
		Assert.assertEquals(actual, expected);
	}

	// string variable "false" when client is logged as user
	@Test(priority = 2)
	public void singInAsUserTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinasuser.xml");
		String actual = controller.executeClientTask(request);
		String expected = "false";
		Assert.assertEquals(actual, expected);
	}

	// string variable "true" when client is logged as user
	@Test(priority = 3)
	public void singInAsAdminTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinasadmin.xml");
		String actual = controller.executeClientTask(request);
		String expected = "true";
		Assert.assertEquals(actual, expected);
	}

	// login with unregistered user
	@Test(priority = 4)
	public void singInAsUnregisteredTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinasunregistered.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Login error.There are no users with this credentials.";
		Assert.assertEquals(actual, expected);
	}

	// login with registered user and empty password
	@Test(priority = 5)
	public void singInWithEmptyPasswordTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinwithemptypassword.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}

	// login with registered user and empty password
	@Test(priority = 6)
	public void singInWithEmptyNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinwithemptyname.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 7)
	public void singInWithSpecialSymbolsTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/signin/signinwithspecialsymbols.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	//only letters allowed for registration
	@Test(priority = 8)
	public void registerSmokeTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registration.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Registration completed successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 9)
	public void registerWithNumbersInLoginTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationnuberslogin.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 10)
	public void registerWithNumbersInPasswordTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationnuberspassword.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 11)
	public void registerWithSpecialSymbolsInLoginTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationspeclogin.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 12)
	public void registerWithSpecialSymbolsInPasswordTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationspecpassword.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 13)
	public void registerWithEpmtyLoginTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationemptylogin.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 14)
	public void registerWithEmptyPasswordTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationemptypassword.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Registration completed successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 15)
	public void registerWithEmptyNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationemptyname.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Parameters cannot be null or empty.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 16)
	public void registerWithNumbersNameTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationnumbersname.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 17)
	public void registerWithSpecTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registrationnumbersname.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.Only letters,dots,minus and whitespaces are allowed.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 18)
	public void registerDuplicateTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/registration/registration.xml");
		String actual = controller.executeClientTask(request);
		String expected = "Cannot perform this operation.User with this name already registered.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 19,expectedExceptions = IllegalArgumentException.class)
	public void epmtyCommandTest() throws IOException {
		request = RequestParser.readFile(XMLFILEPATH + "clientservice/emptycommand.xml");
		controller.executeClientTask(request);
	}
}
