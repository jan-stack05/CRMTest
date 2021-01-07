package com.qa.restassured.apis.library;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.qa.restassured.core.CommonUtils;
import com.qa.restassured.core.RestConfig;
import com.qa.restassured.core.RestassuredCommon;

public class AccountAPI {

	private static final Logger logger = Logger.getLogger(AccountAPI.class);
	
	// Create Auth Token 
	public static Response createAuthToken() throws Exception {
		CommonUtils.printStartTest("Calling CreateAuthToken() for creating token");
		RequestSpecification reqspec = RestConfig.getRequestSpec();
	
		DocumentContext doc = JsonPath.parse(new File(GlobalVariables.createJson_Token));
	//	String bsJSON=doc.set("userName", bsName).jsonString();
		reqspec.body(doc.json());
		Response resp = RestAssured.given(reqspec).post(RestassuredCommon.baseUri_GenerateToken);
		logger.info("Print the Response");
		resp.getBody().prettyPrint();
		/*
		 * String respString= resp.getBody().asString();
		 * Assert.assertEquals(resp.getStatusCode(), 200);
		 * Assert.assertTrue(respString.contains("token"));
		 */
		
		return resp;
	}
	
	/*
	 * // Create Business Service by passing business name in default JSON public
	 * static Response createBusinessService(String name) throws Exception {
	 * CommonUtils.printStartTest("createBusinessService-by name");
	 * RequestSpecification reqspec = RestConfig.getRequestSpec();
	 * reqspec.queryParam(GlobalVariables.qParam1, GlobalVariables.qVal1);
	 * reqspec.queryParam("action", "create"); String bsName = name; DocumentContext
	 * doc = JsonPath.parse(new File(GlobalVariables.createJson_BS)); String
	 * bsJSON=doc.set("data[\"cmdb.item\"][0].name", bsName).jsonString();
	 * CommonUtils.writejsoninfile(bsJSON, GlobalVariables.createJson_BS_M); String
	 * str=JsonPath.parse(new File(GlobalVariables.createJson_BS_M)).jsonString();
	 * 
	 * reqspec.body(str); Response resp = RestAssured.given(reqspec).post();
	 * logger.info("Print the Response"); resp.getBody().prettyPrint(); String
	 * respString= resp.getBody().asString();
	 * Assert.assertTrue(respString.contains("created system "+bsName+""),
	 * "Response does not have the desired String");
	 * Assert.assertEquals(resp.getStatusCode(), 200); return resp; }
	 * 
	 */

}
