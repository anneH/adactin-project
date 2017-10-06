/**
 * File Name: HotelSearchTest.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.tests;

import org.testng.annotations.*;

import com.sqa.ah.adactin.*;
import com.sqa.ah.pageObjects.*;

/**
 * This test tests the hotel search function
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class HotelSearchTest extends AdactinTest {

	/**
	 * @param baseurl
	 */
	public HotelSearchTest(String baseurl) {
		super();
	}

	/**
	 * Test of hotel search with the following valid data: location: Sydney;
	 * hotel: Hotel Creek; room type: Standard; number of rooms: 1; check-in
	 * date: 9/17/207; check-out date: 9/18/2017; adults per room: 1; children
	 * per room: 1
	 */
	@Test
	public void testHotelLocationSearch() {
		AdactinHomePage loginPg = new AdactinHomePage(this);
		SearchHotelPage searchHotelPg = new SearchHotelPage(this);
		loginPg.validLogin("annetest", "annepw");
		searchHotelPg.searchHotels("Sydney", "Hotel Creek", "Standard", "1 - One", "9/17/2017", "9/18/2017", "1 - One",
				"1 - One");
	}
}
