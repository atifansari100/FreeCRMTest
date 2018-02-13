package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.baseclass.BaseClass;
import com.crm.utilities.TestUtil;

public class HomePage extends BaseClass{

	
	@FindBy(xpath="//td[contains(text(), 'User: Atif Ansari')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Home') and @title = 'Home']")
	WebElement homeTab;
	
	@FindBy(xpath=("//a[contains(text(),'Calendar') and @title = 'Calendar']"))
	WebElement calendarTab;
	
	@FindBy(xpath="//a[contains(text(),'Companies') and @title = 'Companies']")
	WebElement companiesTab;
	
	@FindBy(xpath="//a[contains(text(),'Contacts') and @title = 'Contacts']")
	WebElement contactsTab;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals') and @title = 'Deals']")
	WebElement dealsTab;
	
	@FindBy(xpath="//a[contains(text(),'Tasks') and @title = 'Tasks']")
	WebElement tasksTab;
	
	@FindBy(xpath="//a[contains(text(),'Cases') and @title = 'Cases']")
	WebElement casesTab;
	
	@FindBy(xpath="//a[contains(text(),'Call') and @title = 'Call']")
	WebElement callTab;
	
	@FindBy(xpath="//a[contains(text(),'Email') and @title = 'Email']")
	WebElement emailTab;
	
	@FindBy(xpath="//a[contains(text(),'Text/SMS') and @title = 'Text/SMS']")
	WebElement textSmsTab;
	
	@FindBy(xpath="//a[contains(text(),'Print') and @title = 'Print']")
	WebElement printTab;
	
	@FindBy(xpath="//a[contains(text(),'Campaigns') and @title = 'Campaigns']")
	WebElement campaignsTab;
	
	@FindBy(xpath="//a[contains(text(),'Docs') and @title = 'Docs']")
	WebElement docsTab;
	
	@FindBy(xpath="//a[contains(text(),'Forms') and @title = 'Forms']")
	WebElement formsTab;
	
	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public ContactsPage clickContactsTab() {
		
		contactsTab.click();
		return new ContactsPage();
	}
	
//	public CreateEditContactPage clickNewContact() {
//		
//		newContactsLink.click();
//		return new CreateEditContactPage();
//	}
	
	public DealsPage clickDealsTab() {
		dealsTab.click();
		return new DealsPage();
	}
	
	public TasksPage clickTaskTab() {
		
		tasksTab.click();
		return new TasksPage();
	}
	

	public String verifyHomePageTitle() {
		
	return driver.getTitle();
	}
	
	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}


	public CreateEditContactPage clickNewContact() {
		TestUtil testUtil = new TestUtil();
		testUtil.hover(driver, contactsTab);
		newContactsLink.click();
		return new CreateEditContactPage();
	}
	
}
