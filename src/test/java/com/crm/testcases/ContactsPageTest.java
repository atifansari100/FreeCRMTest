package com.crm.testcases;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.baseclass.BaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.CreateEditContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utilities.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateEditContactPage createEditContactPage;
	TestUtil testUtil;
	String sheetName;
	
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod

	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//contactsPage = homePage.clickContactsTab();
		testUtil.switchToFrame();
	}
	
	@Test(priority=1)
	public void createAndDeleteContact() {
		
		createEditContactPage = homePage.clickNewContact();
		
		createEditContactPage.enterContactDetails( "Mr.", "Jimmy", "Anderson", "google", "8648127956" , "N");
		contactsPage = homePage.clickContactsTab();
				
		contactsPage.selectContactsByName("Jimmy Anderson");
		contactsPage.deleteContactsByName("Jimmy Anderson");
		driver.switchTo().alert().accept();

		Assert.assertEquals(true, contactsPage.verifyContactDeleted("Jimmy Anderson"));
		
	}
	
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData("contacts");
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void createContacts(String title, String firstName, String lastName, String company, String mobile, String recieveEmail) {
		createEditContactPage = homePage.clickNewContact();
		
		//createEditContactPage.enterContactDetails("James", "Anderson", "Mr.", "consultancy", "8648127956" , "N");
		createEditContactPage.enterContactDetails(title, firstName, lastName, company, mobile, recieveEmail);
		
	}
	
	@AfterMethod

	public void teardown() {

		driver.quit();
	}

}
