package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.CrmTestBase;

public class LoginPage extends CrmTestBase{
	@FindBy(id="txtUsername")
	public WebElement UserName;
	@FindBy(id="txtPassword")
	public WebElement Password;
	@FindBy(id="btnLogin")
	public WebElement Button;
		
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String checkTitle(){
		return driver.getTitle();
	}
	public void enterUserName(){
		UserName.sendKeys(prop.getProperty("username"));
	}
	
	public void enterPassword(){
		Password.sendKeys(prop.getProperty("password"));
	}
	
	public HomePage clickSubmit(){
		enterUserName();
		enterPassword();
		Button.click();
		return  new HomePage();
	}
}
