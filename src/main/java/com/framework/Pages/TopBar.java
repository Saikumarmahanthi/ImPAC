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

	public Button home() {
		return new Button(driver, PropertiesFile.getlocater("home"));
	}

	public Button timeMachine() {
		return new Button(driver, PropertiesFile.getlocater("timemachime"));
	}

	public Button playbook() {
		return new Button(driver, PropertiesFile.getlocater("playbook"));
	}
	public Button viewAll() {
		return new Button(driver, PropertiesFile.getlocater("viewall"));
	}

	public Dropdown playbookName(String name) {
		return new Dropdown(driver, "//div[text()='" + name + "']");
	}

	public TextField search() {
		return new TextField(driver, PropertiesFile.getProperty("search"));
	}

}
