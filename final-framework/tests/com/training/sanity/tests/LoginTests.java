package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private Elearning_LoginPOM Elearning_LoginPOM;
	private static Properties properties;
	private String username;
	private String password;
	private ScreenShot screenShot;

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
		Elearning_LoginPOM = new Elearning_LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}
	public void validLoginTest() {
//		Elearning_LoginPOM.sendUserName(username);
//		Elearning_LoginPOM.sendPassword(password);
//		Elearning_LoginPOM.clickLoginBtn(); 
		String title = driver.getTitle();
		System.out.println(title);
		screenShot.captureScreenShot("First");
	}
}
