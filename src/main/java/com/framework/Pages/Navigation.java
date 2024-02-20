package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Utilies.PropertiesFile;

public class Navigation {

	WebDriver driver;

	public Navigation(WebDriver driver) {
		this.driver = driver;
	}

	public Button next() {
		return new Button(driver, PropertiesFile.getElement("next"));
	}

	/*
	 * This method uses the Button Class to click the "Cancel" button on the
	 * describe page.
	 * 
	 */
	public Button cancel() {
		return new Button(driver, PropertiesFile.getElement("cancel"));
	}
	public Button back() {
		return new Button(driver, PropertiesFile.getElement("back"));
	}
}
