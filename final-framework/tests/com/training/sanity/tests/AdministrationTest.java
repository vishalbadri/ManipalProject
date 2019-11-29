package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdministrationTest {
	private static WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private static Properties properties;
	private ScreenShot screenShot;
	private AdministrationPOM administation;
	private Elearning_LoginPOM elearning_LoginPOM;
	private AdminLoginTest adminLoginTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
//		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
//		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearning_LoginPOM = new Elearning_LoginPOM(driver); 
		administation = new AdministrationPOM(driver);
		adminLoginTest = new AdminLoginTest();
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test
	public void validLoginTest() {
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		administation.validateHeader();
		administation.AdministrationPOM();		
		
	}
		
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("Administration");
		driver.quit();
	}
	
}
	
