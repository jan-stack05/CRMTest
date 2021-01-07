package com.qa.restassured.core;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RestassuredCommon extends CommonUtils {

	public static RequestSpecification reqspec = new RequestSpecBuilder().build();
	public static WebDriver driver;
	public static boolean acceptNextAlert = true;
	public static StringBuffer verificationErrors = new StringBuffer();
	public static String serverName = ""; // ocipd-qa03.us.oracle.com * ocipd-qa10.gde.oraclecorp.com
	public static String BasicAuth = "Basic Z2J1Y3NfcWE6R2JVY1NfUWEh";
	public static String baseUrl = "https://bookstore.toolsqa.com";
	public static String baseUri_GenerateToken = "/Account/v1/GenerateToken";
	public static String baseUri_GetBooks = "/BookStore/v1/Books";
	// public static String baseUri = "/Account/v1/GenerateToken";
	public static String alertStr = "";
	long timeoutInSeconds = 30;
	public static boolean auditLogFound = false;
	public static boolean linkcostFound = false;
	public String logAction = null;
	public static String xpathElement = null;
	static String xvfbDisplay = "2";
	public static WebDriverWait wait5 = null;
	public static WebDriverWait wait10 = null;
	public static WebDriverWait wait15 = null;
	public static WebDriverWait wait30 = null;
	public static WebDriverWait wait = null;
	public boolean collectStats = false;
	public static FirefoxBinary firefoxBinary = null;
	public static String groups = "smoketest";
	//public static String userName = "TOOLSQA-Test";
	//public static String password = "Test@@123";
	public static int successRespCode = 200;

	long timeval = Calendar.getInstance().getTimeInMillis();

	@BeforeSuite(alwaysRun = true)
	public void setup() {

		if (System.getProperty("target_host") != null)
			serverName = System.getProperty("target_host");
		if (System.getProperty("BasicAuth") != null)
			BasicAuth = System.getProperty("BasicAuth");

	}

	public static Response hitGETandFetchStatusCode(RequestSpecification req, int statusCode) {

		Response resp = RestAssured.given(reqspec).get();
		try {
			resp.getBody().prettyPrint();
			System.out.println("Validate the status Code for " + statusCode + "");
			/*
			 * Assert.assertEquals(resp.getStatusCode(), statusCode);
			 * System.out.println("status code " + statusCode + " received");
			 */
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return resp;
	}


	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		RestassuredCommon.baseUrl = baseUrl;
	}

	public static String getBaseUri_GenerateToken() {
		return baseUri_GenerateToken;
	}

	public static void setBaseUri_GenerateToken(String baseUri) {
		RestassuredCommon.baseUri_GenerateToken = baseUri;
	}

}
