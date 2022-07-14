package com.obs.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.obs.actions.WebActionHelpers;
import com.obs.datahandler.ExcelDataHandler;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.exception.AutomationException;
import com.obs.utils.AutomationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {
	public static WebDriver driver;
	WebActionHelpers webAction = new WebActionHelpers();
	PropertyDataHandler prop = new PropertyDataHandler();

//WebDriver is a example of interface
	// example for method override
	public WebDriver launchBrowser(String browserName) throws AutomationException {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "firefox":
			// case "edge":
			launchFirefoxBrowser();
			// launchedgeBrowser();
			// break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);

			break;
		}
		return driver;
	}

//we create the object of driver classes and work with them
	public WebDriver launchFirefoxBrowser() throws AutomationException {

		try {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Properties allProp;
			allProp = prop.readPropertiesFile("config.properties");
			webAction.navigateToBrowser(driver, allProp.getProperty("url"));
			return driver;
		} catch (Exception e) {

			throw new AutomationException(e.getMessage(), e);
		}

	}

	/*
	 * private WebDriver launchedgeBrowser() throws AutomationException {
	 * 
	 * try { WebDriverManager.edgedriver().setup(); driver = new EdgeDriver();
	 * driver.manage().window().maximize(); Properties allProp; allProp =
	 * prop.readPropertiesFile("config.properties");
	 * webAction.navigateToBrowser(driver, allProp.getProperty("url")); return
	 * driver; } catch (Exception e) {
	 * 
	 * throw new AutomationException(e.getMessage(), e); }
	 * 
	 * }
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	private WebDriver launchChromeBrowser() throws AutomationException {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Properties allProp = prop.readPropertiesFile("config.properties");
			webAction.navigateToBrowser(driver, allProp.getProperty("url"));
			return driver;

		} catch (Exception e) {
			throw new AutomationException(e.getMessage(), e);
		}
	}

	@DataProvider()
	public Object[][] userData() throws InvalidFormatException, IOException {
		Object[][] data = ExcelDataHandler.getDataFromExcel(AutomationConstants.dataProvider_filepath,
				"testData_Sheet1");
		return data;
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());

		}
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = AutomationConstants.screenShot_path + name + dateName + ".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void quitBrowser() {
		// driver.close();
		driver.quit();
	}

}
