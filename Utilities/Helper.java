package com.Automation_1.Utilities;

import java.text.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.*;
import java.util.Date;

import org.openqa.selenium.*;

public class Helper {

	
	public static String getScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/link"+getCurrentDateTime()+".png";
		try {
//			FileHandler.copy(src,new File("C:\\Users\\Prince\\eclipse-workspace\\Automation_1\\Screenshots\\Link"+getCurrentDateTime()+".png"));
			
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured :");
		} catch (Exception e) {
			System.out.println("Unable to Capture Screenshot: "+e.getMessage());
			e.printStackTrace();
		}
		return screenshotPath;
		
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	public void handleFrames() {
		
	}
	
	public void handlealerts() {
		
	}
	
	

}
