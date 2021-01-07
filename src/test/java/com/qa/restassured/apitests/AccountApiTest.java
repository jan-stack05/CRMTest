package com.qa.restassured.apitests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.qa.restassured.apis.library.AccountAPI;
import com.qa.restassured.core.CommonUtils;
import com.qa.restassured.core.RestConfig;
import com.qa.restassured.core.RestassuredCommon;


public class AccountApiTest extends RestassuredCommon {

	private static final Logger logger = Logger.getLogger(AccountApiTest.class);

	
	@Test(groups = { "apitest" })
	public static void createAuthToken() throws Exception {
		CommonUtils.printStartTest("Verify that user token is created successfully");
		Response resp = AccountAPI.createAuthToken();
		String respString= resp.getBody().asString();
		Assert.assertTrue(respString.contains("token"),"Token is not created for the user.");
		Assert.assertTrue(respString.contains("status"),"Response doesn't have status Success");
		Assert.assertEquals(resp.getStatusCode(), 200);
		CommonUtils.printEndTest("Token Creation");
	}
	

	
	  @Test(groups={"apitest"})
	  public static void verify_GetBooks() throws Exception {
		  CommonUtils.printStartTest("Verify that book details fecthed successfully"); 
			RequestSpecification reqspec = RestConfig.getRequestSpec();
			Response resp1 = RestAssured.given(reqspec).get(RestassuredCommon.baseUri_GetBooks);
			logger.info("Print the Response of GET APIs");
			String respString = resp1.getBody().prettyPrint();
			Assert.assertEquals(resp1.getStatusCode(), 200);
			Assert.assertTrue(respString.contains("author"),"Author is not available is GetBooks API");
			
			CommonUtils.printEndTest("verify_GetBooks()");
			}
	  }
	 

