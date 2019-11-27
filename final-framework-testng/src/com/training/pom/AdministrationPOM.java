package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Assert;

public class AdministrationPOM 
{
	
	private WebDriver driver; 
	public AdministrationPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//panel1[contains(text(), 'Courses')]")
	private WebElement panelheading;
			
	String actual;
	String pageTitle ="My Organization - My education";
// Validating the header of the Administation page by using assert 		
	public void validateHeader() 
	{
		 
		System.out.println("Given Title is:"+pageTitle);
		actual = driver.getTitle();
		System.out.println("Actual title is:"+actual);
		assertEquals(pageTitle, actual);
		System.out.println("My Education Page Verified");
		
	}
	//Clicking on the create a course link
	
	public void AdministrationPOM() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Create a course")).click();
		System.out.println("Clicked on the link Create a course");
	}
	
}