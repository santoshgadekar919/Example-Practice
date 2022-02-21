package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Login_Page extends TestBase {
	// Page Factory-Object Repository
	@FindBy(name = "email")
	@CacheLookup
	WebElement email;
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	@FindBy(xpath = "//*[contains(text(),\"Login\")]")
	@CacheLookup
	WebElement loginBtn;
	@FindBy(xpath = "//*[contains(text(),\"Sign Up\")]")
	WebElement signUpBtn;
	@FindBy(xpath = "//*[contains(text(),\"Forgot your password?\")]")
	WebElement ForgotPassBtn;
	
	//Initializing the Page objects:
	public Login_Page() {
		PageFactory.initElements(Driver, this);
	}

	public String validateLoginTitle() {
		return Driver.getTitle();
	}
	public boolean validateForgotButton() {
		return ForgotPassBtn.isDisplayed();
	}
	public Home_Page validateLogin(String Un, String pwd) {
		email.sendKeys(Un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new Home_Page();
	}
}
