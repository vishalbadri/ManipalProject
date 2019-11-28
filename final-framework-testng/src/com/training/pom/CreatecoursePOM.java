package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatecoursePOM {
	private WebDriver driver; 
	
	public CreatecoursePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
//Finding  the WebElements here
	@FindBy(id="update_course_title")
	private WebElement coursetitle;
	
	@FindBy(id="visual_code")
	private WebElement code;
	
	private WebElement category;
	private WebElement language;
	@FindBy(xpath="//div[@class='toolbar-edit']//a[1]")
	private WebElement icon;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement putintro;
	
	@FindBy(id="update_course_submit")
	private WebElement Create_course_Btn;
	
	@FindBy(name="intro_cmdUpdate")
	private WebElement saveintro;
	
	@FindBy(id="view_as_link")
	private WebElement saved;
	
		// Validating the header of the Createcourse page by using assert 	
	String act;
	String pgTitle ="My Organization - My education - Create a course";
		
		public  void validateCreatecourseHeader() 
		{
			 
			System.out.println("Given Title is:"+pgTitle);
			act = driver.getTitle();
			System.out.println("Actual title is:"+act);
			assertEquals(pgTitle, act);
			System.out.println("Create a course Page Verified");
			
		}
		// creating public method to get values from dropdowns
		public static void selectValueFromDropdown(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
		
		// Fill up the required details for create Course
		
		public void CreateacoursePOM(String coutitle, String cod,String cat,String lang)
		{
			System.out.println("Start filling course details items");
			
			this.coursetitle.clear();
			this.coursetitle.sendKeys(coutitle);
			
			this.code.clear();
			this.code.sendKeys(cod);
			
			this.category = driver.findElement(By.id("update_course_category_code"));
			selectValueFromDropdown(category,cat);			
			
			this.language = driver.findElement(By.id("update_course_course_language"));
			selectValueFromDropdown(language,lang);
			
			this.Create_course_Btn.click();
			System.out.println("Filled all items and Clicked Create Button");
			
		}
		// Validating after Successful course creation
		String crActual; 		
		String crPage = "My Organization - My education - Course list";
		public void validateAftercreate() {
			
			crActual = driver.getTitle();
			assertEquals(crPage,crActual);
			driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			System.out.println("Create course sucessfully completed");
			
		}
		
		public void Clickcourse() {
			
			driver.findElement(By.linkText("Selenium")).click();
			System.out.println("Clicking the icon");
			icon.click();
			System.out.println("Clicked  the icon");

	//		putintro = putintro.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"));
			System.out.println("Adding Intro");
			System.out.println("added Intro");
			this.saveintro.click();
			String s = saved.getText();
			System.out.println(s);
			
		}
		
}