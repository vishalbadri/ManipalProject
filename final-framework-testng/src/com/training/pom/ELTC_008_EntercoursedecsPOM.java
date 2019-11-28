package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELTC_008_EntercoursedecsPOM {

private WebDriver driver; 
	
	public ELTC_008_EntercoursedecsPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	//Finding  the WebElements here
	@FindBy(linkText = "Course list")
	private WebElement courselist;
	
	@FindBy(linkText = "Selenium")
	private WebElement selcourse;
	
	@FindBy(id="istooldesc_6418")
	private WebElement coursedesc;
	
	@FindBy(xpath="//section[@id='cm-content']//div[@class='row']//a[1]//img[1]")
	private WebElement descript;
	
	@FindBy(id="course_description_title")
	private WebElement desctitle;
	
	@FindBy(tagName = "iframe")
	private WebElement cntframe;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement content;
	
	@FindBy(id="course_description_submit")
	private WebElement save;
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[3]/div/div[2]")
	private WebElement msgdisp;
	//
	
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
	
	public  void ELTC_008_Entercoursedecs()
	{
	courselist.click();
	selcourse.click();
	coursedesc.click();
	descript.click();
	desctitle.sendKeys("selenium course for beginners");
	WebDriverWait wait =new WebDriverWait(driver,1000);
	wait.until(ExpectedConditions.visibilityOf(cntframe));
	content.sendKeys("selenium course for beginners");
	save.click();
//	System.out.println(msgdisp.getText());
	
	
	}
}
	
