package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.TopBar;
import com.framework.Utilies.Authentication;

public class Tc05 extends InvokeSetup {

	@Test
	public void m1() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		authtiontication.twoFactor();
		Thread.sleep(3000);
		TopBar topnav = new TopBar(driver);
		Assert.assertEquals(false, topnav.timeMachine().getText().contains("Time Machine"));
	}

	@Test
	public void m2() {

	}
}
