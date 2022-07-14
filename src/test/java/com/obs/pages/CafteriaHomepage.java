package com.obs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.actions.ClickActionHelpers;
import com.obs.actions.ValidationActionHelpers;
import com.obs.actions.WebActionHelpers;
import com.obs.utils.WaitUtil;

public class CafteriaHomepage {

	WebDriver driver;
	public ClickActionHelpers click;
	public WaitUtil wait;
	public WebActionHelpers action;
	public ValidationActionHelpers valid;

	public CafteriaHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		click = new ClickActionHelpers();
		wait = new WaitUtil(driver);
		action = new WebActionHelpers();
		valid = new ValidationActionHelpers();
	}

	@FindBy(xpath = "//img[@src='https://qalegend.com/restaurant/assets/img/logo.png']")
	WebElement homepagelogo;

	@FindBy(xpath = "//*[@class='hidden-xs']")
	WebElement adminName;

	@FindBy(xpath = "//img[@src='https://qalegend.com/restaurant/files/Avatars/9fff9cc26e539214e9a5fd3b6a10cde9.jpg']")
	WebElement adminimage;

	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/products']")
	public WebElement productlink;

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]/a")
	public WebElement categorylink;
	@FindBy(xpath = "//img[@src='https://qalegend.com/restaurant/assets/img/flags/en.png']")
	WebElement English;

	@FindBy(xpath = "//*[@class='fa fa-sign-out fa-lg']")
	WebElement logout;

	@FindBy(xpath = "//span[text()='POS']")
	WebElement menupos;

	@FindBy(xpath = "(//span[@class='menu-text'])[2]")
	WebElement menupro;

	@FindBy(xpath = "//span[text()='Stores']")
	WebElement menustore;

	@FindBy(xpath = "//span[text()='People']")
	WebElement menupeople;

	@FindBy(xpath = "//span[text()='Waiters']")
	WebElement submenuWaiter;

	@FindBy(xpath = "//span[text()='Customers']")
	WebElement submenuCust;

	@FindBy(xpath = "//span[text()='Suppliers']")
	WebElement submenuSupp;

	@FindBy(xpath = "//span[text()='Sales']")
	WebElement menusales;

	@FindBy(xpath = "//span[text()='Categories ']")
	WebElement menuCat;

	@FindBy(xpath = "(//span[@class='menu-text'])[11]")
	WebElement menusubpro;

	@FindBy(xpath = "(//span[@class='menu-text'])[12]")
	WebElement menusubexp;

	@FindBy(xpath = "//span[text()='Setting']")
	WebElement menuSett;

	@FindBy(xpath = "//span[text()='Reports']")
	WebElement menuRep;

	@FindBy(xpath = "//*[contains(text(),'Choose a store')]")
	WebElement chooseStore;

	@FindBy(xpath = "(/html/body/div[2]/div[2]/ul/a[1]/li/div[2]/span[1]")
	WebElement store1;

	@FindBy(xpath = "(/html/body/div[2]/div[2]/ul/a[2]/li/div[2]/span[1]")
	WebElement store2;

	@FindBy(xpath = "/html/body/div[2]/div[2]/ul/a[3]/li/div[2]/span[1]")
	WebElement store3;

	

	public AddProduct productclick() throws Exception {
		productlink.click();
		return new AddProduct(driver);
	}

	public AddCategory categoryclick() {
		categorylink.click();
		return new AddCategory(driver);
	}

	public boolean isLogovisible() {
		return homepagelogo.isDisplayed();
	}

	public String getAdminName() {
		return adminName.getText();

	}

	public boolean getAdminImage() throws Exception {
		return adminimage.isDisplayed();

	}

	public void clickLogoutButton() throws Exception {
		logout.click();

	}

	public Boolean isPosDisplayed() throws Exception {
		return valid.isElementVisible(driver, menupos);
	}

	public Boolean isProductDisplayed() throws Exception {
		return valid.isElementVisible(driver, menupro);
	}

	public Boolean isStoreDisplayed() throws Exception {
		return valid.isElementVisible(driver, menustore);
	}

	public Boolean isPeopleDisplayed() throws Exception {
		return valid.isElementVisible(driver, menupeople);
	}

	public Boolean isSaleDisplayed() throws Exception {
		return valid.isElementVisible(driver, menusales);
	}

	public Boolean isSettingsDisplayed() throws Exception {
		return valid.isElementVisible(driver, menuSett);
	}

	public Boolean isReportsDisplayed() throws Exception {
		return valid.isElementVisible(driver, menuRep);
	}

	public void isHomepageSubmenuDisplayed() throws Exception {
		valid.isElementVisible(driver, submenuWaiter);
		valid.isElementVisible(driver, submenuCust);
		valid.isElementVisible(driver, submenuSupp);
		valid.isElementVisible(driver, menusubpro);
		valid.isElementVisible(driver, menusubexp);
	}

	public String getHeadingTitle() {
		return chooseStore.getText();
	}

	public boolean getStoreName1() throws Exception {
		return valid.isElementVisible(driver, store1);
	}

	public boolean getStoreName2() throws Exception {
		return valid.isElementVisible(driver, store2);
	}

	public boolean getStoreName3() throws Exception {
		return valid.isElementVisible(driver, store3);
	}

	
	
	
	

}
