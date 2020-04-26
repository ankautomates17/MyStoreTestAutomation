package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	
	public MyAccountPageTest() {
		super();               
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickOnSignInLink();
		myAccountPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(groups="MyAccountPage")
	public void validateUserNameTest() {
		Assert.assertTrue(myAccountPage.validateUserName());
	}
	
	@Test(groups="MyAccountPage")
	public void validateHomeLinkTest() {
		myAccountPage.clickOnHomeLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
