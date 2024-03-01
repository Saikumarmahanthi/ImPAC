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

	// 
	
		@Test
	public void updatePlaybook() throws InterruptedException {

		//  I will continue these test cases once I have the new UI design screen for updating the playbook.
		
		Authentication authentication = new Authentication(driver);
		authentication.twoFactor();
		Thread.sleep(5000);
		Playbook playbook = new Playbook(driver);
		playbook.listpage().search().click();
		playbook.listpage().searchInput().setText("sElrsEavmq");
		Assert.assertEquals(true, playbook.listpage().selectPlaybook("sElrsEavmq").isVisible());
		playbook.listpage().selectPlaybook("sElrsEavmq").click();
		
	}

}
