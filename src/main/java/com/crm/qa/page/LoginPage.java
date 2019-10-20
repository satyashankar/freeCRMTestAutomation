package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BasePage.BasePage;

public class LoginPage extends BasePage {
	
	//PageFactory Obj Repository
	
	@FindBy(className= "img-responsive")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginLink;
	
	
	@FindBy(xpath="//input[@placeholder='E-mail address']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	
	//initialising the PageFactory
	
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateLPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage loginInTOApp(String uname, String pswd) throws InterruptedException {
		Thread.sleep(2000);
		loginLink.click();	
		Thread.sleep(4000);
		
		username.sendKeys(uname);
		password.sendKeys(pswd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
