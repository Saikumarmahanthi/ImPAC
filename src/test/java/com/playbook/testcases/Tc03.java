package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Api.APICalls;
import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Utilies.Authentication;
import com.framework.Utilies.PropertiesFile;

import io.restassured.RestAssured;

public class Tc03 extends InvokeSetup {
	@Test
	public void dashboard() throws InterruptedException {

		Authentication authentication = new Authentication(driver);
		authentication.twoFactor();
		Thread.sleep(90000);
		Playbook playbook = new Playbook(driver);
		playbook.listpage().search().click();
		playbook.listpage().searchInput().setText("sElrsEavmq");
		Assert.assertEquals(false, playbook.listpage().selectPlaybook("sElrsEavmq").isVisible());
		playbook.listpage().selectPlaybook("sElrsEavmq").click();
		playbook.dashboard().playbookSatus().getText().equalsIgnoreCase("");
		String PbId = driver.getCurrentUrl().substring(48, 84);
		
		RestAssured.baseURI = PropertiesFile.getProperty("runs") + "" + PbId + "";
		//System.out.println(APICalls.getPlaybookId().getString("data[0].counts.passed"));

	}
}
