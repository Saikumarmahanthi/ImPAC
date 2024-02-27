package com.framework.listener;

import org.testng.IAnnotationTransformer;

//
//public void onTestFailure(ITestResult result) {
//	String methodName = result.getName().toString().trim();
//	takeScreenShot(methodName);
//}
//
//public void takeScreenShot(String methodName) {
//	File scrFile = ((TakesScreenshot) BrowserSetup.driver).getScreenshotAs(OutputType.FILE);
//	try {
//		FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//
//}

//public class AnnotationTransfer implements IAnnotationTransformer {
//
//	public void transform(ITestAnnotation testAnnotation) {
//		testAnnotation.setRetryAnalyzer(Retry.class);
//	}
//
//}

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.framework.Baseclass.InvokeSetup;
import com.framework.Utilies.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener, IAnnotationTransformer {

	ExtentReports extentReport;
	ExtentTest extent;;
	String tcName;

	@Override
	public void onStart(ITestContext context) {
		extentReport = Reports.generateReports();

	}

	/*
	 * This method is invoked when a test method starts execution
	 */
	@Override
	public void onTestStart(ITestResult result) {
		tcName = result.getName();
		extent = extentReport.createTest(tcName);
		extent.log(Status.INFO, tcName + " Test case executing start");
		System.out.println(tcName + " Test case executing start");

	}
	/*
	 * This method is called when a test method successfully completes its execution
	 * without any assertion failures or exceptions. It provides information about
	 * the successful test method
	 */

	@Override
	public void onTestSuccess(ITestResult result) {
		extent.log(Status.PASS, tcName + "Test case successed");

	}

	/*
	 * This method is triggered when a test method fails due to an assertion failure
	 * or an unhandled exception. It provides information about the failed test
	 * method
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		extent.log(Status.FAIL, tcName + "Test case failed");
		extent.log(Status.INFO, result.getThrowable() + "Test case failed");
		extent.addScreenCaptureFromPath(InvokeSetup.screenshot(tcName));
	}

	/*
	 * This method is invoked when a test method is skipped, either due to
	 * dependencies not being met or because it is explicitly skipped using
	 * annotations such as @Test(enabled = false)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		extent.log(Status.SKIP, tcName + "Test case Skiped");
		extent.log(Status.INFO, tcName + "Test case Skiped");
	}

	/*
	 * This method is called after the execution of all the test methods within a
	 * <test> tag in the testng.xml file. It provides information about the test
	 * context via the ITestContext parameter.
	 */
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	/*
	 * The method will rerun failed test cases a specified number of times
	 */
	public void transform(ITestAnnotation testAnnotation) {
		testAnnotation.setRetryAnalyzer(Retry.class);

	}

}
