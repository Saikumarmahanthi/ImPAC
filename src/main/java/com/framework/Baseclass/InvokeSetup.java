package com.framework.Baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.framework.Utilies.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeSetup {

	/*
	 * The Base class initializes browser configurations and extends the test class
	 * to execute test cases
	 */

	public static WebDriver driver;

	/*
	 * This annotations denotes a method that should be executed before each test
	 * method within a test class It is typically used to set up preconditions
	 * required for the test cases, such as initializing objects or setting up the
	 * environment
	 */
	@BeforeMethod
	public void beforeMethod() {
		try {
			setUp(Constants.browser);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * This Method that should be executed after each test method within a test
	 * class and it close the opened browser.
	 * 
	 */
	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}

	public void setUp(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}
	}

	public static String screenshot(String Name) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir") + "\\Screenshots\\" + Name + ".png";
		try {
			FileUtils.copyFile(file, new File(screenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
	}

}
