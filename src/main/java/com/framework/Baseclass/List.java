package com.framework.Baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class List {
	WebDriver driver;
	java.util.List<WebElement> element;

	public List(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElements(By.xpath(locator));
	}

	
	public int size() {
		return element.size();
	}
}
