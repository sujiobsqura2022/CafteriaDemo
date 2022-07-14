package com.obs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.actions.ClickActionHelpers;
import com.obs.base.AutomationBase;
import com.obs.pages.AddProduct;
import com.obs.pages.CafteriaHomepage;
import com.obs.pages.CafteriaLoginPage;

public class AddProductTest extends AutomationBase {

	WebDriver driver;
	CafteriaLoginPage loginpg;
	AddProduct addpro;
	CafteriaHomepage homepg;
	ClickActionHelpers click = new ClickActionHelpers();;

	private static final String CATEGORY = "pran";
	private static final String CATEGORY1 = "shawarma";
	// private static final int code = 11;
	private static final String code1 = "apple juice";

	public AddProductTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws Exception {
		driver = launchBrowser(browserType);
		loginpg = new CafteriaLoginPage(driver);
		homepg = loginpg.login("admin", "password");
		addpro = homepg.productclick();
	}

	// Verify the Product search
	@Test(priority = 15, enabled = true)

	public void verifyValidSearch() throws Exception {
		addpro.searchValidProduct(CATEGORY);
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the InProduct search
	@Test(priority = 16, enabled = true)

	public void verifyInvalidSearch() throws Exception {
		addpro.searchValidProduct(CATEGORY1);
		Assert.assertTrue(addpro.iserrorMessageDisplayed());
	}

	// Verify the filter button
	@Test(priority = 17, enabled = true)

	public void verifyfilterbutton() throws Exception {
		addpro.getApplyfilter();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}
	// Verify the showentries of products from dropdown

	@Test(priority = 18, enabled = true)

	public void verifyentries() throws Exception {
		addpro.displayentries();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the delete button
	@Test(priority = 19, enabled = true)
	public void Verifydeletebutton() {
		addpro.searchValidProduct(CATEGORY);
		addpro.deleteelement();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the AddProduct button
	@Test(priority = 20, enabled = true)

	public void Verifyaddproductbutton() throws Exception {
		addpro.verifyAddproductbutton();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the print button
	@Test(priority = 21, enabled = true)

	public void Verifyprintbutton() {
		addpro.verifyprintbutton();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the download button of CSV
	@Test(priority = 23, enabled = true)

	public void Verifycsvbuttton() {
		addpro.verifydownloadcsvbutton();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// Verify the values in addproduct form
	@Test(priority = 24, enabled = true)

	public void Verifysendvalues() {
		addpro.verifyAddproductbutton();
		addpro.verifyAddprouct();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}
	// verify delete in dynamic table

	@Test(priority = 25, enabled = false)

	public void Verifydeletetable() {
		addpro.deleteelement1("123", driver);
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	// verify view in dynamic table
	@Test(priority = 26, enabled = true)

	public void Verifyviewproduct() {
		addpro.searchValidProduct(code1);
		addpro.viewProduct(code1, driver);
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	@Test(priority = 27, enabled = false)

	public void Verifyeditproduct() {
		addpro.searchValidProduct(code1);
		addpro.veriftEditbutton();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
	}

	@Test(priority = 28, enabled = false)

	public void verifyfieldsinProductmenu() throws Exception {
		addpro.verifyAddproductbutton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(addpro.iscodevisible(), "Code is not visible");
		soft.assertTrue(addpro.ispcategoryvisible(), "Category Not visible");
		soft.assertTrue(addpro.ispricevisible(), "Pricefield not visible");
		soft.assertTrue(addpro.isproductnamevisible(), "Productname not visible");
		soft.assertTrue(addpro.ispunitvisible(), "punit not visible");
		soft.assertAll();
	}

	@Test(priority=29,enabled=true)

	public void verifyLogoutButtton() throws Exception {
		addpro.clickLogoutButton();
		Assert.assertTrue(addpro.isResultMessageDisplayed());
		// Assert.assertTrue(true);
	}

	/*
	 * @DataProvider // use this for Data driven framework public Object[][]
	 * getPOSTestData(){ Object data[][] = ExcelDataHandler.getTestData(sheetName);
	 * //this will store the complete data in data[][] return data; // always use
	 * return in case of using data and use object[][] }
	 * 
	 * @Test(priority=4, dataProvider="getCRMTestData")//to use the excel sheet in
	 * test case use this line public void validateCreateNewContact(String title,
	 * String firstName, String lastName, String company){ //use same column names
	 * which are in excel sheet homePage.clickOnNewContactLink(); // use below line
	 * only when there are minimum records and not using excel sheet
	 * //contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	 * contactsPage.createNewContact(title, firstName, lastName, company); }
	 */

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}