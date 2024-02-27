package com.framework.Utilies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Baseclass.InvokeSetup;

public class Waits extends InvokeSetup {
	public static WebDriver driver;

	/*
	 * This class is designed to wait for a specific duration of time before
	 * throwing exceptions 
	 * 
	 */

	public static WebElement waituntill(int time, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(time));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + locator + "")));
		return element;
	}
}
