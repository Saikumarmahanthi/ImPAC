package com.framework.Utilies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Baseclass.BrowserSetup;

public class Waits extends BrowserSetup {
	WebDriver driver;
	public Waits(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waituntill(int num, String Label) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(num));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + Label + "")));
		return element;
	}
}
