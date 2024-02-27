package com.playbook.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.Baseclass.InvokeSetup;
import com.framework.Pages.Playbook;
import com.framework.Utilies.Authentication;
import com.framework.Utilies.JsonData;
import com.framework.Utilies.PropertiesFile;
import com.framework.Utilies.RandomString;

public class Tc01 extends InvokeSetup {
	String name;

	@Test
	public void createPlaybook() throws InterruptedException, FileNotFoundException {
		Authentication authentication = new Authentication(driver);
		JsonData json = new JsonData(PropertiesFile.getdata("url"));
		authentication.twoFactor();
		Thread.sleep(10000);
		Playbook playbook = new Playbook(driver);
		RandomString random = new RandomString();
		playbook.listpage().createPlayBook().click();
		name = random.name();

		playbook.createPlaybook().name().setText(name);
		playbook.createPlaybook().description().setText(random.Description());
		playbook.navigation().next().click();

		playbook.createPlaybook().createPlay().click();
		playbook.createPlay().name().setText(random.name());
		playbook.createPlay().description().setText(random.Description());
		playbook.createPlay().selectAllAccounts().click();
		playbook.createPlay().selectAllRegions().click();
		playbook.createPlay().selectAllServices().click();
		playbook.createPlay().create().click();
		playbook.navigation().next().click();
		Thread.sleep(3000);
		playbook.createPlaybook().allFrameworks().click();
		playbook.navigation().next().click();

		playbook.createPlaybook().schedule().type(PropertiesFile.getdata("type")).click();
		playbook.createPlaybook().schedule().Clock().click();
		playbook.createPlaybook().schedule().hours(PropertiesFile.getdata("hour")).click();
		playbook.createPlaybook().schedule().minutes(PropertiesFile.getdata("minutes")).click();
		playbook.createPlaybook().schedule().meridiem(PropertiesFile.getdata("noon")).click();
		Assert.assertEquals(true, playbook.createPlaybook().schedule().publish().isDisplayed());
		playbook.createPlaybook().schedule().publish().click();

		Assert.assertEquals(name, playbook.summary().getplaybookName().getText());
		playbook.summary().viewList().click();
		playbook.listpage().search().click();

		playbook.listpage().searchInput().setText(name);
		playbook.listpage().selectPlaybook(name).click();

	}

	@Test
	public void updatePlaybook() throws InterruptedException {

		Authentication authentication = new Authentication(driver);
		authentication.twoFactor();
		Thread.sleep(5000);
		Playbook playbook = new Playbook(driver);
		playbook.listpage().search().click();
		playbook.listpage().searchInput().setText("sElrsEavmq");
		Assert.assertEquals(false, playbook.listpage().selectPlaybook("sElrsEavmq").isVisible());
		playbook.listpage().selectPlaybook("sElrsEavmq").click();
//		playbook.dashboard().playbookSatus().getText().equalsIgnoreCase("");
//		String PbId = driver.getCurrentUrl().substring(48, 84);		
//		String PbId="0234d24f-89d5-495d-a57b-d120acafe5b2";
//		RestAssured.baseURI =  PropertiesFile.getProperty("runs") + "" + PbId + "";
//		System.out.println(APICalls.getPlaybookId().getString("data[0].counts.passed"));
//		
	}
}
