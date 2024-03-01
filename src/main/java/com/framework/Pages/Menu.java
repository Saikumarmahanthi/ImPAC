package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.Dropdown;

public class Menu {
	WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}
	public void select(String label) {
		Button select=new Button(driver, "//div[text()='"+label+"']");
		select.click();
	}
	public Button expand() {
		return new Button(driver, "//*[@id='root']/div/div[2]/div/div[1]/div/div/div[1]/img");
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
