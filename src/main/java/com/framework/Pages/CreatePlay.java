package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.Checkboxs;
import com.framework.Baseclass.TextField;
import com.framework.Utilies.PropertiesFile;

public class CreatePlay {
	WebDriver driver;
	public Checkboxs selectOptions;

	public CreatePlay(WebDriver driver) {
		this.driver = driver;
	}
	
//	public Button selectAccountsToInclude() {
//		return new Button(driver, PropertiesFile.getElement("selectaccountsToInclude"));
//	}

	public TextField name() {
		return new TextField(driver, PropertiesFile.getElement("playName"));
	}

	public TextField description() {
		return new TextField(driver, PropertiesFile.getElement("playdescription"));
	}

	public Checkboxs selectAllAccounts() {
		return new Checkboxs(driver, PropertiesFile.getElement("selectallaccounts"));

	}

	public Checkboxs selectAllRegions() {
		return new Checkboxs(driver, PropertiesFile.getElement("selectallregions"));

	}

	public Checkboxs selectAllServices() {
		return new Checkboxs(driver, PropertiesFile.getElement("selectallservices"));

	}

	public Button includeAccounts() {
		return new Button(driver, PropertiesFile.getElement("selectaccountsToInclude"));
	}

	public Button regionsInclude() {
		return new Button(driver, PropertiesFile.getElement("selectregionsToInclude"));
	}

	public Button serviceInclude() {
		return new Button(driver, PropertiesFile.getElement("selectservicesToInclude"));
	}

	public Button create() {
		return new Button(driver, PropertiesFile.getElement("create"));
	}

	public Button update() {
		return new Button(driver, "//button[text()='Update']");
	}

	public void select(String label) {
		selectOptions = new Checkboxs(driver, "//label[@for='"+label+"']//img");
		selectOptions.click();
	}
	
	/*
	 * This method selects the all options from the Checkbox list in Play creation
	 * Page using the Checkbox Class.
	 * 
	 * 
	 */
	public Checkboxs includeAll() {
		return new Checkboxs(driver, "//label[@for='select-all']//img");
	}

	/*
	 * This method Clik on "Apply" button in Play creation Page using the Button
	 * Class
	 */
	public Button apply() {
		return new Button(driver, "//button[text()='Apply']");
	}

	/*
	 * This method Search the button in Play creation Page using the Button Class
	 */
	public TextField search(String label) {
		return new TextField(driver, "//input[@placeholder='Search " + label + "']");
	}
	
	
	

}
