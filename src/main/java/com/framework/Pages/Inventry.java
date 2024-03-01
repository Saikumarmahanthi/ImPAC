package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.List;
import com.framework.Baseclass.Tab;
import com.framework.Baseclass.Table;

public class Inventry {

	public WebDriver driver;

	public Inventry(WebDriver driver) {
		this.driver = driver;
	}

	public CommonTable table() {
		return new CommonTable(driver);
	}

	public Button latestRun() {
		return new Button(driver, "//div[@data-testid='commonDropDown']");

	}

	public List runslist() {
		return new List(driver, "//ul[@role='listbox']//li");
	}
	public Tab select(String tabname) {
		return new Tab(driver, "//button[@data-testid='"+tabname+"']");
		
	}

}