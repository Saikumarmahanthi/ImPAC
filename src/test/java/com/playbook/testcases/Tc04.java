package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Pages.TopBar;
import com.framework.Utilies.Authentication;

public class Tc04 extends InvokeSetup {

	// @Test(priority = 0)
	public void SignIn() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		authtiontication.twoFactor();
		Thread.sleep(5000);
		TopBar topnav = new TopBar(driver);
		Assert.assertEquals(true, topnav.home().getText().equals("Home"));

	}

	// @Test(priority = 1)
	public void topNav() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		authtiontication.twoFactor();
		Thread.sleep(5000);
		TopBar topnav = new TopBar(driver);
		Assert.assertEquals(true, topnav.home().getText().equals("Home"));
		Assert.assertEquals(true, topnav.timeMachine().getText().equals("Time Machine"));
		Assert.assertEquals(true, topnav.playbook().getText().equals("Playbooks"));
		topnav.playbook();
		topnav.viewAll();
	}

	// @Test(priority = 2)
	public void playbooklist() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		authtiontication.twoFactor();
		Thread.sleep(5000);
		Playbook playbook = new Playbook(driver);
		TopBar topnav = new TopBar(driver);
		topnav.playbook();
		topnav.viewAll();
		Thread.sleep(10000);
		System.out.println(playbook.listpage().description().getText());
		Assert.assertTrue(playbook.listpage().description().getText()
				.equals("Manage and configure how you keep your environment compliant"));
		playbook.listpage().search();
		playbook.listpage().searchInput().setText("AMIT_1007");
		playbook.listpage().selectPlaybook("AMIT_1007");
		Assert.assertTrue(playbook.dashboard().title().getText().equals("Dashboard"));

	}

	@Test(priority = 3)
	public void sideMenu() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		authtiontication.twoFactor();
		Thread.sleep(5000);
		Playbook playbook = new Playbook(driver);
		TopBar topnav = new TopBar(driver);
		topnav.playbook();
		topnav.viewAll();
		Thread.sleep(10000);
		playbook.listpage().search();
		playbook.listpage().searchInput().setText("AMIT_1007");
		playbook.listpage().selectPlaybook("AMIT_1007");
		playbook.sideMenu().expand();

		playbook.sideMenu().select("Inventory");
		Assert.assertTrue(playbook.sideMenu().title("Inventory").isDisplayed());

		playbook.sideMenu().select("Configuration");
		Assert.assertTrue(playbook.sideMenu().title("Configuration").isDisplayed());

		playbook.sideMenu().select("Overview");
		Assert.assertTrue(playbook.sideMenu().title("Overview").isDisplayed());

		playbook.sideMenu().select("Change log");
		Assert.assertTrue(playbook.sideMenu().title("Change log").isDisplayed());

		playbook.sideMenu().select("Compliance Impact");
		Assert.assertTrue(playbook.sideMenu().title("Compliance Impact").isDisplayed());

		playbook.sideMenu().select("Scores");
		Assert.assertTrue(playbook.sideMenu().title("Compliance Scores").isDisplayed());

		playbook.sideMenu().select("Policies");
		Assert.assertTrue(playbook.sideMenu().title("Policies").isDisplayed());

		playbook.sideMenu().select("Violations");
		Assert.assertTrue(playbook.sideMenu().title("Violations").isDisplayed());

	}

}
