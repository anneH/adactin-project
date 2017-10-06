/**
 * File Name: Core.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 6, 2017
 */
package com.sqa.ah.core;

import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.ah.helpers.*;

/**
 * Core class for setting the baseurl and Webdriver.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class Core {

	private String baseurl;

	protected WebDriver driver;

	private BasicTest curTest;

	private Logger log;

	private int count = 1;

	/**
	 * @param test
	 */
	public Core(BasicTest test) {
		this.setCurTest(test);
		this.baseurl = test.getBaseurl();
		this.driver = test.getDriver();
	}

	/**
	 * @param baseurl
	 */
	public Core(String baseurl) {
		this.baseurl = baseurl;
	}

	/**
	 * @param baseurl
	 * @param driver
	 */
	public Core(String baseurl, WebDriver driver) {
		super();
		this.baseurl = baseurl;
		this.driver = driver;
	}

	/**
	 * @return the baseurl
	 */
	public String getBaseurl() {
		return this.baseurl;
	}

	/**
	 * @return the curTest
	 */
	public BasicTest getCurTest() {
		return this.curTest;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * @param propName
	 * @return property from the properties file
	 */
	public String getProp(String propName) {
		return AutoBasics.getProp(propName, "src/main/resources/", "config.properties", getLog());
	}

	/**
	 * @param locator
	 * @return false
	 */
	public boolean isElementPresent(By locator) {
		return false;
	}

	/**
	 * @param baseurl
	 *            the baseurl to set
	 */
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	/**
	 * @param curTest
	 *            the curTest to set
	 */
	public void setCurTest(BasicTest curTest) {
		this.curTest = curTest;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Takes a screenshot and count
	 */
	public void takeScreenshot() {
		AutoBasics.takeScreenshot("screenshots/", "AutoTest" + this.count, getDriver(), this.getLog());
		this.count++;
	}

	/**
	 * Takes a screenshot
	 *
	 * @param name
	 */
	public void takeScreenshot(String name) {
		AutoBasics.takeScreenshot("screenshots/", name, getDriver(), this.getLog());
	}

	/**
	 * Gets the log
	 *
	 * @return
	 */
	private Logger getLog() {
		return this.log;
	}
}
