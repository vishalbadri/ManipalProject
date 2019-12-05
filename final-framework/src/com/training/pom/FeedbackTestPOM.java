package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackTestPOM 
{
private WebDriver driver; 
	
	public FeedbackTestPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	
	@FindBy(linkText="Tests")
	private WebElement Tests;
	
	@FindBy(xpath="//div[@class='table-responsive']//a[3]//img[1]")
	private WebElement results;
	
	@FindBy(xpath="//tr[@id='126']//span[@class='label label-info'][contains(text(),'Not validated')]")
	private WebElement Beforesatus;
	
	@FindBy(xpath="//div[@id='gbox_results']//a[1]//img[1]")
	private WebElement grade;
	
//	@FindBy(xpath="//*[@id='qf_9b594d']")
	//name="send_notification"
	private WebElement sendmail;
	
//	@FindBy(id="form-email_submit")
	//name="submit"
	private WebElement correcttest;
	
	@FindBy(xpath="//span[@class='label label-success']")
	private WebElement afterstatus;
	
	public  void validateHeader() 
	{
		String pgTitle ="My Organization - My education";
		String act = driver.getTitle();	
		assertEquals(pgTitle,act);
		System.out.println("Page verified");
	}
	public  void FeedbackTest() {
		Tests.click();
		results.click();
		System.out.println("Test not Graded");
		grade.click();
		//sendemail.click();
		sendmail = driver.findElement(By.name("send_notification"));
		sendmail.click();
		correcttest = driver.findElement(By.name("submit"));
		correcttest.click();
		assertEquals(afterstatus.getText(),"Validated");
		System.out.println("Test validated and graded");
		
	}
}
