package com.crm.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BasePage.BasePage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;

public class LoginPageTest extends BasePage{
	
	LoginPage loginPage; 
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software for any business - FreeCRM.com");
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void CRMLogoTest() {
		boolean b = loginPage.validateCRMLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void loginInTOAppTest() throws InterruptedException {
		homePage = loginPage.loginInTOApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
