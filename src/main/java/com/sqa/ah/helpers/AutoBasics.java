/**
 * File Name: AutoBasics.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 9, 2017
 */
package com.sqa.ah.helpers;

import java.io.*;
import java.util.*;
import java.util.NoSuchElementException;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * This class contains automation helper methods for working with web elements,
 * taking a screenshot, and getting properties from the properties file.
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	/**
	 * @param driver
	 * @param tagName
	 * @return web element list by tag name
	 */
	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		return null;
	}

	/**
	 * @param driver
	 * @param locator
	 * @param prop
	 * @param value
	 * @return web element list by CSS property
	 */
	public static List<WebElement> getCSSPropBasedElements(WebDriver driver, By locator, String prop, String value) {
		List<WebElement> elements = driver.findElements(locator);
		ArrayList<WebElement> filteredElements = new ArrayList<WebElement>();
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getCssValue(prop).equalsIgnoreCase(value)) {
				filteredElements.add(elements.get(i));
			}
		}
		return filteredElements;
	}

	/**
	 * @param driver
	 * @return web element list
	 */
	public static List<WebElement> getLinks(WebDriver driver) {
		return null;
	}

	/**
	 * @param driver
	 * @return web element list by img tag name
	 */
	public static List<WebElement> getPictures(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		return elements;
	}

	/**
	 * @param propName
	 * @param fileLocation
	 * @param fileName
	 * @param logger
	 * @return property
	 */
	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
		}
		return props.getProperty(propName);
	}

	/**
	 * @param driver
	 * @param locator
	 * @return list of contents
	 */
	public static List<String> getTextContents(WebDriver driver, By locator) {
		return null;
	}

	/**
	 * @param driver
	 * @param by
	 * @param logger
	 * @return true if element is found, false if element is not found
	 */
	public static boolean isElementPresent(WebDriver driver, By by, Logger logger) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.warn("Element was not found: " + by);
			return false;
		}
	}

	/**
	 * @param driver
	 * @param logger
	 */
	public static void logImportantImages(WebDriver driver, Logger logger) {
		List<WebElement> images = AutoBasics.getPictures(driver);
		for (int i = 0, j = 1; i < images.size(); i++) {
			if (!images.get(i).getAttribute("alt").equalsIgnoreCase("")) {
				System.out.println("#" + (j) + ": [" + images.get(i).getAttribute("alt") + "] SRC="
						+ images.get(i).getAttribute("src"));
				j++;
			}
		}
	}

	/**
	 * @param fileLocation
	 * @param fileName
	 * @param driver
	 * @param logger
	 * @return true if screenshot file was saved, false if not saved
	 */
	public static boolean takeScreenshot(String fileLocation, String fileName, WebDriver driver, Logger logger) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(fileLocation + "/" + fileName + ".png"));
			return true;
		} catch (IOException e) {
			logger.warn("Screenshot " + fileName + " was not captured to disk correctly.");
			return false;
		}
	}
}
