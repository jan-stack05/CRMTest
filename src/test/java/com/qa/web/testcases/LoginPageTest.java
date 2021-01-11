package com.qa.web.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sampleproject.qa.base.TestBase;
import com.sampleproject.qa.pages.LoginPage;
import com.sampleproject.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	//LoginPage homePage;



	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		readExcel();
	
		
		loginPage = new LoginPage();
	

	}


	
	  @Test(groups = { "UI" },priority=1) 
	  public void loginPageTitleTest()
	  { 
		  String title =
	  loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
	  "CRMPRO - CRM software for customer relationship management, sales, and support."
	  );
	  }
	  
	  
	  
	  @Test(groups = { "UI" },priority=2)  public void crmLogoImageTest(){ boolean flag =
	  loginPage.validateCRMImage(); Assert.assertTrue(flag); }
	 

	
	  @Test(groups = { "UI" },priority=3, dataProvider="getTestData") public void
	  loginTest_unsuccess(){ boolean flag =
	  loginPage.unsuccessful_login(prop.getProperty("username"),
	  prop.getProperty("password")); Assert.assertTrue(flag); }
	 

	@Test(groups = { "UI" },priority=4,dataProvider="readExcel",dataProviderClass = TestBase.class) 

	public void loginTest_unsuccess(String firstname,String password)
	{

		System.out.println("Name :" +firstname);
		System.out.println("Password:" +password);
		boolean flag =loginPage.unsuccessful_login(firstname,password); 
		AssertJUnit.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}





}
