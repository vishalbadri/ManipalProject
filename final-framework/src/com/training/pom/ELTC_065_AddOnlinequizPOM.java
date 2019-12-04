package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_065_AddOnlinequizPOM {
private WebDriver driver; 
	
	public ELTC_065_AddOnlinequizPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	
	//Click on Test
	@FindBy(id="istooldesc_6423")
	private WebElement Tests;
	
	//Click on Create a new test button
	@FindBy(xpath="//div[@class='actions']//a[1]//img[1]")
	private WebElement creatnewtest;
	
	//Enter valid credentials in Test name textbox
	@FindBy(id="exercise_title")
	private WebElement testtile;
	
	//click on advanced setting button
	@FindBy(id="advanced_params")
	private WebElement advancedsetting;
	
	//enter valid credentials in Give a context to the test textbox
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement contextoftest;
	
	//click on At end of test radio button in Feedback section
	@FindBy(id="exerciseType_0")
	private WebElement Feedback;
	
	//click on Enable start time checkbox
	@FindBy(xpath="//label[contains(text(),'Enable start time')]")
	private WebElement enablestart;
	
	//click on Enable start time after check box
	@FindBy(xpath="//div[@id='date_time_wrapper_start_time']//span[@class='input-group-addon cursor-pointer']")
	private WebElement starttime;
	
	//Select valid credentials in time sections
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]/a")
	private WebElement datepick;
	
	//Select valid credentials in time sections and click on done
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div[3]/button[2]")
	private WebElement done;
	
	//Enter valid credentials in Pass percentage textbox
	@FindBy(id="pass_percentage")
	private WebElement passpercent;
	
	//Click on Proceed to questions button
	@FindBy(xpath="//button[@id='exercise_admin_submitExercise']")
	private WebElement proceed;
	
	//check sucess message
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement Exceraddalert;
	
	//Click on Multiple Choice icon
	@FindBy(xpath="//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]")
	private WebElement multichoice;
	
	//Enter valid credentials in Questions textbox
	
	@FindBy(xpath="//form[@id='question_admin_form']")
	private WebElement form;
	
	@FindBy(id="question_admin_form_questionName")
	private WebElement question;
	
	//enter valid credentials in first option textbox - Frame1

	private WebElement firstoption;
	
	//enter valid credentials in second option textbox - frame3

	private WebElement secondoption;
	
	//enter valid credentials in third option textbox - frame5

	private WebElement thirdoption;
	
	//enter valid credentials in forth option textbox - frame7

	private WebElement fourthoption;
	
	
	//click on Add this question to the test
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement addbutton;
	
	//item added sucess alert 
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucessalert;
	
	//click on preview icon
	@FindBy(xpath="//div[@class='actions']//a[2]//img[1]")
	private WebElement preview;
	
	// start test button should be displayed
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement starttest;

	public  void validateHeader() 
	{
		
		String pgTitle ="My Organization - My education";
		String act = driver.getTitle();	
		assertEquals(pgTitle,act);
		System.out.println("Page verified");
	}
	
	public void AddOnlinequizexcer(String ttitle) 
	{
		Tests.click();
		creatnewtest.click();
		testtile.clear();
		testtile.sendKeys(ttitle);
		advancedsetting.click();
		List <WebElement> fr =    driver.findElements(By.tagName("iframe")); 
		driver.switchTo().frame(0);
		contextoftest.clear();
		contextoftest.sendKeys("quiz");
		driver.switchTo().defaultContent();
		Feedback.click();
		enablestart.click();
		starttime.click();
		datepick.click();
		done.click();
		passpercent.clear();
		passpercent.sendKeys("50");
		proceed.click();
		assertEquals(Exceraddalert.getText(),"Exercise added");
	}
	public void AddOnlineitem(String quest, String firsto, String secondo, String thirdo, String fourtho)
	{
	multichoice.click();
/*		for (int i =0;i<5;i++) {
			
		}*/
		question.clear();
		question.sendKeys(quest);
		List <WebElement> ifr1 =    driver.findElements(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
//switch to first frame		
		driver.switchTo().frame(1);
		firstoption = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"));
		firstoption.clear();
		firstoption.sendKeys(firsto);
		driver.switchTo().defaultContent();
// switch to second frame
		driver.switchTo().frame(3);
		secondoption = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"));
		secondoption.clear();
		secondoption.sendKeys(secondo);
		driver.switchTo().defaultContent();
// switch to third frame
		driver.switchTo().frame(5);
		thirdoption = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"));
		thirdoption.clear();
		thirdoption.sendKeys(thirdo);
		driver.switchTo().defaultContent();
// switch to fourth frame
		driver.switchTo().frame(7);
		fourthoption=driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"));
		fourthoption.clear();
		fourthoption.sendKeys(fourtho);
		driver.switchTo().defaultContent();
		addbutton.click();
		assertEquals(sucessalert.getText(),"Item added");
		preview.click();
		assertEquals(starttest.getText(),"Start test");
		System.out.println("Verified all");
		
	}

}
