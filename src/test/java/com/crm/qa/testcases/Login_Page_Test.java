package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Home_Page;
import com.crm.qa.pages.Login_Page;

public class Login_Page_Test extends TestBase {
	Login_Page loginpg;
	Home_Page homepg;

	public Login_Page_Test() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		loginpg=new Login_Page();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title=loginpg.validateLoginTitle();
	Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void loginPageForgotBtnTest() {
	boolean a=loginpg.validateForgotButton();
	Assert.assertEquals(a, true);
	}
	@Test(priority=3)
	public void loginTest() {
	homepg=loginpg.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	@AfterMethod
	public void tearDown() {
	Driver.quit();
	}
}
