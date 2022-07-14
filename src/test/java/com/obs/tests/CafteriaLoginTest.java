package com.obs.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obs.base.AutomationBase;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.exception.AutomationException;
import com.obs.pages.CafteriaHomepage;
import com.obs.pages.CafteriaLoginPage;

public class CafteriaLoginTest extends AutomationBase {

	WebDriver driver;
	CafteriaLoginPage loginpg;
	CafteriaHomepage homepg;
	PropertyDataHandler prop = new PropertyDataHandler();

	public CafteriaLoginTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws AutomationException {
		driver = launchBrowser(browserType);
		loginpg = new CafteriaLoginPage(driver);
	}

	// 1. Validate Successful login
	//@Test(dataProvider = "userData", priority = 1, groups = "sanity")
	@Test(priority = 1,groups="sanity")
	public void validateSuccessfulLogin() throws Exception {
		loginpg.typeUsername("username");
		loginpg.typePassword("password");
		loginpg.clickLogin();
		
		
		//loginpg.login("un", "pwd");//from excel
		//loginpg.clickLogin();
	}
	// Verify the fields are displayed
	
	@Test(priority = 2, enabled = true)
	public void isLoginFieldsDisplayed() {
		Assert.assertTrue(loginpg.isLoginfieldsdisplayed(), "Unable to find LoginField");
		Assert.assertTrue(loginpg.isPasswordfieldsdisplayed(), "Unable to find PasswordField");
	}
	// Verify the Cafeteria Name

	@Test(priority = 3, enabled = true)
	public void verifyCafetriaName() {
		String actual = loginpg.getCafteriaName();
		String Excepted = "© 2022 Presto Cafeteria";
		Assert.assertEquals(actual, Excepted, "Invalid Name");
	}
	// Verify the url of Cafeteria page

	@Test(priority = 4, enabled = true)
	public void verifyUrl() throws IOException {
		String Actual = loginpg.getCurrentPageUrl();
		String Excepted = "https://qalegend.com/restaurant/login";
		Assert.assertEquals(Actual, Excepted, "Invalid URL");
	}

	// Verify the Title page of Cafeteria

	@Test(priority = 5, enabled = true)
	public void verifyTitle() throws IOException {
		String Actual = loginpg.getCurrentPageTitle();
		String Excepted = "POS Login";
		Assert.assertEquals(Actual, Excepted, "Invalid Title");
	}
	// Verify the Logo of Cafeteria

	@Test(priority = 6, enabled = true)
	public void verifyLogoPresent() {
		Assert.assertTrue(loginpg.islogopresent(), "Logo not present in login pgae");
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
