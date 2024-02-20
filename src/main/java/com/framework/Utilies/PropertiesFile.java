package com.framework.Utilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
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
			FileInputStream playbook = new FileInputStream(
					System.getProperty("user.dir") + "\\Properties\\locators.properties");
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

	public static String getProperty(String string, Class<String[]> class1) {
		// TODO Auto-generated method stub
		return properties.getProperty(string);
	}
	

}
