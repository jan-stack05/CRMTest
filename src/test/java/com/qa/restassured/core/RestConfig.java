package com.qa.restassured.core;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

public class RestConfig {

	public static RequestSpecification getRequestSpec(){
		RestAssured.baseURI = RestassuredCommon.baseUrl;
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		//reqSpec.headers(GlobalVariables.hKey,RestassuredCommon.BasicAuth);
		//reqSpec.basePath(RestassuredCommon.basePath);
		reqSpec.contentType("application/json");
		System.out.println(reqSpec);
		return reqSpec;
	}
	
}
