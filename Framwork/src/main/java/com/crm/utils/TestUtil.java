package com.crm.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.crm.base.CrmTestBase;

public class TestUtil extends CrmTestBase{
	public static long IMPLICITLY_WAIT = 20;
	public static long PAGE_LOAD_WAIT = 10;
	public static String des;
	
	public TestUtil(){
		super();
	}
	
	public static String getScreenShot(WebDriver driver, ITestResult result) throws IOException{
		des = prop.getProperty("extentReports") + result.getName() + ".png";
		File desc = new File(des);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, desc);
		return des;
		
	}
}
