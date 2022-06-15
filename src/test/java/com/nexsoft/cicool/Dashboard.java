package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	protected WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	private WebElement dashboardMenu;
	
	@FindBy(xpath = "//span[normalize-space()='CRUD Builder']")
	private WebElement crudBuilderMenu;
	
	@FindBy(xpath = "//span[normalize-space()='API Builder']")
	private WebElement apiBuilderMenu;
	
	@FindBy(xpath = "//span[normalize-space()='Page Builder']")
	private WebElement pageBuilderMenu;
	
	@FindBy(xpath = "//span[normalize-space()='Page Builder']")
	private WebElement formBuilderMenu;
	
	@FindBy(xpath = "//span[normalize-space()='Blog']")
	private WebElement blogMenu;
	
	@FindBy(xpath = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']")
	private WebElement userName;
	
	@FindBy(xpath = "//span[@class='hidden-xs']")
	private WebElement btnTopRight;
	
	@FindBy(xpath = "//a[normalize-space()='Exit']")
	private WebElement btnExit;
	
	public CRUDBuilder clickCrudBuilderMenu() {
		crudBuilderMenu.click();
		
		CRUDBuilder crudBuilder = PageFactory.initElements(driver, CRUDBuilder.class);
		
		return crudBuilder;
	}
	
	public String getUsernameAtTopRight() {
		return userName.getText();
	}
	
	public void clickButtonExit() {
		btnTopRight.click();
		btnExit.click();
	}
	
}
