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
		return new Button(driver, "//div[text()='"+label+"']");
	}
	public Button expand() {
		return new Button(driver, "//img[@class='_expand_icon_g7jr7_45']");
	}
	public Button title(String title) {
		return new Button(driver, "//span[text()='"+title+"']");
	}	
	public Dropdown playbookName() {
		return new Dropdown(driver, "");
	}

	public Button runPlaybook() {
		return new Button(driver, "");
	}

	public Button details() {
		return new Button(driver, "");
	}

}
