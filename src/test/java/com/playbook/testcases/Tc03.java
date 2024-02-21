package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Baseclass.BrowserSetup;
import com.framework.Pages.Playbook;
import com.framework.Utilies.Authenticattion;

public class Tc03 extends BrowserSetup {
	@Test
	public void runDetails() throws InterruptedException {

		Authenticattion authentication = new Authenticattion(driver);
		authentication.twoFactor();
		Thread.sleep(90000);
		Playbook playbook = new Playbook(driver);
		playbook.listpage().search().click();
		playbook.listpage().searchInput().setText("sElrsEavmq");
		Assert.assertEquals(false, playbook.listpage().selectPlaybook("sElrsEavmq").isVisible());
		playbook.listpage().selectPlaybook("sElrsEavmq").click();
	}
}
