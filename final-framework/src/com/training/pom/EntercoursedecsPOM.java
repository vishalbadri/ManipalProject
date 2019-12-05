package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntercoursedecsPOM {

private WebDriver driver; 
	
	public EntercoursedecsPOM(WebDriver driver) {
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
	
	private WebElement i;
	
	@FindBy(id="course_description_title")
	private WebElement desctitle;
	
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement content;
	
	@FindBy(id="course_description_submit")
	private WebElement s;
	
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
	List <WebElement> i =    driver.findElements(By.tagName("iframe"));
	System.out.println(i.size());
	driver.switchTo().frame(0);
	content.sendKeys("selenium course for beginners");
	driver.switchTo().defaultContent();
	System.out.println("updates done, clicking on save");
	s.click();
	System.out.println(msgdisp.getText());
	System.out.println("Update sucessful");
	
	
	}
}
	
