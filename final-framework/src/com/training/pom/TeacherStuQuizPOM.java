package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherStuQuizPOM {
	private WebDriver driver;
	
	public TeacherStuQuizPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	//Student landing page selecting course
	@FindBy(linkText="Seleniumbasic")
	private WebElement stuselcourse;

	//Student clicks on Test
	@FindBy(xpath="//a[@id='istooldesc_8429']")
	private WebElement Test;
	
	//Student clicks on Test name
	@FindBy(xpath="//a[contains(text(),'online quiz')]")
	private WebElement testname;
	
	//Student Clicks on Start test
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement starttest;
	
	//Student Answer first question
	@FindBy(xpath="//label[contains(@class,'radio')]//p[contains(text(),'Selenium')]")
	private WebElement firstans;
	
	//Student clicks next question
	@FindBy(xpath="//button[@name='save_now']")
	private WebElement Nextbtn;
	
	//Studenr answers Next Que
	@FindBy(xpath="//p[contains(text(),'java')]")
	private WebElement secans;
	
	//Student clicks EndTest
	@FindBy(xpath="//button[@name='save_now']")
	private WebElement endtest;
	
	//Results get saved - title  "Saved"
	@FindBy(xpath="//div[contains(text(),'Saved.')]")
	private WebElement Sucessmsg;
	
	//Logout menu
	@FindBy(xpath="//*[@id=\"navbar\"]/ul[2]/li[2]/a/img")
	private WebElement dropdown;
	
	//Click Logout
	@FindBy(id="logout_button")
	private WebElement logout;
	
	public  void validateStuHeader() 
	{
		
		String pgTitle ="My Organization - My education - My courses";
		String act = driver.getTitle();	
		assertEquals(pgTitle,act);
		System.out.println("Student Page verified");
	}
	
	public void StudentQuiz() {
		stuselcourse.click();
		Test.click();
		testname.click();
		starttest.click();
		firstans.click();
		Nextbtn.click();
		secans.click();
		endtest.click();
		assertEquals(Sucessmsg.getText(),"Saved.");
		System.out.println("Student Test completed");
	}
	public void StuTeachlogout() {
		dropdown.click();
		logout.click();
		
	}
}
