package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//span[contains(@class,'user-display')]
	//div[@class='right-menu']//span[contains(text(), 'Nadim Rizk')] 
	
	/*@FindBy(xpath = "//td[contains(text(),'User: Nadim Rizk')]")
	@CacheLookup
	WebElement userNameLabel;*/
	
	@FindBy(xpath = "//div[@class='ui navbar fixed main menu']//span[contains(text(), 'Nadim Rizk')]")
	@CacheLookup
	WebElement userNameLabel;

	/*@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;*/
	
	/*@FindBy(xpath = "//div[@class='ui left fixed vertical left-to-right icon menu sidebar-dark']//span[contains(text(), 'Contacts')]")
	@CacheLookup
	WebElement contactsLink;*/
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/span")
	@CacheLookup
	WebElement contactsLink;
	
	/*@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;*/
	
	/*@FindBy(xpath = "//div[@class='ui secondary pointing menu header-title page-header']//button[contains(text(),'New')]")
	WebElement newContactLink;*/

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContactLink;

	/*@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;*/
	
	/*@FindBy(xpath = "//div[@class='ui left fixed vertical left-to-right icon menu sidebar-dark']//span[contains(text(), 'Deals')]")
	@CacheLookup
	WebElement dealsLink;*/
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[5]/span")
	@CacheLookup
	WebElement dealsLink;

	/*@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;*/
	
	/*@FindBy(xpath = "//div[@class='ui left fixed vertical left-to-right icon menu sidebar-dark']//span[contains(text(), 'Tasks')]")
	@CacheLookup
	WebElement tasksLink;*/
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[6]/span")
	@CacheLookup
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
	
	
	
	

}
