package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	/*@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;*/
	
	
	@FindBy(xpath=("//div[contains(@class,'ui fluid large blue submit button')]"))
	WebElement loginBtn;
	
		
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	/*@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;*/
	
	
	/*@FindBy(xpath=("//div[contains(@class,'onesignal-bell-launcher-button')]"))
	WebElement crmLogo;*/
	
	@FindBy(xpath=("//*[@id=\"onesignal-bell-launcher\"]/div[1]"))
	WebElement crmLogo;
	
		
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		email.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}
