package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@CacheLookup   //used for storing webelements -- element can be used from the cache memory -- not required to launch browser again
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInLink;
	
	@FindBy(name="search_query")
	WebElement searchYourItem;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickOnSignInLink() {
		signInLink.click();
		return new LoginPage();
	}

}
