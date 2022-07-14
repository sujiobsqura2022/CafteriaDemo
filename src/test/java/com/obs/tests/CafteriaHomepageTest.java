package com.obs.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.pages.CafteriaLoginPage;
import com.obs.pages.AddProduct;
import com.obs.pages.CafteriaHomepage;
import com.obs.base.AutomationBase;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.exception.AutomationException;

public class CafteriaHomepageTest extends AutomationBase {
	PropertyDataHandler prop = new PropertyDataHandler();
	WebDriver driver;
	CafteriaLoginPage loginpg;
	CafteriaHomepage homepg;
	AddProduct addpro;

	public CafteriaHomepageTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws AutomationException, IOException {
		driver = launchBrowser(browserType);
		//loginpg = new CafteriaLoginPage(driver);
		//loginpg.login("admin", "password");
		loginpg = new CafteriaLoginPage(driver);
		homepg = loginpg.login("admin", "password");
		homepg = new CafteriaHomepage(driver);
	}
			//Verify HomePage Logo present in the left side
	
	@Test(priority = 7, enabled = true)
	public void VerifyHomeLogoPresent() {
		Assert.assertTrue(homepg.isLogovisible(), "Logo not visible in HomePage");
	}
			//Verify AdminName display on the right side
	
	@Test(priority = 8, enabled = true)
	public void verifyHomepageadminename() {
		String actual = homepg.getAdminName();
		String expected = "  admin Doe";
		Assert.assertEquals(actual, expected, "AdminName Not Matching");
	}
			//Verify ADMIN Image is present or not

	@Test(priority = 9, enabled = true)

	public void verifyHomepageadminImage() throws Exception {
		Assert.assertTrue(homepg.getAdminImage(), "Image not present in homepage");
	}
			//Verify each HomePage menu present or not
	@Test(priority = 10, enabled = true)

	public void verifyHomepageMainmenu() throws Exception {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepg.isPosDisplayed(), "POS is not displayed");
		soft.assertTrue(homepg.isProductDisplayed(),"Productmenu not displayed");
		soft.assertTrue(homepg.isSaleDisplayed(),"Salesmenu not displayed");
		soft.assertTrue(homepg.isPeopleDisplayed(),"Peoplemenu not dispalyed");
		soft.assertTrue(homepg.isStoreDisplayed(),"Storemenu not dispalyed");
		soft.assertTrue(homepg.isReportsDisplayed(),"Reportsmenu not displayed");
		soft.assertTrue(homepg.isSettingsDisplayed(),"Settingsmenu not dispalyed");
		soft.assertAll();	
		
	}
			//Verify the title of Homepage
	@Test(priority = 11, enabled = true)
				
	public void verifyHomepageHeading() throws Exception {
		String actual = homepg.getHeadingTitle();
		String expected = "CHOOSE A STORE";
		Assert.assertEquals(actual, expected, "Heading not matching");
	}
		//Verify Different Store names dispaly in Homescreen
	@Test(priority = 12, enabled = false)

	public void verifyHomepageStore() throws Exception {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepg.getStoreName1(),"no store to dispaly");
		soft.assertTrue(homepg.getStoreName2(),"no store to dispaly");
		soft.assertTrue(homepg.getStoreName3(),"no store to dispaly");
	
		soft.assertAll();
	}
		//Verify Logout Button

	@Test(priority = 13, enabled = false)

	public void verifyLogoutButtton() throws Exception {
		homepg.clickLogoutButton();
		// Assert.assertTrue(true);
	}
		//verify addproduct class connection
	@Test(priority = 14)
	public void verifyProductLinkTest() throws Exception {
		addpro = homepg.productclick();

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
