package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.Baseclass.Button;
import com.framework.Baseclass.Checkboxs;
import com.framework.Baseclass.TextField;
import com.framework.Utilies.PropertiesFile;

public class CreatePlaybook {
	WebDriver driver;

	public CreatePlaybook(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Desctiption This method uses the TextFiled Class to enter the playbook name
	 * in the place holder field on the describe page. Example :PlaceBook Name: =
	 * "Compliance Book"
	 */
	public TextField name() {
		return new TextField(driver, PropertiesFile.getElement("name"));
	}

	/*
	 * Desctiption This method uses the TextFiled Class to enter the playbook
	 * description in the place holder field on the describe page. Example:
	 * PlaceBook Description = "This Placebook for Testing Purpose"
	 */
	public TextField description() {
		return new TextField(driver, PropertiesFile.getElement("description"));
	}
	/*
	 * This method uses the Button Class to click the "Next" button on the describe
	 * page.
	 * 
	 */

	public Button createPlay() {
		return new Button(driver, PropertiesFile.getElement("createPlay"));

	}

	public Checkboxs allFrameworks() {
		return new Checkboxs(driver, PropertiesFile.getElement("selectallframes"));
	}

	public Checkboxs framework(String framework) {
		return new Checkboxs(driver, "//div[text()='" + framework + "']/../..//img");
	}

	public Schedule schedule() {
		return new Schedule(driver);
	}
}
