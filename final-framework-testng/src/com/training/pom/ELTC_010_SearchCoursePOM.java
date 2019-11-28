package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_010_SearchCoursePOM 
{
private WebDriver driver; 
	
	public ELTC_010_SearchCoursePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	//Finding  the WebElements here
	@FindBy(linkText = "Homepage")
	private WebElement homepage;
	
	@FindBy(linkText = "Course catalog")
	private WebElement coursectlg;
	
	@FindBy(xpath = "//h2[@class='title-courses']")
	private WebElement pgtitle;
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement inputtxt;
	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement srchbttn;
	
	@FindBy(xpath="//strong[contains(text(),'Search results for: Selenium')]")
	private WebElement searcheditm;
	
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
	public void SearchCourse()
	{
		homepage.click();
		coursectlg.click();
		String panel = pgtitle.getText();
		System.out.println(" Panel Title is: "+panel);
		inputtxt.sendKeys("Selenium");
		srchbttn.click();
		String res = searcheditm.getText();
		System.out.println("Searching item is :"+res);
			
		
	}
}
