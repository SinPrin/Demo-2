package com.Automation_1.Testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Automation_1.Pages.Baseclass;
import com.Automation_1.Pages.LoginPage;
import com.Automation_1.Utilities.Browser_Search;
import com.Automation_1.Utilities.ExcelDataProvider;
import com.Automation_1.Utilities.Helper;
import com.aventstack.extentreports.Status;

public class Login_Test extends Baseclass {
	@Test(priority=1)
	public void LoginApp() throws InterruptedException {
		Thread.sleep(20);
		ExcelDataProvider Excel= new ExcelDataProvider();
		
		driver.findElement(By.xpath("//a[starts-with(@class,\"nav__button\")][2]")).click();
		try {
		logger=report.createTest("Login to Linkdin");
		
		LoginPage LoginPage=PageFactory.initElements(driver, com.Automation_1.Pages.LoginPage.class);
		logger.info("Starting Application");
		LoginPage.LoginToLinkdin(Excel.getStringData("Login", 0, 0), Excel.getStringData("Login", 0, 1));
		
		Reporter.log("User is logged in application. :", true);
		
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String name= driver.findElement(By.xpath("//h3[text()='Prince Singh']")).getText().trim();
		if(name.contains("Prince Singh")) {
			System.out.println("Correct user logged in: "+name);
//			logger.pass("User login is Done:");
//			logger.log(Status.PASS, "Logged in by Prince:");
			Reporter.log("User : Prince Singh is logged-in. :", true);
		}
		else {
			System.out.println("Not a Correct user logged in: "+name);
		}
		
		} catch (Exception e) {
			System.out.println("Unable to login: "+e.getMessage());
			e.printStackTrace();
			Helper.getScreenShot(driver);
		}
		
		
	//Login in linkd-in steps
//		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("13singhprince@gmail.com");
//		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Sin@Nrip13");
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		
		
	}
}
