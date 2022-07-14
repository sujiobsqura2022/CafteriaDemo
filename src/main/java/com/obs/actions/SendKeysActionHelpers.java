package com.obs.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKeysActionHelpers {
	
WebDriver driver;
	
	public void sendkeys(WebElement location, String InputValue)
	{
		try {
		location.sendKeys(InputValue);
		}
		catch (Exception e) {
			
			System.out.println("Exception occured" +e);
			// TODO: handle exception
		}
	}
	

	public void clearAndsendkeys(WebElement location, String InputValue)
	{
		try {
			location.clear();
		location.sendKeys(InputValue);
		}
		catch (Exception e) {
			
			System.out.println("Exception occured" +e);
			// TODO: handle exception
		}
	}
	/**
	 * method to set text to input field using js
	 * @throws Exception 
	 */
	public void sendKeysJsById(WebDriver driver, String elementId, String text) throws Exception {
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('"+elementId+"').value='"+text+"';");
		}catch(Exception e) {
			throw new Exception("sendKeysByJs (SendKeysActionHelper) "+e.getMessage());
		}
	}


	

}
