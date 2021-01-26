package com.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.CrmTestBase;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtil;

public class LoginPageTest extends CrmTestBase{
	
	LoginPage login;
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void initial(){
		initializeDriver();
		driver.get(prop.getProperty("url"));
		login =new LoginPage();

	}
	
	@Test
	public void checkTitle(){
		String title = login.checkTitle();
		Assert.assertEquals(prop.getProperty("title"),title);
	}
	
	@Test
	public void login(){
		login.clickSubmit();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE)
			TestUtil.getScreenShot(driver, result);
		driver.quit();
	}
}
