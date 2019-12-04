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
import com.training.pom.ELTC_035_CheckAssignmentPOM;
import com.training.pom.ELTC_036_FeedbackTestPOM;
import com.training.pom.ELTC_065_AddOnlinequizPOM;
import com.training.pom.ELTC_066_TeacherStuQuizPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_066_TeacherStuQuizTest {
	private static WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private String Sturname;
	private String Stupass;
	private String Title;
	private String Quest;
	private String Firsto;
	private String Secondo;
	private String Thirdo;
	private String Fourtho;
	private String Quest2;
	private String Firsto2;
	private String Secondo2;
	private String Thirdo2;
	private String Fourtho2;
	private static Properties properties;
	private ScreenShot screenShot;
	private Elearning_LoginPOM elearning_LoginPOM;
	private ELTC_035_CheckAssignmentPOM checkassignemnt;
	private ELTC_036_FeedbackTestPOM feedbacktest;
	private ELTC_065_AddOnlinequizPOM addonlinequiz;
	private ELTC_066_TeacherStuQuizPOM teachstuquiz;
	
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
		feedbacktest = new ELTC_036_FeedbackTestPOM(driver);
		addonlinequiz = new ELTC_065_AddOnlinequizPOM(driver);
		teachstuquiz = new ELTC_066_TeacherStuQuizPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		Sturname = properties.getProperty("StUser");
		Stupass = properties.getProperty("StuPass");
		Title = properties.getProperty("Ttitile");
		Quest = properties.getProperty("question1");
		Firsto = properties.getProperty("FirstOption1");
		Secondo = properties.getProperty("SecondOption1");
		Thirdo = properties.getProperty("Thirdoption1");
		Fourtho = properties.getProperty("Fourthoption1");
		Quest2 = properties.getProperty("question2");
		Firsto2 = properties.getProperty("FirstOption2");
		Secondo2= properties.getProperty("SecondOption2");
		Thirdo2= properties.getProperty("Thirdoption2");
		Fourtho2= properties.getProperty("Fourthoption2");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test
	public void TeacherStuQuiz() {
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		addonlinequiz.validateHeader();
		checkassignemnt.Selcourse();
		addonlinequiz.AddOnlinequizexcer(Title);
		addonlinequiz.AddOnlineitem(Quest, Firsto, Secondo, Thirdo, Fourtho);
		addonlinequiz.AddOnlineitem(Quest2, Firsto2, Secondo2, Thirdo2, Fourtho2);
		addonlinequiz.previewclose();
		teachstuquiz.StuTeachlogout();
		elearning_LoginPOM.Elearning_LoginPOM(Sturname, Stupass);
		teachstuquiz.validateStuHeader();
		teachstuquiz.StudentQuiz();
		teachstuquiz.StuTeachlogout();
		elearning_LoginPOM.Elearning_LoginPOM(username, password);
		feedbacktest.FeedbackTest();
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		screenShot.captureScreenShot("TeachStuonlinequiz");
		driver.quit();
	}

}
