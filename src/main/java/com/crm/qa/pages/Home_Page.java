package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Home_Page extends TestBase {
//	Page Factory-Object repository 
	@FindBy(xpath = "//*[contains(text(), \"santosh gadekar\")]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//*[contains(text(),\"Calendar\")]")
	@CacheLookup
	WebElement CalendarLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Calls\")]")
	@CacheLookup
	WebElement CallsLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Campaigns\")]")
	@CacheLookup
	WebElement CampaignsLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Cases\")]")
	@CacheLookup
	WebElement CasesPgLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Companies\")]")
	@CacheLookup
	WebElement CompaniesLink;
	
	
	@FindBy(xpath = "//*[contains(text(),\"Contacts\")]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Deals\")]")
	@CacheLookup
	WebElement DealsLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Documents\")]")
	@CacheLookup
	WebElement DocumentsLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Email\")]")
	@CacheLookup
	WebElement EmailPgLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Forms\")]")
	@CacheLookup
	WebElement FormsPgLink;
	
	@FindBy(xpath = "//*[contains(text(),\"Home\")]")
	@CacheLookup
	WebElement HomePgLink;
	
	
	@FindBy(xpath = "//*[contains(text(),\"Tasks\")]")
	@CacheLookup
	WebElement TaskLink;
	
	
	
//Initializing the Page objects:
	public Home_Page() {
		PageFactory.initElements(Driver, this);
	}
	
//	Actions
	public String verifyHomeTitle() {
		return Driver.getTitle();
	}
	public boolean verifyUserNameDisplayed() {
		return userNameLabel.isDisplayed();
	}
	public String verifyUserNameText() {
		return userNameLabel.getText();
	}
	public Contacts_Page clickOnContactsLink() {
		contactsLink.click();
		return new Contacts_Page();
	}
	public Calls_Page clickOnCallssLink() {
		CallsLink.click();
		return new Calls_Page();
	}
	public Home_Page clickOnHomeLink() {
		HomePgLink.click();
		return new Home_Page();
	}
}
