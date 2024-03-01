package com.framework.Baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tab {
	WebDriver driver;
	String label;
	WebElement element;

	public Tab(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}
	

	/*
	 * Description: This method select tab present in the UI based on given name
	 */
	public Button tab() {
		// return new Button(driver, "//button[text()='" + label + "']"); //build-1
		// Xpath
		return new Button(driver, "//div[text()='" + label + "']");// build -2 xpath
	}
	
	public void click() {
		element.click();
	}
}
