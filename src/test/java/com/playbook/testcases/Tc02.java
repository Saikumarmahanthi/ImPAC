package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Utilies.Authentication;
import com.framework.Utilies.JsonData;
import com.framework.Utilies.PropertiesFile;
import com.framework.Utilies.RandomString;
import com.framework.Utilies.SelectList;

public class Tc02 extends InvokeSetup {

	@Test
	public void CreateNew() throws InterruptedException {

		Authentication authentication = new Authentication(driver);
		// JsonData json=new JsonData(PropertiesFile.getdata("url"));

		authentication.twoFactor();
		Thread.sleep(90000);
		SelectList list = new SelectList(driver);
		Playbook playbook = new Playbook(driver);
		RandomString random = new RandomString();

		String name = random.name();
		playbook.listpage().createPlayBook().click();
		playbook.createPlaybook().name().setText(random.name());
		playbook.createPlaybook().description().setText(random.Description());
		playbook.navigation().next().click();

		int plays = 3;
		for (int i = 0; i < plays; i++) {
			playbook.createPlaybook().createPlay().click();
			playbook.createPlay().name().setText(random.name());
			playbook.createPlay().description().setText(random.Description());
			playbook.createPlay().includeAccounts().click();
			for (String account : list.accountlist()) {
				playbook.createPlay().select(account);
			}
			playbook.createPlay().apply().click();
			playbook.createPlay().regionsInclude().click();
			playbook.createPlay().includeAll().click();
			playbook.createPlay().apply().click();
			playbook.createPlay().serviceInclude().click();
			for (String service : list.servicelist()) {
				playbook.createPlay().select(service);
			}
			playbook.createPlay().apply().click();
			playbook.createPlay().create().click();
		}
		playbook.navigation().next().click();

		for (String select : list.frameworklist()) {
			playbook.createPlaybook().framework(select).click();
		}
		playbook.navigation().next().click();

		playbook.createPlaybook().schedule().type(PropertiesFile.getdata("type")).click();
		playbook.createPlaybook().schedule().scheduleType(PropertiesFile.getdata("schedule")).click();
		playbook.createPlaybook().schedule().day(PropertiesFile.getdata("day")).click();
		playbook.createPlaybook().schedule().Clock().click();
		playbook.createPlaybook().schedule().hours(PropertiesFile.getdata("hour")).click();
		playbook.createPlaybook().schedule().minutes(PropertiesFile.getdata("minutes")).click();
		playbook.createPlaybook().schedule().meridiem(PropertiesFile.getdata("noon")).click();
		Assert.assertEquals(true, playbook.createPlaybook().schedule().publish().isDisplayed());
		playbook.createPlaybook().schedule().publish().click();

		Assert.assertEquals(name, playbook.summary().getplaybookName().getText());
		playbook.summary().viewDetails().click();

	}

}
