/**
 * File Name: LoginTest.java Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.tests;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.ah.adactin.*;
import com.sqa.ah.pageObjects.*;

/**
 * This class tests the Adactin Hotel app login function with valid and invalid
 * credentials.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class LoginTest extends AdactinTest {

	/**
	 * @param baseurl
	 */
	public LoginTest(String baseurl) {
		super();
	}

	/**
	 * Test of login with invalid credentials
	 */
	@Test
	public void testInvalidLogin() {
		AdactinHomePage loginPage = new AdactinHomePage(this);
		loginPage.inValidLogin("annetest", " ");
	}

	/**
	 * Test of login with valid credentials
	 */
	@Test
	public void testValidLogin() throws InterruptedException {
		AdactinHomePage loginPage = new AdactinHomePage(this);
		loginPage.validLogin("annetest", "annepw");
		String pageTitle = this.driver.getTitle();
		Assert.assertEquals(pageTitle, "AdactIn.com - Search Hotel");
	}
}
