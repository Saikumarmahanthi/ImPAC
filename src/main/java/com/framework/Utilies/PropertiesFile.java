package com.framework.Utilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	/*
	 * This class contains accessing values defined in text fileA properties file is
	 * a simple text file commonly used to store data. It typically consists of
	 * key-value pairs
	 */
	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\Properties\\config.properties");
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	static {
		try {
			FileInputStream locaters = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resource\\Properties\\Locators.properties\\TopNav.properties");
			properties.load(locaters);
			locaters.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getlocater(String key) {
		return properties.getProperty(key);
	}
	
	
	static {
		try {
			FileInputStream playbook = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resource\\Properties\\Locators.properties\\locators.properties");
			properties.load(playbook);
			playbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getElement(String key) {
		return properties.getProperty(key);
	}

	static {
		try {
			FileInputStream assets = new FileInputStream(
					System.getProperty("user.dir") + "\\Properties\\data.properties");
			properties.load(assets);
			assets.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getdata(String key) {
		return properties.getProperty(key);
	}
	
	static {
		try {
			FileInputStream url = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resource\\Properties\\config.property\\Api.config");
			properties.load(url);
			url.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String geturl(String key) {
		return properties.getProperty(key);
	}
	
	
}
