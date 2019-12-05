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
import com.training.pom.ELTC_065_AddOnlinequizPOM;
import com.training.pom.ELTC_066_TeacherStuQuizPOM;
import com.training.pom.ELTC_068_CheckAddedUserPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_068_CheckAddedUserTest 
{
	private static WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private String Adusrfirstnme;
	private String Adusrlastnme;
	private String Adusremail;
	private String Adusrphone;
	private String Adusrlognme;
	private String Adusrlogpwd;
	private String Adusrprofile;
	private static Properties properties;
	private ScreenShot screenShot;
	private Elearning_LoginPOM elearning_LoginPOM;
	private ELTC_065_AddOnlinequizPOM addonlinequiz;
	private ELTC_066_TeacherStuQuizPOM teachstuquiz;
	private ELTC_068_CheckAddedUserPOM checkadduser;
	
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
		addonlinequiz = new ELTC_065_AddOnlinequizPOM(driver);
		teachstuquiz = new ELTC_066_TeacherStuQuizPOM(driver);
		checkadduser = new ELTC_068_CheckAddedUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		Adusrfirstnme = properties.getProperty("Adusrfname");
		Adusrlastnme= properties.getProperty("Adusrlname");
		Adusremail= properties.getProperty("Adusrmail");
		Adusrphone= properties.getProperty("Adusrph");
		Adusrlognme= properties.getProperty("Adusrlgn");
		Adusrlogpwd= properties.getProperty("Adusrpwd");
		Adusrprofile=properties.getProperty("Aduprof");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public void CheckAddedUserTest()
	{
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		addonlinequiz.validateHeader();
		checkadduser.CheckAddedUser(Adusrfirstnme, Adusrlastnme, Adusremail, Adusrphone, Adusrlognme, Adusrlogpwd, Adusrprofile);
		checkadduser.searchuser(Adusrfirstnme);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_068_AddnewUserTrainer");
		teachstuquiz.StuTeachlogout();
		driver.quit();
	}

}
