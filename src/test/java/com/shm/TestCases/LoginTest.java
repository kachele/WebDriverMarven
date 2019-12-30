package com.shm.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.shm.Base.TestBase;

public class LoginTest extends TestBase {

	
	
	
	
	@Test
	public void logintest() throws InterruptedException {
		
		driver.get(config.getProperty("testurl"));
		driver.findElement(By.xpath(OR.getProperty("emailid"))).sendKeys(config.getProperty("userName_Email"));
		Thread.sleep(3000);
		
	}
}
