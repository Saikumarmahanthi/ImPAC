package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.Dropdown;

public class Menu {
	WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}

	public Button select() {
		return new Button(driver, "");
	}

	public Dropdown playbookName() {
		return new Dropdown(driver, "");
	}

	public Button dashboard() {
		return new Button(driver, "");
	}

	public Button configuration() {
		return new Button(driver, "");
	}

	public Button scores() {
		return new Button(driver, "");
	}

	public Button policies() {
		return new Button(driver, "");
	}

	public Button violations() {
		return new Button(driver, "");
	}

	public Button changeLog() {
		return new Button(driver, "");
	}

	public Button complianceImpact() {
		return new Button(driver, "");
	}

	public Button runPlaybook() {
		return new Button(driver, "");
	}

	public Button details() {
		return new Button(driver, "");
	}

}
