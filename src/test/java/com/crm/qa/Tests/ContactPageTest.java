package com.crm.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BasePage.BasePage;
import com.crm.qa.page.ContactPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;

public class ContactPageTest extends BasePage{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	public ContactPageTest() {
		super();		
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		contactPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.loginInTOApp(prop.getProperty("username"), prop.getProperty("password"));	
	    contactPage = homePage.clickOnConctactLink();
	    
	
	}
	
	@Test(priority=1)	
	public void verifyingContactLableTest() {
		boolean b = contactPage.verifyingContactLable();
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=2)
	public void selectContactTest() {
		contactPage.slectContact("philip ademi");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}
