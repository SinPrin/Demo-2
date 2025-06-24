package com.Automation_1.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Linear_script {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
		driver.get("https://www.linkedin.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[starts-with(@class,\"nav__button\")][2]")).click();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("13singhprince@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Sin@Nrip13");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		
		
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.partialLinkText("India made 183"));
		driver.quit();
	}

}
