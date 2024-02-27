package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Utilies.PropertiesFile;

public class Navigation {

	WebDriver driver;

	public Navigation(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method uses the Button Class to click the "Next" button on the Specific
	 * page.
	 */
	public Button next() {
		return new Button(driver, PropertiesFile.getElement("next"));
	}

	/*
	 * This method uses the Button Class to click the "Cancel" button on the
	 * Specific page.
	 */
	public Button cancel() {
		return new Button(driver, PropertiesFile.getElement("cancel"));
	}

	/*
	 * This method uses the Button Class to click the "Back" button on the Specific
	 * page.
	 */
	public Button back() {
		return new Button(driver, PropertiesFile.getElement("back"));
	}
}
