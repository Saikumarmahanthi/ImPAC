package com.framework.Api;

import org.testng.annotations.Test;

import com.framework.Utilies.PropertiesFile;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICalls {

	static RequestSpecification requestSpecification;
	static Response response;

	static String bearerToken = PropertiesFile.getProperty("token");

	@Test
	public static JsonPath getPlaybookId() {
		requestSpecification = RestAssured.given();
		response = requestSpecification.get(RestAssured.baseURI);
		JsonPath jsonPath = new JsonPath(response.prettyPrint());
		return jsonPath;
	}
}
