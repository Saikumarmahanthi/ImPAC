package com.framework.Utilies;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	/*
	 * This class will generate a random string of a specified length
	 */
	public String name() {
		return RandomStringUtils.randomAlphabetic(10);
	}

	public String Description() {
		return RandomStringUtils.randomAlphabetic(30);
	}

	public String Playname() {
		return RandomStringUtils.randomAlphabetic(9);
	}
}
