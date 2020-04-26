package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class MyAccountPage extends TestBase{

	@FindBy(xpath="//a[@class='home']")
	WebElement homePageLink;

	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement userNameLabel;

	//Initializing the Page Objects:
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public HomePage clickOnHomeLink() {
		homePageLink.click();
		return new HomePage();
		
	}
	
	
	
}
