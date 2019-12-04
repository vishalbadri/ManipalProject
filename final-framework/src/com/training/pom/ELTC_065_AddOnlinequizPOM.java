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
	@FindBy(xpath="//input[@id='qf_f54e82']")
	private WebElement enablestart;
	
	//click on Enable start time after check box
	@FindBy(id="start_time_alt_text")
	private WebElement starttime;
	
	//Select valid credentials in time sections
	@FindBy(xpath="//td[contains(@class,'ui-datepicker-week-end')]//a[@class='ui-state-default'][contains(text(),'7')]")
	private WebElement datepick;
	
	//Select valid credentials in time sections and clicl on done
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
	@FindBy(xpath="//input[@id='question_admin_form_questionName']")
	private WebElement question;
	
	//enter valid credentials in first option textbox - Frame1
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement firstoption;
	
	//enter valid credentials in second option textbox - frame3
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement secondoption;
	
	//enter valid credentials in third option textbox - frame5
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement thirdoption;
	
	//enter valid credentials in forth option textbox - frame7
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
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
	
	public void AddOnlinequiz(String ttitle) 
	{
		Tests.click();
		creatnewtest.click();
		testtile.sendKeys(ttitle);
		advancedsetting.click();
		List <WebElement> fr =    driver.findElements(By.tagName("iframe"));
		System.out.println("Frames are:"+fr.size());
		driver.switchTo().frame(0);
		contextoftest.sendKeys("quiz");
		driver.switchTo().defaultContent();
		Feedback.click();
		enablestart.click();
		starttime.click();
		datepick.click();
		done.click();
		passpercent.sendKeys("50");
		proceed.click();
		assertEquals(Exceraddalert.getText(),"");
		
		
		
		
		
	}

}
