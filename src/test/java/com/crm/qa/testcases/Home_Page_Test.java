package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Calls_Page;
import com.crm.qa.pages.Contacts_Page;
import com.crm.qa.pages.Home_Page;
import com.crm.qa.pages.Login_Page;

public class Home_Page_Test extends TestBase {
	Login_Page loginpg;
	Home_Page homepg;
	Calls_Page callspg;
	Contacts_Page contactpg;

	public Home_Page_Test() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginpg = new Login_Page();
		callspg=new Calls_Page();
		contactpg=new Contacts_Page();
		homepg = loginpg.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}

	@Test(priority=1)
	public void verifyhomepageTileTest() {
		String title = homepg.verifyHomeTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority=2)
	public void verifyUserNameDisplayedTest() {
		Assert.assertEquals(true, homepg.verifyUserNameDisplayed(), "The username is not displayed");
	}

//	@Test(priority=2)
//	public void clickOnContactsLinkTest() {
//		contactpg = homepg.clickOnContactsLink();
//	}
//
//	@Test(priority=1)
//	public void clickOnCallssLink() {
//		callspg = homepg.clickOnCallssLink();
//	}
	
	@AfterMethod
	public void teardown() {
		Driver.quit();
	}
	
}
