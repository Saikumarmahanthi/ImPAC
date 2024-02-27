package com.framework.Utilies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;

	/*
	 * This class configures Extent Reports to generate HTML reports in a separate
	 * folder of the specified path
	 */

	public static ExtentReports generateReports() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\Reports.html");
		extent.attachReporter(spark);
		spark.config().setReportName("ImPAC Test Results");
		spark.config().setDocumentTitle("Int02 Environment");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		spark.config().setTheme(Theme.DARK);

		extent.setSystemInfo("Application URL", PropertiesFile.getProperty("url"));
		extent.setSystemInfo("Browser Name", PropertiesFile.getProperty("browser"));
		extent.setSystemInfo("Email Id", PropertiesFile.getProperty("Email"));
		extent.setSystemInfo("User Name ", "M Saikumar");

		return extent;

	}

}