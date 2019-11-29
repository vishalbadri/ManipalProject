package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elearning_LoginPOM 
{
private WebDriver driver; 
	
	public Elearning_LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	public void Elearning_LoginPOM(String userName,String password)
	 {
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.password.clear(); 
		this.password.sendKeys(password); 
		this.loginBtn.click(); 
	}
	

}
