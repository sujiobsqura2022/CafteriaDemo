package com.obs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obs.base.AutomationBase;
import com.obs.pages.AddCategory;
import com.obs.pages.AddProduct;
import com.obs.pages.CafteriaHomepage;
import com.obs.pages.CafteriaLoginPage;

public class AddCategoryTest extends AutomationBase{
	WebDriver driver;
	CafteriaLoginPage loginpg;
	AddProduct addpro;
	CafteriaHomepage homepg;
	 AddCategory addcat;

public AddCategoryTest() {
	super();
}
@BeforeMethod
@Parameters("browserType")
public void setup(String browserType) throws Exception {
	driver = launchBrowser(browserType);
	loginpg = new CafteriaLoginPage(driver);
	loginpg.login("admin", "password");
	homepg = new CafteriaHomepage(driver);
	addpro = new AddProduct(driver);
	//addpro = homepg.productclick();
	addcat=addpro.categoryclick();
	//addpro.addproduct();

}


@Test(priority = 1)
public void openManageExpense() throws Exception {
	// click manage expense
	
	addcat.clickManageExpenseMenu();
	Assert.assertTrue((boolean) addcat.isSubmenuVisble());
	
}

@Test(priority = 2)
public void clickExpenseCategory() throws Exception {
	// click expense category
	addcat.clickExpenseCategorySubMenu();
	//TODO: verify expense category main title
}

@Test(priority = 3)
public void addNewCategory() throws Exception {
	// click on new & save category
	//addcat.addNewCategory();
	// verify success alert
	//assertTrue(expenseCategoryPage.isSuccessAlertDisplayed());
}
@AfterMethod
public void quitBrowser() {
	// driver.quit();
}

}
