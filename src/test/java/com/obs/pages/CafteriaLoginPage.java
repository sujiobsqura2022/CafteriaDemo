package com.obs.pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obs.actions.ClickActionHelpers;
import com.obs.actions.SendKeysActionHelpers;
import com.obs.datahandler.PropertyDataHandler;
import com.obs.utils.WaitUtil;

public class CafteriaLoginPage {
	PropertyDataHandler prop;
	WebDriver driver;
	public SendKeysActionHelpers send = new SendKeysActionHelpers();
	public ClickActionHelpers click = new ClickActionHelpers();
	public WaitUtil wait = new WaitUtil(driver);

	public CafteriaLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = new PropertyDataHandler();
	}

	// exmaple of encapsulation,these datamembers cannot accessed by other pom
	// class..so we use getter and setter method to access
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usname;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pawd;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement loginb;

	@FindBy(xpath = "//div[@class='login-help']")
	private WebElement Cname;
	//all the locators are example for abstraction...locators are hide in test classes
	@FindBy(xpath = "//img[@src='https://qalegend.com/restaurant/assets/img/logo.png']")
	private WebElement adminlogo;

	public String getCurrentPageUrl() throws IOException {
		Properties allProp = prop.readPropertiesFile("config.properties");
		return allProp.getProperty("url");
	}

	public String getCurrentPageTitle() throws IOException {
		Properties allProp = prop.readPropertiesFile("config.properties");
		return allProp.getProperty("title");
	}

	public boolean isLoginfieldsdisplayed() {
		return usname.isDisplayed();
	}

	public boolean isPasswordfieldsdisplayed() {
		return pawd.isDisplayed();
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();// always use string for getTitle
	}

	public void typeUsername(String email) {
		usname.sendKeys(email);
	}

	public void typePassword(String pwd) {
		pawd.sendKeys(pwd);
	}

	public void clickLogin() {
		loginb.click();
	}

	public String getCafteriaName() {
		return Cname.getText();
	}

	public CafteriaHomepage login(String un, String pwd) {
		usname.sendKeys(un);
		pawd.sendKeys(pwd);
		loginb.click();
		return new CafteriaHomepage(driver);// login page lands to homepage, so use return method
	}

	public boolean islogopresent() {
		// TODO Auto-generated method stub
		return adminlogo.isDisplayed();
	}

}
