package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.TextField;

public class Schedule {
	public WebDriver driver;

	public Schedule(WebDriver driver) {
		this.driver = driver;
	}

	public Button scheduleType(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public Button type(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}
	public Button hours(String hour) {
		return new Button(driver, "//ul[@aria-label='Select hours']//li[text()='" + hour + "']");
	}
	
	public Button minutes(String minute) {
		return new Button(driver, "//ul[@aria-label='Select minutes']//li[text()='" + minute + "']");
	}
	
	public Button meridiem(String noon ) {
		return new Button(driver, "//ul[@aria-label='Select meridiem']//li[text()='" + noon + "']");
	}
	
	public Button Clock() {
		return new Button(driver, "//button[@type='button']");
	}

	public TextField setTime() {
		return new TextField(driver, "//input[@id='timeInput']");
	}

	public Button selectCalender() {
		return new Button(driver, "//input[@id='dateInput']/../../div[2]");
	}

	public TextField setCalender() {
		return new TextField(driver, "//input[@id='dateInput']");
	}

	
	public Button day(String label) {
		return new Button(driver, "//button[text()='" + label + "']");
	}
	
	public Button publish() {
		return new Button(driver, "//button[text()='Publish']");
	}
	public Button recurrenceSchedule(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}
	public String getAlertText() {
		return new TextField(driver, "//div[@class='popup-content']").getText();
	}
	
	public void closeAlert() {
		 new Button(driver,"//button[@class='crossIcon']").click();
	}
	
	
	
}
