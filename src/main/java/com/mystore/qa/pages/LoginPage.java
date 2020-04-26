package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email") //Registered user login with email
	WebElement email;
	
	@FindBy(name="passwd") //password
	WebElement password;
	
	@FindBy(xpath="//button[@name='SubmitLogin']") //submit login button
	WebElement signInBtn; 
	
	@FindBy(name="email_create") //create account by entering email
	WebElement createEmail;
	
	@FindBy(name="SubmitCreate") //create account button
	WebElement createAccountBtn;
	
	@FindBy(xpath="//img[contains(text(),'logo img-responsive')]")
	WebElement logo;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public MyAccountPage login(String eml, String pwd) {
		email.sendKeys(eml);
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new MyAccountPage();   //once we login--we move to account page--so return object of that page class
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
