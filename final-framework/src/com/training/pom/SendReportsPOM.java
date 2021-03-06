package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendReportsPOM {
private WebDriver driver; 
	
	public SendReportsPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	@FindBy(xpath="//img[@id='toolimage_8445']")
	private WebElement Reporting;
	
	@FindBy(xpath ="//tr[@class='row_even']//td//center//a//img")
	private WebElement StuDetails;
	
	@FindBy(xpath="//td[5]//a[1]//img[1]")
	private WebElement Test;
	
	@FindBy(xpath="//span[@class='label label-success']")
	private WebElement validated;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement alert;
	
	@FindBy(linkText = "Seleniumbasic")
	private WebElement coursename;
		
	private WebElement sendmail;
	private WebElement correcttest;
	
	
	public  void validateHeader() 
	{
		
		String pgTitle ="My Organization - My education";
		String act = driver.getTitle();	
		assertEquals(pgTitle,act);
		System.out.println("Page verified");
	}
	
	public  void SendReports() {
		Reporting.click();
		StuDetails.click();
		Test.click();
		sendmail = driver.findElement(By.name("send_notification"));
		sendmail.click();
		correcttest = driver.findElement(By.name("submit"));
		correcttest.click();
		assertEquals(validated.getText(),"Validated");
		assertEquals(alert.getText(),"Message Sent");
		System.out.println("ReportEmail Sent");
		coursename.click();
		
	}

}
