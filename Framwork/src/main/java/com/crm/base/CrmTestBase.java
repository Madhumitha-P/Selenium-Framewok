package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrmTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	static String browser;
	
	public CrmTestBase(){
		prop = new Properties();
		try{
			FileInputStream configFile = new FileInputStream("src/test/resources/com/crm/config/config.properties");
			prop.load(configFile);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	public static void initializeDriver(){
		browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			driver = WebDriverManager.chromedriver().create();
		}else if(browser.equalsIgnoreCase("FF")){
			driver = WebDriverManager.firefoxdriver().create();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.PAGE_LOAD_WAIT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
	}

}
