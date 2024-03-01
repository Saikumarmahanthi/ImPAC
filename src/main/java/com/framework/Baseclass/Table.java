package com.framework.Baseclass;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Table {

	WebDriver driver;
	List<WebElement> element;

	public Table(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElements(By.xpath(locator));
	}

	/*
	 * Description: This method get All colomn headers presented on Table it returns
	 * the list of elements
	 * 
	 */
	public Iterator<WebElement> values() {
		return element.iterator();	
	}

	
	public Iterator<WebElement> getrows() {
		return element.iterator();	
	}
	public int size() {
		return element.size()-1;
		
	}
	public void text() {
	//	return element.;
		
	}


	/*
	 * Description: This method click on specifeid column presented on the Table.
	 */
	public WebElement searchTable(String searchData) {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='table_wrapper']//tbody//tr//td"));
		for (WebElement cell : list) {
			if (cell.getText().equals(searchData)) {
				return cell;
			}
		}

		return null;
	}

	/*
	 * Description: This method search specifeid text presented on the Table.
	 */
	public void getHeaders(String locators) {
		List<WebElement> thead1 = driver.findElements(By.xpath(locators));
		for (WebElement cell : thead1) {
			String cellValue = cell.getText();
		}
	}


}
