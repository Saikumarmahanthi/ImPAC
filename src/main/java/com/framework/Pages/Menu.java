package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.Dropdown;

public class Menu {
	WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}

	public Button select(String label) {
		return new Button(driver, "");
	}

	public Dropdown playbookName(String label) {
		return new Dropdown(driver, "");
	}
}
