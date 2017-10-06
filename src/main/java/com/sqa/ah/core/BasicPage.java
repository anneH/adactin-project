/**
 * File Name: BasicPage.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 6, 2017
 */
package com.sqa.ah.core;

import org.openqa.selenium.support.*;

/**
 * BasicPage
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class BasicPage extends Core {

	/**
	 * BasicPage with PageFactory
	 *
	 * @param test
	 */
	public BasicPage(BasicTest test) {
		super(test);
		PageFactory.initElements(getDriver(), this);
	}
}
