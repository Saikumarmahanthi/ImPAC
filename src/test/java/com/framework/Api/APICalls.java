package com.framework.Api;


import org.testng.annotations.Test;

import com.framework.Utilies.PropertiesFile;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICalls {

	String bearerToken =PropertiesFile.geturl("token");

	public String getPlaybookId() {
		RequestSpecification requestSpecification = RestAssured.given().header("Authorization",
				"Bearer " + bearerToken);
		Response response = requestSpecification.get(RestAssured.baseURI);
		return response.prettyPrint();

	}

//	@Test
//	public void practcice() {
//		RequestSpecification requestSpecification = RestAssured.given().header("Authorization",
//				"Bearer " + bearerToken);
//		RestAssured.baseURI = "https://bs33j8iiwc.execute-api.us-east-1.amazonaws.com/rest/metrics/inventory/count/9d5bca0f-6fb1-460a-ba8a-161579be5ff5/AWS?groupBy=account";
//		Response response = requestSpecification.get(RestAssured.baseURI);;
//		JsonArray jsonArray = JsonParser.parseString(response.prettyPrint()).getAsJsonObject().getAsJsonArray("data");
//		String latestRun = jsonArray.get(0).getAsJsonObject().get("run").getAsString();
//		System.out.println(latestRun);
//	}
}
