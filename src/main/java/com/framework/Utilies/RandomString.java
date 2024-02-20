package com.framework.Utilies;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

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
