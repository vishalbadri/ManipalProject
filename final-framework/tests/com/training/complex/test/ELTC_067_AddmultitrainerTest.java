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
import com.training.pom.AddOnlinequizPOM;
import com.training.pom.TeacherStuQuizPOM;
import com.training.pom.CheckAddedUserPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_067_AddmultitrainerTest 
{
	private static WebDriver driver;
	private String baseUrl;
	private String Adminusr;
	private String Adminpass;
	private String Adusrfirstnme;
	private String Adusrlastnme;
	private String Adusremail;
	private String Adusrphone;
	private String Adusrlognme;
	private String Adusrlogpwd;
	private String Adusrprofile;
	private String Adusrfirstnme1;
	private String Adusrlastnme1;
	private String Adusremail1;
	private String Adusrphone1;
	private String Adusrlognme1;
	private String Adusrlogpwd1;
	private static Properties properties;
	private ScreenShot screenShot;
	private Elearning_LoginPOM elearning_LoginPOM;
	private AddOnlinequizPOM addonlinequiz;
	private TeacherStuQuizPOM teachstuquiz;
	private CheckAddedUserPOM checkadduser;
	
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
		addonlinequiz = new AddOnlinequizPOM(driver);
		teachstuquiz = new TeacherStuQuizPOM(driver);
		checkadduser = new CheckAddedUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		Adminusr = properties.getProperty("Adminuser");
		Adminpass = properties.getProperty("Adminpwd");
		Adusrfirstnme = properties.getProperty("Adusrfname");
		Adusrlastnme= properties.getProperty("Adusrlname");
		Adusremail= properties.getProperty("Adusrmail");
		Adusrphone= properties.getProperty("Adusrph");
		Adusrlognme= properties.getProperty("Adusrlgn");
		Adusrlogpwd= properties.getProperty("Adusrpwd");
		Adusrprofile=properties.getProperty("Aduprof");
		Adusrfirstnme1 = properties.getProperty("Adusrfname1");
		Adusrlastnme1= properties.getProperty("Adusrlname1");
		Adusremail1= properties.getProperty("Adusrmail1");
		Adusrphone1= properties.getProperty("Adusrph1");
		Adusrlognme1= properties.getProperty("Adusrlgn1");
		Adusrlogpwd1= properties.getProperty("Adusrpwd1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public void AddmultitrainerTest()
	{
		elearning_LoginPOM.Elearning_LoginPOM(Adminusr, Adminpass);
		addonlinequiz.validateHeader();
		checkadduser.CheckAddedUser(Adusrfirstnme, Adusrlastnme, Adusremail, Adusrphone, Adusrlognme, Adusrlogpwd, Adusrprofile);
		checkadduser.searchuser(Adusrfirstnme);
		checkadduser.CheckAddedUser(Adusrfirstnme1, Adusrlastnme1, Adusremail1, Adusrphone1, Adusrlognme1, Adusrlogpwd1, Adusrprofile);
		checkadduser.searchuser(Adusrfirstnme1);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC_068_AddnewUserTrainer");
		teachstuquiz.StuTeachlogout();
		driver.quit();
	}
}
