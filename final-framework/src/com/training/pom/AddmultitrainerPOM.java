package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddmultitrainerPOM 
{
private WebDriver driver;
	
	public AddmultitrainerPOM(WebDriver driver) {
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
}
