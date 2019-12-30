package com.shm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
	
	public static void main(String[] args) throws IOException  {
		
		 System.out.println(System.getProperty("user.dir"));
		// System.out.println(config.getProperty("testurl"));
		 
				
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream("C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		Properties OR = new Properties();
		 fis = new FileInputStream("C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		
		    System.out.println(config.getProperty("testurl"));
		    //System.out.println(System.getProperty("user.dir"));
		    System.out.println(OR.getProperty("emailid"));
	}
	
	
	
	
	
	

}


