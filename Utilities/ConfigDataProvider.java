package com.Automation_1.Utilities;

import java.io.*;
import java.util.*;

public class ConfigDataProvider {
	
	Properties pro;

	public ConfigDataProvider() {
		
		File src = new File(System.getProperty("user.dir")+"/Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read the config file: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public String getDatafromConfig(String KeytoSearch) {
		
		return pro.getProperty(KeytoSearch);
	}
	
    public String getConfigBrowser() {
		
		return pro.getProperty("Browser");  
	}
    
    public String getConfigAppUrl() {
		
  		return pro.getProperty("appURL");  
  	}

}
