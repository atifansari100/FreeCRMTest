package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	// Page factory or object repository

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")

	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;

	// initialize all elements
	public LoginPage() {
		//// initialize elements using constructor all above variables will be
		//// initialized
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Validate CRM Image

	public boolean valideCRMImage() {

		return crmLogo.isDisplayed();
	}

	public HomePage login(String uname, String pwd) {

		username.sendKeys(uname);
		password.sendKeys(pwd);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();

		// after login, it is going to home page hence we saying return homepage class
		return new HomePage();
	}
}
