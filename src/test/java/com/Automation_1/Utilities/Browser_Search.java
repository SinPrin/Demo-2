package com.Automation_1.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Search {
	
	public static WebDriver start_Application(WebDriver driver, String BrowserName, String appURL) {
		
		if(BrowserName.equals("chrome")){
			System.setProperty("WebDriver.chrome.driver", ".Drivers/chromedriver.exe");
		    driver = new ChromeDriver();
		    
		}
		else if(BrowserName.equals("Firefox")) {
			System.setProperty("WebDriver.Firefox.driver", ".Drivers/Firefoxdriver.exe");
			driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("We do not have this browser:");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
