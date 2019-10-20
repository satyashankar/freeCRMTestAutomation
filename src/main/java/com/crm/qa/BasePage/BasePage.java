package com.crm.qa.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Util.TestUtil;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BasePage() {
		try {
         prop = new Properties();		
		FileInputStream ip = new FileInputStream("C:\\Users\\SandeepGoud\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\properties\\config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();		
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	 public static void initialization() {
		 String browserName = prop.getProperty("browser");
		 if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SandeepGoud\\Downloads\\chromedriver.exe");
		     driver = new ChromeDriver();
		 }else if(browserName.equals("FF")) {
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\SandeepGoud\\Downloads\\geckodriver.exe");
			 driver = new FirefoxDriver();
		 }
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();;
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Wait, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		 
		 
	 }

	
	
}
