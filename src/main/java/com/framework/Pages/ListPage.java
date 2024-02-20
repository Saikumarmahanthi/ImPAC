package com.framework.Pages;

import org.openqa.selenium.WebDriver;


import com.framework.Baseclass.Button;
import com.framework.Baseclass.TextField;

public class ListPage {

	WebDriver driver;

	public ListPage(WebDriver driver) {
		this.driver = driver;
	}

	public Button createPlayBook() {
		return new Button(driver, "//img[@alt='createPlayicon']");
	}
	public TextField search() {
		return new TextField(driver, "//div[@data-testid='searchIcon']");
	}
	public TextField searchInput() {
		return new TextField(driver, "//input[@class='search_input']");
	}
	public TextField selectPlaybook(String name) {
		return new TextField(driver, "//p[text()='"+name+"']");
	}
}
