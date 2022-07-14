package com.obs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitUtil {
	WebDriver driver;
	public WebDriverWait wait;

	 public WaitUtil(WebDriver driver)
		{
			this.driver = driver;
			
	}
	 
	
	public void waitforElementVisible(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(AutomationConstants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
	 }
//example of methodoverloading(compile time)polymorphism
	public void implicitWait() {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AutomationConstants.IMPLICIT_WAIT));
	}
	public void implicitWaitminutes() {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(AutomationConstants.IMPLICIT_WAIT1));
	}
	public void implicitWaithour() {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(AutomationConstants.IMPLICIT_WAIT2));
	}

	
	public void waitforElementClick(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(AutomationConstants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}

