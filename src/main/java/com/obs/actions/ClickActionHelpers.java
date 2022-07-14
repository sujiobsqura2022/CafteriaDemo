package com.obs.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActionHelpers {
	Actions act; 
	public void mouseClick(WebDriver driver , WebElement dragableButton)
	{
		act = new Actions(driver);
		try {
			act.moveToElement(dragableButton).click().build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	/**
	 * method to perform right click
	 * @throws Exception 
	 */
	public void rightClick(WebDriver driver, WebElement element) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).contextClick().build().perform();
		}catch (Exception e) {
			throw new Exception("rightClick (ClickActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to perform double click
	 * @throws Exception 
	 */
	public void doubleClick(WebDriver driver, WebElement element) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).doubleClick().build().perform();
		}catch (Exception e) {
			throw new Exception("doubleClick (ClickActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to perform click by X and Y
	 * @throws Exception 
	 */
	public void clickOnXandY(WebDriver driver, int xOffset, int yOffset) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveByOffset(xOffset, yOffset).click().build().perform();
		}catch (Exception e) {
			throw new Exception("clickOnXandY (ClickActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to perform JS Click
	 * @throws Exception 
	 */
	public void clickUsingJS(WebDriver driver, WebElement element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}catch(Exception e) {
			throw new Exception("clickUsingJS (ClickActionHelper) : "+e.getMessage());
		}
	}
	
public void click(WebElement element) throws Exception {
		
		try{
			element.click();
		}

		catch (Exception e) {
			throw new Exception("click (ClickActionHelper)" + e.getMessage());
		}
	}


}


