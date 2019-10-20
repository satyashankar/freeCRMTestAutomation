package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BasePage.BasePage;

public class HomePage extends BasePage{
	
	//pageFactory obj repository
	
	@FindBy(xpath=" //span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	//initializing pageFactory
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserNameLable() {
	return userNameLabel.isDisplayed();
	}
	
	public ContactPage clickOnConctactLink() {
		contactLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOndealLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}	

}
