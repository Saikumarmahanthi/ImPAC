package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.TextField;
import com.framework.Utilies.PropertiesFile;



public class Summary {
	public WebDriver driver;

	public Summary(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method identifies the Buttons of Create new playbook, Playbook view
	 * Details, Playbook list in playbook created sucessfull page
	 */
	public Button viewDetails() {
		return new Button(driver, "//div[text()='View Playbook Details']");
	}
	
	/*
	 * This method identifies the Buttons of Create new playbook, Playbook view
	 * Details, Playbook list in playbook created sucessfull page
	 */
	public Button viewList() {
		return new Button(driver, "//div[text()='View Playbook Lists']");
	}

	/*
	 * This method get the message of the created playbook 
	 */
	public TextField getMessage() {
		return new TextField(driver, PropertiesFile.getProperty("getmessage"));
	}
	public TextField getMessage1() {
		return new TextField(driver, PropertiesFile.getProperty("getmessage1"));
	}
	/*
	 * This method get the summary of the created playbook details
	 */
	
	public TextField getsummary() {
		return new TextField(driver, PropertiesFile.getProperty("getsummary"));
	}
	/*
	 * This method get the name of the created playbook
	 */
	public TextField getplaybookName() {
		return new TextField(driver, PropertiesFile.getProperty("playbookName"));
	}
	/*
	 * This method retrieves the images associated with button details.
	 */
	public String getIcon(String label) {
		Button icon = new Button(driver, "//div[text()='" + label + "']//..//img");
		return icon.getAttribute("svg");
	}

	/*
	 * This method close the playbook summary page
	 */
	public Button closeButton() {
		return new Button(driver, PropertiesFile.getProperty("close"));
	}

	/*
	 * This method get playbook image from the playbook summary page
	 */
	public String getImage() {
		Button img = new Button(driver, PropertiesFile.getProperty("playbookImg"));
		return img.getAttribute("svg");
	}
}
