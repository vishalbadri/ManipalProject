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

import com.training.pom.ELTC_035_CheckAssignmentPOM;

public class ELTC_035_CheckAssignmentTest 
{
	private static WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private static Properties properties;
	private ScreenShot screenShot;
	private Elearning_LoginPOM elearning_LoginPOM;
	private ELTC_035_CheckAssignmentPOM checkassignemnt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException 
	{
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
		checkassignemnt = new ELTC_035_CheckAssignmentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public  void CheckAssignmentTest() {
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		checkassignemnt.validatechkasnHeader();
		checkassignemnt.checkAssignment();
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("ChkAssignment");
		driver.quit();
	}
}
