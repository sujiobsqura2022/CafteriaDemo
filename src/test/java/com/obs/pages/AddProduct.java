package com.obs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obs.actions.ClickActionHelpers;
import com.obs.actions.SendKeysActionHelpers;
import com.obs.actions.ValidationActionHelpers;
import com.obs.actions.WebActionHelpers;
import com.obs.utils.WaitUtil;

public class AddProduct {
	WebDriver driver;
	public WaitUtil wait;
	public ClickActionHelpers click;
	public SendKeysActionHelpers send;
	public WebActionHelpers action;
	public ValidationActionHelpers valid;

	public AddProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		click = new ClickActionHelpers();
		valid = new ValidationActionHelpers();
		wait = new WaitUtil(driver);
		send = new SendKeysActionHelpers();
	}

	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/products']")
	public WebElement menu;

	@FindBy(xpath = "//button[contains(text(),'Add Product') and @data-target='#Addproduct']")
	public WebElement addproductbutton;

	@FindBy(xpath = "//*[@id='Type' and @name='type']")
	public WebElement ptype;

	@FindBy(xpath = "//input[@id='ProductCode']")
	public WebElement pcode;

	@FindBy(xpath = "//input[@id='ProductName']")
	public WebElement pname;

	@FindBy(xpath = "//*[@id='Category']")
	public WebElement pcategory;

	@FindBy(xpath = "//*[@id=\"Price\"]")
	public WebElement pprice;

	@FindBy(xpath = "//input[@id='Unit']")
	public WebElement punit;

	@FindBy(xpath = "//input[@id='AlertQt']")
	public WebElement palertqt;

	@FindBy(xpath = "//*[@id='ProductOptions']")
	public WebElement poptions;

	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement ppanelbody;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement search;

	@FindBy(xpath = "//select[@class='form-control input-sm']")
	// @FindBy(xpath = "//*[@id=\"Table_length\"]/label/select")
	public WebElement showentries;

	@FindBy(xpath = "//form//button[@type='submit' and @class='btn btn-default']")
	public WebElement filterbutton;

	@FindBy(xpath = "//select[@id='Supplier' and @class='form-control' and @name='filtersupp']")
	public WebElement suppliercombo;

	@FindBy(xpath = "//select[@id='Producttype' and @class='form-control' and @name='filtertype']")
	public WebElement productcombo;

	@FindBy(xpath = "//a[@class='btn btn-default']")
	private WebElement delete;

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]/a")
	public WebElement categorylink;

	@FindBy(xpath = "//td[contains(.,'No matching records found')]")
	public WebElement invalidsearch;

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement successalert;

	@FindBy(xpath = "/html/body/div[4]/div/div/form/div[2]/button[2]")
	public WebElement submit;

	@FindBy(xpath = "@FindBy(xpath = \"//input[@id='Tax']")
	public WebElement ptax;

	@FindBy(xpath = "//select[@id='taxType']")
	public WebElement ptaxtype;

	@FindBy(xpath = "//a[text()='Download CSV']")
	public WebElement downloadcsv;

	@FindBy(xpath = "//a[text()='PrintMenu']")
	public WebElement print;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[3]/button[1]")
	public WebElement printclose;

	@FindBy(id = "ImageInput")
	public WebElement browseimage;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/table/tbody/tr/td[7]/div/a[3]/i")
	public WebElement edit;
	
	@FindBy(xpath = "//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	public WebElement editsubmit;
	
	@FindBy(xpath = "//*[@class='fa fa-sign-out fa-lg']")
	WebElement logout;

	public void searchValidProduct(String text) {
		search.clear();
		send.clearAndsendkeys(search, text);
	}

	public void searchinvalidProduct(String text) {
		search.clear();
		send.clearAndsendkeys(search, text);
	}

	public void getApplyfilter() throws Exception {
		Select combo1 = new Select(suppliercombo);
		combo1.selectByIndex(0);
		Select combo2 = new Select(productcombo);
		combo2.selectByIndex(0);
		wait.waitforElementClick(filterbutton);
		click.click(filterbutton);

	}

	public void displayentries() {
		menu.click();
		Select combo1 = new Select(showentries);
		combo1.selectByIndex(1);
		filterbutton.click();
	}

	public void deleteelement() {
		delete.click();
	}

	public void deleteelement1(String code, WebDriver driver) {
		WebElement elementcode = driver.findElement(
				By.xpath("//td[text()='" + code + "']/following::td[6]/descendant::i[@class='fa fa-times']"));
		elementcode.click();
		WebElement delete = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/table/tbody/tr[3]/td[7]/div/div/div[2]/a"));
		delete.click();
	}

	public void viewProduct(String code1, WebDriver driver) {
		WebElement viewcode = driver.findElement(By.xpath("//*[@id=\"Table\"]/tbody/tr/td[7]/div/a[2]/i"));
		viewcode.click();
		wait.implicitWait();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"viewModal\"]/div/div[3]/button"));
		close.click();
	}

	public void veriftEditbutton() {
		edit.click();
		pprice.clear();
		send.clearAndsendkeys(pprice, "15");
		editsubmit.click();
		
		
	}

	public void verifyAddproductbutton() {
		addproductbutton.click();
	}

	public void verifyAddprouct() {
		Select combo1 = new Select(ptype);
		combo1.selectByIndex(1);
		wait.waitforElementVisible(pcode);
		send.clearAndsendkeys(pcode, "3012");
		send.clearAndsendkeys(pname, "madeena");
		Select combo2 = new Select(pcategory);
		combo2.selectByIndex(1);
		Select combo3 = new Select(suppliercombo);
		combo3.selectByIndex(1);
		send.clearAndsendkeys(ptax, "2");
		Select combo4 = new Select(ptaxtype);
		combo4.selectByIndex(1);
		// wait.waitforElementVisible(pprice);
		send.clearAndsendkeys(pprice, "40");
		send.clearAndsendkeys(punit, "10");
		send.clearAndsendkeys(palertqt, "5");
		send.clearAndsendkeys(ppanelbody, "nice Product");
		submit.click();
	}

	public void upload() {
		// browseimage.click();
		// String filepath="E:\\POSDEMO\\image";
		// WebElement choosefile=driver.findElement(By.id("ImageInput"));
		// wait.implicitWait();
		// send.sendkeys(browseimage, filepath);
		// sendKeys(filepath);
	}

	public void verifydownloadcsvbutton() {
		downloadcsv.click();

	}

	public void verifyprintbutton() {
		print.click();
		wait.waitforElementVisible(printclose);
		printclose.click();
	}
	public void clickLogoutButton() throws Exception {
		logout.click();
	}

	public boolean iscodevisible() throws Exception {
		return valid.isElementVisible(driver, pcode);
	}

	public boolean isproductnamevisible() throws Exception {
		return valid.isElementVisible(driver, pname);
	}

	public boolean ispcategoryvisible() throws Exception {
		return valid.isElementVisible(driver, pcategory);
	}

	public boolean ispricevisible() throws Exception {
		return pprice.isDisplayed();
	}

	public boolean ispunitvisible() throws Exception {
		return valid.isElementVisible(driver, punit);
	}

	public boolean isalertqtyvisible() throws Exception {
		return valid.isElementVisible(driver, palertqt);
	}

	public void viewelement(String code, WebDriver driver) {
	}

	public boolean isNoResultMessageDisplayed() {

		return false;
	}

	public boolean iserrorMessageDisplayed() {

		return invalidsearch.isDisplayed();
	}

	public boolean isResultMessageDisplayed() {
		return true;

	}

	public boolean isSuccessAlertDisplayed() {
		return successalert.isDisplayed();
	}

	public AddCategory categoryclick() {
		categorylink.click();
		return new AddCategory(driver);
	}

	public Object isSubmenuVisble() {
		// TODO Auto-generated method stub
		return addproductbutton.isDisplayed();
	}
}
