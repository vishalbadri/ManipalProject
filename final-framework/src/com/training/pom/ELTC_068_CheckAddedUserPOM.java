package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_068_CheckAddedUserPOM 
{
private WebDriver driver;
	
	public ELTC_068_CheckAddedUserPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	//Click on Administrtion link
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	private WebElement administration;
	
	//Click on Add a user
	@FindBy(linkText="Add a user")
	private WebElement adduser;
	
	//Enter User first name
	@FindBy(id="firstname")
	private WebElement fname;
	
	//Enter Last name
	@FindBy(id="lastname")
	private WebElement lname;
	
	//Enter valid email
	@FindBy(id="email")
	private WebElement email;
	
	//Enter phone 
	@FindBy(id="phone")
	private WebElement phone;
	
	//Enter user name
	@FindBy(id="username")
	private WebElement uname;
	
	//Click on Enter password radio button
	@FindBy(xpath="//input[@id='qf_9cbc4f']")
	private WebElement entpassword;
	
	//Enter Password
	@FindBy(id="password")
	private WebElement upassword;
	
	//Select Valid credentials from profile drop down
	@FindBy(id="status_select")
	private WebElement dropdwn;
	
	//Select Trainer
	@FindBy(xpath="//div[contains(text(),'Trainer')]")
	private WebElement trainer;
	
	//Click on Add button
	@FindBy(xpath="//button[@name='submit']")
	private WebElement addbtn;
	
	//check sucss alert - The user has been added: 
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement addalert;
	
	//Search for the user added to verify - input text
	@FindBy(id="search_simple_keyword")
	private WebElement searchtxt;
	
	//Click on search
	@FindBy(id="search_simple_submit")
	private WebElement searchbtn;
	
	//Verifying user details displayed
	@FindBy(xpath="//a[contains(text(),'manszoor')]")
	private WebElement verify;

	public void CheckAddedUser(String adufname, String adulname, String adumail, String adufone, String adunme, String adupwd) 
	{
		administration.click();
		adduser.click();
		fname.clear();
		fname.sendKeys(adufname);
		lname.clear();
		lname.sendKeys(adulname);
		email.clear();
		email.sendKeys(adumail);
		phone.clear();
		phone.sendKeys(adufone);
		uname.clear();
		uname.sendKeys(adunme);
		entpassword.click();
		upassword.clear();
		upassword.sendKeys(adupwd);
		dropdwn.click();
		trainer.click();
		addbtn.click();
		assertEquals(addalert.getText(),"The user has been added:"+adufname+" "+adulname);
		System.out.println("User Added");
	}
	public void searchuser(String adufname) 
	{
		searchtxt.clear();
		searchtxt.sendKeys(adufname);
		searchbtn.click();
		assertEquals(verify.getText(),adufname);
		System.out.println("User Sucessfully searched");

	}
	

}
