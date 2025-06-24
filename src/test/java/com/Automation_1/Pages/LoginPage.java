package com.Automation_1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}

	@FindBy(id="username") WebElement uname;	
	@FindBy(id="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement sign_in_btn;
	
	public void LoginToLinkdin(String user,String pass) {
		try {
			Thread.sleep(2000);
			uname.sendKeys(user);
			password.sendKeys(pass);
			
		} catch (Exception e){
			System.out.println("Unable to login:"+e.getMessage());
		}
		try {
			Thread.sleep(2000);
			sign_in_btn.click();
			
		} catch (InterruptedException e){
			System.out.println("Unable to click on Sign-in btn:"+e.getMessage());
		}
		
	}

}
