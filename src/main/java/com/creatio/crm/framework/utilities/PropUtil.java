package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropUtil {
	
	//common method to read data from config.Properties file
	public static Properties readData(String fileName) {
		
		//Initialize properties class to store all properties from properties file
		Properties prop = new Properties();
		
		//to handle file not found exception, use try catch block
		try {
			
			//Read properties file using FileInputStream class
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config//"+fileName);
			
			//Load data from file to prop variable
			prop.load(fis);
			
		} catch(Exception e) {
			e.printStackTrace();
		  }
		
		return prop;
		
	}

}
