package com.framework.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int minCount = 0;
	int maxCount = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (minCount < maxCount) {
			minCount++;
			return true;
		}

		return false;
	}

}
