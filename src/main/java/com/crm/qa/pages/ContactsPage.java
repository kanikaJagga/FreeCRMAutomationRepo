package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
//initializing page factory
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("")).click();
		}
	
	//filling new contact form
	public void createNewContact(String title,String ftName,String ltName,String companyName) {
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		first_name.sendKeys(ftName);
		surname.sendKeys(ltName);
		company.sendKeys(companyName);
		saveBtn.click();
		
	}
}
