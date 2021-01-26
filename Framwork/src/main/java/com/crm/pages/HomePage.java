package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.CrmTestBase;

public class HomePage extends CrmTestBase{
	
	@FindBy(id="welcome")
	public WebElement name;
	
	@FindBy(id="menu__Performance")
	public WebElement perfTab;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String checkName(){
		return name.getText();
	}
	
	public void perfClick(){
		perfTab.click();
	}
}
