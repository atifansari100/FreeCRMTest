package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.baseclass.BaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utilities.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}

	 @Test(priority=1)
	 public void verifyHomePageTitleTest() {
	 String title = homePage.verifyHomePageTitle();
	 Assert.assertEquals(title, "CRMPRO");
	 }

	@Test(priority = 2)
	public void navigatetoContacts() {
		
		contactsPage = homePage.clickContactsTab();

		 Assert.assertEquals(contactsPage.verifyContactsPage(), true);
	}

	@Test(priority = 3)
	public void verifyUserNameTest() {
		Assert.assertEquals(homePage.verifyUserNameLabel(), true);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
