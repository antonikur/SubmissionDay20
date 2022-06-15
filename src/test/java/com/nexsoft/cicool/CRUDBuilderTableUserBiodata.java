package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRUDBuilderTableUserBiodata {
	protected WebDriver driver;
	
	@FindBy(xpath = "//a[@id='btn_add_new']")
	private WebElement btnAddUserBiodataNew;
	
	public CRUDBuilderTableUserBiodata (WebDriver driver){
		this.driver = driver;
	}
	
	public TableUserBiodataNew clickTableUserBiodataNew() {
		btnAddUserBiodataNew.click();
		return PageFactory.initElements(driver, TableUserBiodataNew.class);
	}
	
}
