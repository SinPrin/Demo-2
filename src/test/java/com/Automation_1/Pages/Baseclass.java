/**
 * 
 */
package com.Automation_1.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.Automation_1.Utilities.Browser_Search;
import com.Automation_1.Utilities.ConfigDataProvider;
import com.Automation_1.Utilities.ExcelDataProvider;
import com.Automation_1.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 */
public class Baseclass {

	/** This Java class is used to define and execute Prior/Post conditions to start testing . 
	 * For example : Launch a browser (Chrome/ any ) ,  Quit browser 
	 */
	public WebDriver driver;
	public ExcelDataProvider Excel;
	public ConfigDataProvider Config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up of testing will started:", true);
		
		Excel = new ExcelDataProvider();
		Config =new ConfigDataProvider();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Report/Spark"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(spark);
		
	}
	
	@BeforeClass
	public void set_Up() {
		Reporter.log("Searching for application Url:", true);
		driver = Browser_Search.start_Application(driver,Config.getConfigBrowser(), Config.getConfigAppUrl());
	}
	
	@AfterClass
	public void tear_Down() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Browser_Search.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
//			Helper.getScreenShot(driver);
			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
		}
		Reporter.log("All testing activites are done and set-up is going to close>> Report is generated:", true);
		report.flush();
	}
	

}
