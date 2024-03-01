package com.playbook.testcases;

import org.testng.annotations.Test;

import com.framework.Api.APICalls;
import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Pages.TopBar;
import com.framework.Utilies.Authentication;
import com.framework.Utilies.PropertiesFile;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;

public class Tc06 extends InvokeSetup {

	@Test
	public void configuration() throws InterruptedException {
		Authentication authtiontication = new Authentication(driver);
		APICalls calls = new APICalls();
		authtiontication.twoFactor();
		Thread.sleep(5000);
		Playbook playbook = new Playbook(driver);
		TopBar topnav = new TopBar(driver);
		topnav.playbook().click();
		topnav.viewAll().click();
		Thread.sleep(10000);
		playbook.listpage().search().click();
		playbook.listpage().searchInput().setText("AMIT_1007");
		playbook.listpage().selectPlaybook("AMIT_1007").click();
		Thread.sleep(3000);
		playbook.sideMenu().expand().click();
		playbook.sideMenu().select("Configuration");
		String Id = driver.getCurrentUrl().substring(38, 74);

		RestAssured.baseURI = PropertiesFile.geturl("playbookId") + "" + Id + "";
		Thread.sleep(10000);
		JsonArray jsonArray = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		Thread.sleep(10000);
		String latestRun = jsonArray.get(0).getAsJsonObject().get("run").getAsString();

		System.out.println(latestRun);

	}

}
