package com.framework.Pages;


import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Table;

public class CommonTable {
	WebDriver driver;

	public CommonTable(WebDriver driver) {
		this.driver = driver;
	}

	public Table header() {
		return new Table(driver, "//div[@data-testid='table']//tr[1]");
	}

	public Table rows() {
		return new Table(driver, "//div[@data-testid='table']//tr");
	}

	public Table column() {
		return new Table(driver, "//div[@data-testid='table']//td");
	}

	public Table element(int one , int two) {
		return new Table(driver, "//div[@data-testid='table']//tr["+one+"]//td["+two+"]");
	}

}
