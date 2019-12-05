package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateGroupsPOM {
private WebDriver driver; 
	
	public CreateGroupsPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
	//Finding  the WebElements here
	

	@FindBy(linkText="Groups")
	private WebElement Groups;
	
	
	@FindBy(xpath="//div[@id='toolbar-groups']//a[1]//img[1]")
	private WebElement creategrpikn;
	
	@FindBy(xpath="//button[@id='create_groups_submit']")
	private WebElement creategrpbtn;
	
	@FindBy(xpath="//input[@name='group_0_name']")
	private WebElement grpnametxt;
	
	@FindBy(xpath="//button[@id='create_groups_step2_submit']")
	private WebElement groupsubmit;
	
	@FindBy(xpath="//div[@class='table-responsive']//a[3]//img[1]")
	private WebElement grpmembers;
	
	@FindBy(xpath="//div[@class='table-responsive']//a[1]//img[1]")
	private WebElement edtgrp;
	
	@FindBy(xpath="//*[@id='self_registration_allowed']")
	private WebElement chkbox1;
	
	@FindBy(xpath="//*[@id='self_unregistration_allowed']")
	private WebElement chkbix2;
	
	@FindBy(xpath="//button[@id='group_edit_submit']")
	private WebElement savebttn;
	
	private WebElement groupmemeberslist;
 
	@FindBy(xpath="//button[@id='group_members_rightSelected']")
	private WebElement selectmembers;
	
	@FindBy(xpath="//select[@id='group_members_to']")
	private WebElement selectedmembers;
	  
	@FindBy(xpath="//button[@id='group_edit_submit']")
	private WebElement saveset;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alert1;
	
	public  void validateHeader() 
	{
		
		String pgTitle ="My Organization - My education";
		String act = driver.getTitle();	
		assertEquals(pgTitle,act);
		System.out.println("Page verified");
	}
	
	public void CreateGroups() {
		Groups.click();
		creategrpikn.click();
		creategrpbtn.click();
		grpnametxt.clear();
		grpnametxt.sendKeys("rockers");
		groupsubmit.click();
		grpmembers.click();
		WebElement groupmemeberslist =driver.findElement(By.xpath("//select[@id='group_members']"));
        Select a =new Select(groupmemeberslist);
        a.selectByIndex(0);
        a.selectByIndex(1);
        a.selectByIndex(2);
        selectmembers.click();
        WebElement selectedmembers =driver.findElement(By.xpath("//select[@id='group_members_to']"));
        		  Select m =new Select(selectedmembers);
        		  java.util.List<WebElement> allValues =m.getOptions();
        				               for(int x=0;x<allValues.size();x++)
        				               {
        				                   System.out.println("Selected Members are:"+allValues.get(x).getText());
        				               }
        saveset.click();
        assertEquals(alert1.getText(),"Group settings modified");
        System.out.println("Group setting sucessfully modified");
        edtgrp.click();
        chkbox1.click();
        chkbix2.click();
        savebttn.click();
        assertEquals(alert1.getText(),"Group settings modified");
        System.out.println("Group setting sucessfully saved and modified");
	}
}
