package com.shm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	
	
	
	
	
	@BeforeSuite
	public void setUp(){
		
		
		if (driver==null) {
			
			
			
			try {
				fis = new FileInputStream("C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream("C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (config.getProperty("browser").equals("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\executable\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				
			}else if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\executable\\chromedriver.exe");	
				driver = new ChromeDriver();
			
			
		}else if (config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\User\\Selenium\\GitWebDriverMarven\\GitWebDriverMarven\\src\\test\\resources\\executable\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		
	}
		driver.get(config.getProperty("testurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	
	
	}
	}
	
	@AfterSuite
	public void TearDown() {
		
		if(driver!=null) {
		driver.quit();
		}
	}
	
}
	
