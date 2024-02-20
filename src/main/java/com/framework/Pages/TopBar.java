package com.framework.Pages;

import org.openqa.selenium.WebDriver;
import com.framework.Baseclass.Button;
import com.framework.Baseclass.Dropdown;
import com.framework.Baseclass.TextField;
import com.framework.Utilies.PropertiesFile;

public class TopBar {

	WebDriver driver;

	public TopBar(WebDriver driver) {
		this.driver = driver;
	}

	public Button select(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public TextField search() {
		return new TextField(driver, PropertiesFile.getProperty(""));
	}

	public Dropdown playbookName(String name) {
		return new Dropdown(driver, "//div[text()='" + name + "']");
	}

}
