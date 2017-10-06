/**
 * File Name: ChromeTest.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 16, 2017
 */
package com.sqa.ah.core;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

/**
 * ChromeTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class BasicChromeTest extends BasicTest {

	/**
	 * @param baseurl
	 */
	public BasicChromeTest(String baseurl) {
		super(baseurl);
	}

	/**
	 * Creates the Chrome driver before the class
	 * 
	 * @see com.sqa.ah.core.BasicTest#setupDriver()
	 */
	@Override
	@BeforeClass
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.driver = new ChromeDriver();
	}
}
