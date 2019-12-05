package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnscribeCoursePOM {
private WebDriver driver; 
	
	public UnscribeCoursePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	//Finding  the WebElements here
	@FindBy(linkText = "Course list")
	private WebElement courselist;
	
	@FindBy(linkText = "sel001")
	private WebElement selcourse;
	
	@FindBy(id="istooldesc_8605") 
	private WebElement users;
	
	@FindBy(xpath="//tr[2]//td[1]//input[1]")
	private WebElement chkbox;
	
	@FindBy(linkText = "Unsubscribe")
	private WebElement unscribe;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement cnfmsg;
	
	private String message;
	
	String actual;
	String pageTitle ="My Organization - My education";
// Validating the header of the Administation page by using assert 		
	public void validateAdminHeader() 
	{
		 
		System.out.println("Given Title is:"+pageTitle);
		actual = driver.getTitle();
		System.out.println("Actual title is:"+actual);
		assertEquals(pageTitle, actual);
		System.out.println("My Education Page Verified");
		
	}
	
	public void ELTC_009_UnscribeCourse() {
		courselist.click();
		selcourse.click();
		users.click();
		chkbox.click();
		unscribe.click();
		String Alert = driver.switchTo().alert().getText();
		System.out.println("Alert messag is: "+Alert);
		driver.switchTo().alert().accept();
		String comp = "User is now unsubscribed";
		message=cnfmsg.getText();
		assertEquals(comp, message);
		System.out.println("User is Sucessfully unsubscribed from course");
		
	}
}
