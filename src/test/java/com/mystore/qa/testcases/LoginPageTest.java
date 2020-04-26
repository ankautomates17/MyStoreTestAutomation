package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	
	public LoginPageTest() {
		super();               
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickOnSignInLink();
				
	}
	
	@Test(priority=1,groups="LoginPage")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}
	
//	@Test(priority=2,enabled=true,expectedExceptions=NoSuchElementException.class)
	@Test(priority=2,groups="LoginPage",enabled=false)
	public void myStoreLogoTest() {
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3,groups="LoginPage")
	public void loginTest() {
		myAccountPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
