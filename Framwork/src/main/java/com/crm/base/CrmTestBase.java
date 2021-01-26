package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.utils.TestUtil;
import com.crm.utils.WebEventListener;

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
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("driverPath"));
			driver = new FirefoxDriver();
		}
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		WebEventListener eListener = new WebEventListener();
		eDriver.register(eListener);
		driver = eDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}

}
