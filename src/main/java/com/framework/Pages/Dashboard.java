package com.framework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.TextField;

public class Dashboard {

	WebDriver driver;
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public TextField playbookSatus() {
		return new TextField(driver, "//div[@data-tesid='runStatus']/span");
	}
	
	
	public TextField title() {
		return new TextField(driver, "//span[text()='Dashboard']");
	}
	
		
	public Button run() {
		return new Button(driver, "//div[@data-testid='runPlaybook']");
	}
	public Button abort() {
		return new Button(driver, "//div[@data-testid='abortPlaybook']");
	}
	
	public void viewAsset() {
		Button button=new Button(driver, "//div[text()='View Assets']");
		button.click();
	}
		
	public Button ellipsis() {
		return new Button(driver, "//div[@class='ellipsisClass']");
	}

	public Button ellipsislist(String label) {
		return new Button(driver, "//div[@class='menu_data' and text()='" + label + "']");
	}


	
	public Button tab(String label) {
		return new Button(driver, "//button[@data-testid='" + label + "']");
	}

	
	public Button waiverExemption() {
		return new Button(driver, "//button[text()='Request Exemption']");
	}

	public Button runslist() {
		return new Button(driver, "//div[@data-testid='runDropdown']");
	}

	public Button fristRun(String label) {
		return new Button(driver, "//li[@data-value='" + label + "']");
	}

	public Button export() {
		return new Button(driver, "//div[@data-testid='exportBtn']");
	}

	public Button exportAs(String label) {
		return new Button(driver, "//li[text()='Export as " + label + "']");
	}

	public List<WebElement> tablelist() {
		List<WebElement> tableruns = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		return tableruns;
	}

	public TextField status(String label) {
		return new TextField(driver, "//div[text()='" + label + "']");
	}

}
