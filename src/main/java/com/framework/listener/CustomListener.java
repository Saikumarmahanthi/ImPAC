package com.framework.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.framework.Baseclass.BrowserSetup;

public class CustomListener implements ITestListener, IAnnotationTransformer {
	
	String filePath = System.getProperty("user.dir") + File.separator + "Screenshots";

	public void onTestFailure(ITestResult result) {
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);
	}

	public void takeScreenShot(String methodName) {
		File scrFile = ((TakesScreenshot) BrowserSetup.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void transform(ITestAnnotation annotation) {
		annotation.setRetryAnalyzer(Retry.class);
	}
}
