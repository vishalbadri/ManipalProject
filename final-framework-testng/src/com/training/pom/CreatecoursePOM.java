package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(id=contains(text(),'none')")
	private WebElement category;
//	Select category = new Select(FindElement(driver.findElement(By.className("filter-option-inner-inner"))));

//	@FindBy(how = How.CLASS_NAME, using = "filter-option")
//	private WebElement category;
//	private WebElement language = driver.findElement(By.xpath("//*[@id=\'update_course\']/fieldset/div[7]/div[1]/div/button/div/div/div"));
	@FindBy(className = "filter-option-inner-inner")
	private WebElement language;
	
	@FindBy(id="update_course_submit")
	private WebElement Create_course_Btn;
	
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
		private WebElement FindElement(WebElement findElement) {
			// TODO Auto-generated method stub
			return null;
		}
		// Fill up the required details
		
		public void CreateacoursePOM(String coutitle, String cod,String cat,String lang)
		{
			System.out.println("Start filling the items");
			System.out.println("Filling Course title");
			this.coursetitle.clear();
			this.coursetitle.sendKeys(coutitle);
			System.out.println("Filling Code");
			this.code.clear();
			this.code.sendKeys(cod);
			System.out.println("Filling category");
			this.category.sendKeys(cat);
			System.out.println("Fillinf Language");
			this.language.sendKeys(lang);
			System.out.println("Clicking the create Button");
			this.Create_course_Btn.click();
			
		}
		// Validating after Successful course creation
		String crActual;
		String crPage = "My Organization - My education - Course list";
		public void validateAftercreate() {
			System.out.println("Given Pageis:"+crPage);
			crActual = driver.getTitle();
			System.out.println("Actual page title is"+crActual);
			assertEquals(crPage,crActual);
			System.out.println("Create course sucessfully completed");
		}
}