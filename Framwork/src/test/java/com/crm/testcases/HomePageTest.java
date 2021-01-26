package com.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.CrmTestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtil;

public class HomePageTest extends CrmTestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest(){
		 super();
	}
	
	@BeforeMethod
	public void login(){
		initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage();
		homePage = loginPage.clickSubmit();
	}
	
	@Test
	public void verifyName(){
		String name = homePage.checkName();
		Assert.assertEquals(prop.getProperty("name"),name);
	}
	
	@Test
	public void clickPerf(){
		homePage.perfClick();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE)
			TestUtil.getScreenShot(driver, result);
		driver.quit();
	}
}
