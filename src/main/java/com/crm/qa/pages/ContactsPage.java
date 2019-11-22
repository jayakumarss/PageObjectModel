package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	/*@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;*/
	
	@FindBy(xpath=("//div[contains(@class,'ui header item mb5 light-black')]"))
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	
	@FindBy(xpath=("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input"))
	WebElement company;
	
	@FindBy(xpath=("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[2]/div"))
	WebElement addcompany;
	
	/*@FindBy(xpath=("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[2]/div[2]"))
	WebElement selectcompany;*/
	
	@FindBy(xpath=("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[2]/div"))
	WebElement selectcompany;
	
	/*@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;*/
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	/*public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}*/
	
	
	public void createNewContact(String ftName, String ltName, String comp){
		//Select select = new Select(driver.findElement(By.name("title")));
		//select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		
		TestUtil.captureSnapshotForAllure(driver);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (company.equals(selectcompany)) {
			selectcompany.click();
			saveBtn.click();
		}
		else {
			addcompany.click();
			saveBtn.click();
	
			}
	}
	
}
