package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAssignmentPOM 
{
private WebDriver driver; 
	
	public CheckAssignmentPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	//
	@FindBy(linkText = "Course list")
	private WebElement courselist;
	
	@FindBy(linkText = "Seleniumbasic")
	private WebElement selcourse;
	
	@FindBy(id="istooldesc_6430")
	private WebElement Assignments;
	
	@FindBy(id="jqg_workList_97")
	private WebElement chkbox;
	
	@FindBy(linkText = "Selenium Assignment1")
	private WebElement clkAssign;
	
	@FindBy(xpath="//h3[contains(text(),'Selenium Assignment1')]")
	private WebElement panelheader;
	
	@FindBy(xpath="//tr[@id='105']//a[2]//img[1]")
	private WebElement correctnrate;
	
	//private WebElement fr;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement comment;
	
	
	private WebElement sendbtn;
	
	@FindBy(xpath="//div[contains(text(),'You comment has been added')]")
	private WebElement alert1;
	
	@FindBy(xpath="//div[contains(text(),'Update successful')]")
	private WebElement alert2;
	
	@FindBy(linkText = "Selenium Assignment1")
	private WebElement Assignlnk;
	
	@FindBy(xpath="//tr[@id='105']//a[contains(text(),'1')]")
	private WebElement feedback;
	
	// Validating the header of the by using assert 	
	String act;
	String pgTitle ="My Organization - My education";
	
	public  void validatechkasnHeader() 
	{
		 
		System.out.println("Given Title is:"+pgTitle);
		act = driver.getTitle();
		System.out.println("Actual title is:"+act);
		assertEquals(pgTitle, act);
		System.out.println("Page verified");
	}
	public void Selcourse() {
		courselist.click();
		selcourse.click();
	}
	public  void checkAssignment() {
		
		Assignments.click();
		chkbox.click();
		clkAssign.click();
		assertEquals(panelheader.getText(),"Selenium Assignment1");
		System.out.println("Correct Assignment Page");
		correctnrate.click();
		List <WebElement> fr =    driver.findElements(By.tagName("iframe"));
		System.out.println("Frames are:"+fr.size());
		driver.switchTo().frame(0);
		comment.sendKeys("40");
		driver.switchTo().defaultContent();
		sendbtn = driver.findElement(By.name("button"));
		sendbtn.click();
		assertEquals(alert1.getText(),"You comment has been added");  
		assertEquals(alert2.getText(),"Update successful");
		System.out.println("Updates sucessful");
		Assignlnk.click();
		feedback.isDisplayed();
		System.out.println(feedback.getText());
		
	}
}

