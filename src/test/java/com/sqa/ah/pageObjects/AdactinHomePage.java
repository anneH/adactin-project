/**
 * File Name: LoginPage.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;

import com.sqa.ah.core.*;

/**
 * This class contains the methods and elements for the Adactin Hotel app login
 * page.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinHomePage extends BasicPage {

	private WebElement username;

	private WebElement password;

	private WebElement login;

	@FindBy(css = ".auth_error>b")
	private WebElement invalidLoginText;

	/**
	 * @param test
	 */
	public AdactinHomePage(BasicTest test) {
		super(test);
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login.getAttribute("value");
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password.getAttribute("value");
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return this.username.getAttribute("value");
	}

	/**
	 * Method to test login with invalid credentials.
	 *
	 * @param userN
	 * @param passW
	 */
	public void inValidLogin(String userN, String passW) {
		this.username.clear();
		this.password.clear();
		this.username.sendKeys(userN);
		this.password.sendKeys(passW);
		this.login.click();
		Assert.assertEquals("Invalid Login Details", this.invalidLoginText.getText());
	}

	/**
	 * Method to test login with valid credentials.
	 *
	 * @param userN
	 * @param passW
	 */
	public void validLogin(String userN, String passW) {
		takeScreenshot();
		this.username.clear();
		this.password.clear();
		this.username.sendKeys(userN);
		this.password.sendKeys(passW);
		this.login.click();
	}
}
