package com.framework.Utilies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authentication {
	public WebDriver driver;

	public Authentication(WebDriver driver) {
		this.driver = driver;
	}

	public void twoFactor() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(PropertiesFile.getElement("userName")))
				.sendKeys(PropertiesFile.getProperty("Email"));
		driver.findElement(By.xpath(PropertiesFile.getElement("Password")))
				.sendKeys(PropertiesFile.getProperty("password"));
		driver.findElement(By.xpath(PropertiesFile.getElement("SignIn"))).click();
	}
}
