package com.framework.Pages;

import org.openqa.selenium.WebDriver;

public class Playbook {

	WebDriver driver;

	public Playbook(WebDriver driver) {
		this.driver = driver;
	}

	public CreatePlaybook createPlaybook() {
		return new CreatePlaybook(driver);
	}

	public ListPage listpage() {
		return new ListPage(driver);
	}

	public Navigation navigation() {
		return new Navigation(driver);
	}

	public CreatePlay createPlay() {
		return new CreatePlay(driver);
	}

	public Summary summary() {
		return new Summary(driver);
	}

	public Dashboard dashboard() {
		return new Dashboard(driver);
	}
	public Menu sideMenu() {
		return new Menu(driver);
	}
	
	public Inventry inventry() {
		return new Inventry(driver);
	}

}
