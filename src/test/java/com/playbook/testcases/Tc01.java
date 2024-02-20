package com.playbook.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.Baseclass.BrowserSetup;
import com.framework.Pages.Playbook;
import com.framework.Utilies.Authenticattion;
import com.framework.Utilies.PropertiesFile;
import com.framework.Utilies.RandomString;


public class Tc01 extends BrowserSetup {

	@Test
	public void create() throws InterruptedException {
		Authenticattion authentication = new Authenticattion(driver);
		authentication.twoFactor();
		Thread.sleep(90000);
		Playbook playbook = new Playbook(driver);
		RandomString random = new RandomString();
		playbook.listpage().createPlayBook().click();
		String name = random.name();

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
		
		logger.info(random.name()+ " Play Created");  
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
		logger.info("Playbook Created successfully    "+name);  
		Assert.assertEquals(name, playbook.summary().getplaybookName().getText());
		playbook.summary().viewList().click();
		playbook.listpage().search().click();
		logger.info("Playbook List page opend "+name); 
		playbook.listpage().searchInput().setText(name);
		playbook.listpage().selectPlaybook(name).click();
		logger.info(name + " of Playbook Dashboard page Displayed"); 
	}

}
