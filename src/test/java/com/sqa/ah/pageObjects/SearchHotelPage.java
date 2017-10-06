/**
 * File Name: SearchHotelPage.java<br>
 * Hesemann, Anne<br>
 * Created: Sep 17, 2017
 */
package com.sqa.ah.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.ah.core.*;

/**
 * This class contains the methods and elements for the Adactin Hotel app hotel
 * search
 *
 * @author Hesemann, Anne
 * @version 1.0.0
 * @since 1.0
 */
public class SearchHotelPage extends BasicPage {

	private WebElement location;

	private WebElement hotels;

	private WebElement room_type;

	private WebElement room_nos;

	private WebElement datepick_in;

	private WebElement datepick_out;

	private WebElement adult_room;

	private WebElement child_room;

	private WebElement Submit;

	private WebElement location_0;

	/**
	 * @param test
	 */
	public SearchHotelPage(BasicTest test) {
		super(test);
	}

	/**
	 * Method to test the hotel search form with valid data for location, hotel,
	 * room type, number of rooms, check in date, check out date, adults per
	 * room, and children per room.
	 * 
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRm
	 * @param childrenPerRm
	 */
	public void searchHotels(String location, String hotel, String roomType, String numRooms, String checkInDate,
			String checkOutDate, String adultsPerRm, String childrenPerRm) {
		Select selectorLoc = new Select(this.location);
		selectorLoc.selectByVisibleText(location);
		Select selectorHotel = new Select(this.hotels);
		selectorHotel.selectByVisibleText(hotel);
		Select selectRmType = new Select(this.room_type);
		selectRmType.selectByVisibleText(roomType);
		Select selectorNumRooms = new Select(this.room_nos);
		selectorNumRooms.selectByVisibleText(numRooms);
		this.datepick_in.clear();
		this.datepick_in.sendKeys(checkInDate);
		this.datepick_out.clear();
		this.datepick_out.sendKeys(checkOutDate);
		Select selectAdults = new Select(this.adult_room);
		selectAdults.selectByVisibleText(adultsPerRm);
		Select selectChildren = new Select(this.child_room);
		selectChildren.selectByVisibleText(childrenPerRm);
		this.Submit.click();
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementValue(this.location_0, "Sydney"));
	}
}
