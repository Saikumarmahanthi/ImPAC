package com.framework.Utilies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authenticattion {
	WebDriver driver;

	public Authenticattion(WebDriver driver) {
		this.driver = driver;
	}
	
	public void twoFactor() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/form/div/input"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("i0116")).sendKeys("saikumar.mahanthi@divami.com");
		driver.findElement(By.id("idSIButton9")).click();
	}
}
