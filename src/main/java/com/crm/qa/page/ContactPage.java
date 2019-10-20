package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BasePage.BasePage;

public class ContactPage extends BasePage {
	
	//pageFactory obj rep
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactLable;
	
	//Initialising PageFactory
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyingContactLable() {
		return contactLable.isDisplayed();
	}
	
	public void slectContact(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'+name+')]")).click();
	}

}
