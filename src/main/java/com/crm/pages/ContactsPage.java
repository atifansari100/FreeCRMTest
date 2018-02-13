package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.baseclass.BaseClass;

public class ContactsPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsTitle;

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsPage() {
		return contactsTitle.isDisplayed();
	}

	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void deleteContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(@href,'James Anderson') and contains(@href, 'delete&contact')]")).click();
	}
	
	public boolean verifyContactDeleted(String name) {
		return driver.findElements(By.xpath("//td[@class='datalistrow']//a[text()='" + name + "']")).isEmpty();
		
	}
}
