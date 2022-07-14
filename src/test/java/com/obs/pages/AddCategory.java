package com.obs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obs.actions.ClickActionHelpers;
import com.obs.utils.WaitUtil;

public class AddCategory {
	WebDriver driver;
	WaitUtil wait=new WaitUtil(driver);
	ClickActionHelpers click=new ClickActionHelpers();
	public AddCategory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]/a")
	public WebElement menu;
	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]/a")
	public WebElement categorylink;
	@FindBy(xpath = "/html/body/div[2]/button")
	public WebElement button;
	
	
	

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]")
	public WebElement manageExpenseMenu;

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[7]/ul/li[1]")
	public WebElement expenseCategorySubmenu;
	
	@FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[7]/ul")
	public WebElement combo;

	@FindBy(xpath = "//h1[text() = \"Expense Category\"]")
	public WebElement expenseCategoryHeader;

	@FindBy(xpath = "/html/body/div[2]/button")
	public WebElement expenseCategoryNewButton;

	

	public void clickManageExpenseMenu() throws Exception {
	click.click(menu);
	Thread.sleep(2000);
	 expenseCategorySubmenu.click();
	}

	public void clickExpenseCategorySubMenu() throws Exception {
		//Select s=new Select(menu);
		//s.selectByIndex(1);
		 expenseCategorySubmenu.click();
		
	}

	public void addNewCategory() throws Exception {
		click.click(expenseCategoryNewButton);
		//elementutil.sendKeys(expenseCategoryTitle, categoryTitle);
		//elementutil.click(expenseCategorySave);
	}

	public Object isSubmenuVisble() {
		// TODO Auto-generated method stub
		return expenseCategorySubmenu.isDisplayed();
	}
}
