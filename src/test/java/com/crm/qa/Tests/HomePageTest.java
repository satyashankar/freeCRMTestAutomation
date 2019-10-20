package com.crm.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BasePage.BasePage;
import com.crm.qa.page.ContactPage;
import com.crm.qa.page.DealsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.page.TaskPage;
public class HomePageTest extends BasePage{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	DealsPage dealsPage;
	TaskPage taskPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.loginInTOApp(prop.getProperty("username"), prop.getProperty("password"));
}
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRM", "page title is not macthed");
		System.out.println(homePageTitle);
	}
	
	@Test(priority=2) 
	public void veriyingUserNameLabelTest() {
		boolean b = homePage.verifyUserNameLable();
		Assert.assertTrue(b);
		
	}
	@Test(priority=3)
	public void clickOnContactLinkTest() {
		contactPage = homePage.clickOnConctactLink();
	 
	}
	
	@Test(priority=4)
	public void clickOnDealPageTest() {
		dealsPage = homePage.clickOndealLink();
	
	}
	@Test(priority=5)
	public void clickONTaskLinkTest() {
		taskPage = homePage.clickOnTaskLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
