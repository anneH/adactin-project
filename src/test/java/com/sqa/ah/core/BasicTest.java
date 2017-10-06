/**
 * File Name: BasicTest.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 6, 2017
 */
package com.sqa.ah.core;

import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

/**
 * This class contains methods to set up the driver before each class, get the
 * url before each method, and quit the driver after the class.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class BasicTest extends Core {

	/**
	 * @param baseurl
	 */
	public BasicTest(String baseurl) {
		super(baseurl);
	}

	/**
	 * Creates the Firefox driver before the class
	 */
	@BeforeClass
	public void setupDriver() {
		this.driver = new FirefoxDriver();
	}

	/**
	 * Gets the driver and opens the base url before each method
	 */
	@BeforeMethod
	public void setupTest() {
		getDriver().get(getBaseurl());
	}

	/**
	 * Quits the driver after the class
	 */
	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}
}
