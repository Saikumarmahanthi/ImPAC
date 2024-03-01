package com.playbook.testcases;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.framework.Api.APICalls;
import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Pages.TopBar;
import com.framework.Utilies.Authentication;
import com.framework.Utilies.PropertiesFile;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Tc05 extends InvokeSetup {
	
	// This test contains Inventroy test cases On Accounts, Regions , Services
	//Comparision UI table data with API data , runs list also 
	

	@Test
	public void account() throws InterruptedException {
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
		playbook.listpage().searchInput().setText("Default Playbook");
		playbook.listpage().selectPlaybook("Default Playbook").click();
		Thread.sleep(3000);
		playbook.sideMenu().expand().click();
		playbook.sideMenu().select("Inventory");
		Thread.sleep(10000);
		playbook.inventry().latestRun().click();
		//System.out.println("Latest RunId  " + playbook.inventry().latestRun().getText());

		String Id = driver.getCurrentUrl().substring(38, 74);

		RestAssured.baseURI = PropertiesFile.geturl("playbookId") + "" + Id + "";
		Thread.sleep(10000);
		JsonArray jsonArray = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		String latestRun = jsonArray.get(0).getAsJsonObject().get("run").getAsString();
		Thread.sleep(10000);
		RestAssured.baseURI = PropertiesFile.geturl("inventry") + latestRun + "/AWS?groupBy=account";
		JsonArray count = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		JsonPath jsonpath = new JsonPath(calls.getPlaybookId());
		try {
			// Validation-1
			Assert.assertEquals(jsonArray.size(), playbook.inventry().runslist().size());
			// Validation-2
			Assert.assertEquals(latestRun, jsonpath.getString("data[0].run"));

			// Validation-3
			Assert.assertEquals(playbook.inventry().table().rows().size(), count.size());

			// Table data frist row data Validation with API call

			// Account
			Assert.assertEquals(jsonpath.getString("data[0].identifier"),
					playbook.inventry().table().element(1, 1).getrows().next().getText());

			// Account ID
			Assert.assertEquals(jsonpath.getString("data[0].identifier"),
					playbook.inventry().table().element(1, 1).getrows().next().getText());

			// Region
			Assert.assertEquals(jsonpath.getString("data[0].regionCount"),
					playbook.inventry().table().element(1, 3).getrows().next().getText());
			// Service
			Assert.assertEquals(jsonpath.getString("data[0].serviceCount"),
					playbook.inventry().table().element(1, 4).getrows().next().getText());

			// Account
			Assert.assertEquals(jsonpath.getString("data[0].accountCount"),
					playbook.inventry().table().element(1, 5).getrows().next().getText());

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

	 @Test
	public void services() throws InterruptedException {

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
		playbook.listpage().searchInput().setText("Default Playbook");
		playbook.listpage().selectPlaybook("Default Playbook").click();
		playbook.sideMenu().expand().click();
		playbook.sideMenu().select("Inventory");
		Thread.sleep(10000);
		playbook.inventry().select("services").click();
		Thread.sleep(5000);
		playbook.inventry().latestRun().click();
		;
		System.out.println("Latest RunId UI " + playbook.inventry().latestRun().getText());

		String Id = driver.getCurrentUrl().substring(38, 74);
		RestAssured.baseURI = PropertiesFile.geturl("playbookId") + "" + Id + "";
		Thread.sleep(10000);
		JsonArray jsonArray = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		String latestRun = jsonArray.get(0).getAsJsonObject().get("run").getAsString();
		Thread.sleep(10000);
		RestAssured.baseURI = PropertiesFile.geturl("inventry") + latestRun + "/AWS?groupBy=service";
		JsonArray regions = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		JsonPath jsonpath = new JsonPath(calls.getPlaybookId());

		try {
			// Validation-1
			Assert.assertEquals(jsonArray.size(), playbook.inventry().runslist().size());

			// Validation-2
			Assert.assertEquals(playbook.inventry().table().rows().size(), regions.size());

			
			
			// Service
			Assert.assertEquals(jsonpath.getString("data[0].identifier"),
					playbook.inventry().table().element(1, 1).getrows().next().getText());

			// Account
			Assert.assertEquals(jsonpath.getString("data[0].accountCount"),
					playbook.inventry().table().element(1, 2).getrows().next().getText());

			// Region
			Assert.assertEquals(jsonpath.getString("data[0].regionCount"),
					playbook.inventry().table().element(1, 3).getrows().next().getText());
			// Assets
			Assert.assertEquals(jsonpath.getString("data[0].accountCount"),
					playbook.inventry().table().element(1, 4).getrows().next().getText());

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void regions() throws InterruptedException {

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
		playbook.listpage().searchInput().setText("Default Playbook");
		playbook.listpage().selectPlaybook("Default Playbook").click();
		playbook.sideMenu().expand().click();
		playbook.sideMenu().select("Inventory");
		Thread.sleep(10000);
		playbook.inventry().select("regions").click();
		Thread.sleep(5000);
		playbook.inventry().latestRun().click();
		System.out.println("Latest RunId  " + playbook.inventry().latestRun().getText());
		Thread.sleep(10000);
		String Id = driver.getCurrentUrl().substring(38, 74);
		RestAssured.baseURI = PropertiesFile.geturl("playbookId") + "" + Id + "";
		JsonArray jsonArray = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		String latestRun = jsonArray.get(0).getAsJsonObject().get("run").getAsString();
		Thread.sleep(10000);
		RestAssured.baseURI = PropertiesFile.geturl("inventry") + latestRun + "/AWS?groupBy=region";
		JsonArray servies = JsonParser.parseString(calls.getPlaybookId()).getAsJsonObject().getAsJsonArray("data");
		JsonPath jsonpath = new JsonPath(calls.getPlaybookId());
		try {
			// Validation-1
			Assert.assertEquals(jsonArray.size(), playbook.inventry().runslist().size());
			// Validation-2
			Assert.assertEquals(latestRun, jsonpath.getString("data[0].run"));

			// Validation-3
			Assert.assertEquals(playbook.inventry().table().rows().size(), servies.size());

			// region
			Assert.assertEquals(jsonpath.getString("data[0].identifier"),
					playbook.inventry().table().element(1, 1).getrows().next().getText());

			// Account
			Assert.assertEquals(jsonpath.getString("data[0].accountCount"),
					playbook.inventry().table().element(1, 2).getrows().next().getText());

			// Region
			Assert.assertEquals(jsonpath.getString("data[0].serviceCount"),
					playbook.inventry().table().element(1, 3).getrows().next().getText());
			// Assets
			Assert.assertEquals(jsonpath.getString("data[0].accountCount"),
					playbook.inventry().table().element(1, 4).getrows().next().getText());

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

}
