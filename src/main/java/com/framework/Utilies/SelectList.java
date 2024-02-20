package com.framework.Utilies;

import org.openqa.selenium.WebDriver;

public class SelectList {

	WebDriver driver;

	public SelectList(WebDriver driver) {
		this.driver = driver;
	}

	public String[] accountlist() {
		String[] account ={ "247703139660", "573506787709", "791644724903", "413899828174" };
		return account;
	}

	public String[] servicelist() {
		String[] service = { "IAM_GROUP", "IAM_POLICY", "IAM_ROLE", "IAM_USER" };
		return service;
	}
	
	
	public String[] regionlist() {
		String[] region = { "global", "ap-south-1", "us-east-2"};
		return region;
	}

	public String[] frameworklist() {
		String[] framework = { "CIS v1.4.0", "PCI v3.2.1", "NIST v800-53.r5" };
		return framework;
	}
}
