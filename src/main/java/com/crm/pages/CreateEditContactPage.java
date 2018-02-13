package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.baseclass.BaseClass;

public class CreateEditContactPage extends BaseClass {

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "title")
	WebElement titleContact;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(name = "mobile")
	WebElement mobileNum;

	@FindBy(xpath = "//input[@name='receive_email' and @value = 'N']")
	WebElement noEmail;

	@FindBy(xpath = "//input[@name='receive_email' and @value = 'Y']")
	WebElement yesEmail;

	@FindBy(id = "image_file")
	WebElement uploadImage;

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;

	public CreateEditContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterContactDetails(String title, String fname, String lname, String compName, String mobile, String recieveEmail) {
		
		Select statusDropdown = new Select(titleContact);
		statusDropdown.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(compName);
		mobileNum.sendKeys(mobile);
		uploadImage.sendKeys("C:\\Users\\ansar\\Downloads\\small_mouse_macro_515329.jpg");
		
		// this is how you select an item from the drop down

		if (recieveEmail == "N") {
			noEmail.click();
		} else {
			yesEmail.click();
		}
		saveButton.click();

	}

}
