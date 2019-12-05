package com.training.complex.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckAssignmentPOM;
import com.training.pom.AddOnlinequizPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_065_AddOnlinequizTest {
	private static WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private String Title;
	private String Quest;
	private String Firsto;
	private String Secondo;
	private String Thirdo;
	private String Fourtho;
	private static Properties properties;
	private ScreenShot screenShot;
	private Elearning_LoginPOM elearning_LoginPOM;
	private CheckAssignmentPOM checkassignemnt;
	private AddOnlinequizPOM addonlinequiz;
	
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
		checkassignemnt = new CheckAssignmentPOM(driver);
		addonlinequiz = new AddOnlinequizPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		Title = properties.getProperty("Ttitile");
		Quest = properties.getProperty("question1");
		Firsto = properties.getProperty("FirstOption1");
		Secondo = properties.getProperty("SecondOption1");
		Thirdo = properties.getProperty("Thirdoption1");
		Fourtho = properties.getProperty("Fourthoption1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public  void AddOnlinequizTest() {
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		addonlinequiz.validateHeader();
		checkassignemnt.Selcourse();
		addonlinequiz.AddOnlinequizexcer(Title);
		addonlinequiz.AddOnlineitem(Quest, Firsto, Secondo, Thirdo, Fourtho);			
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("Addonlinequiz");
		driver.quit();
	}

}