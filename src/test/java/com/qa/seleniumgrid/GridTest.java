package com.qa.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridTest {
	
	 static WebDriver driver;
	 static String nodeUrl;
	 
	 @BeforeTest
	 public void setup() throws MalformedURLException {
		 
	 nodeUrl = "http://192.168.1.108:4444/wd/hub";
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setBrowserName("chrome");
	 capabilities.setPlatform(Platform.ANY);
	 ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);
		options.setHeadless(true);

	 driver = new RemoteWebDriver(new URL(nodeUrl), options);
	 }
	 
	 @Test
	 public void simpleTest() {
	 driver.get("https://www.edureka.co");
//	 Assert.assertEquals("Instructor Led Online Courses with 24x7 On-Demand Support | Edureka", driver.getTitle());
	 }
	 
	 @AfterTest
	 public void afterTest() {
	 driver.quit();
	 }	
	

}
