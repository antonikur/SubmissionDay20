package com.nexsoft.cicool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRUDBuilder {
	protected WebDriver driver;
	
//	@FindBy(xpath = "//a[@id='btn_add_new']")
//	private WebElement btnAddCrudNew;
//	
//	@FindBy(xpath = "//tbody/tr[3]/td[5]/a[1]")
//	private WebElement btnSeeUserBiodata;
	
	@FindBy(xpath = "//tbody[@id='tbody_crud']/tr")
	List<WebElement> lstTable;
	
	public CRUDBuilder (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSeeButtonWithTitle(String title) {
		WebElement see = null;
		int counter = 1;
		
		for (WebElement webElement : lstTable) {
			see = driver.findElement(By.xpath("//tbody[@id='tbody_crud']/tr["+ counter +"]/td/a[1]"));
			WebElement teks = webElement.findElement(By.xpath("//tbody[@id='tbody_crud']/tr["+ counter++ +"]//td[2]"));
			
			System.out.println("Teks Get: "+teks.getText());
			if(teks.getText().equalsIgnoreCase(title)) {
				see.click();
				break;
			}
		}
		
	}
	
//	public CRUDBuilderAddNewCrud clickAddCrudNew() {
//		btnAddCrudNew.click();
//		
//		CRUDBuilderAddNewCrud crudBuilderAddNewCrud = PageFactory.initElements(driver, CRUDBuilderAddNewCrud.class);
//		
//		return crudBuilderAddNewCrud;
//	}
//	
//	public CRUDBuilderTableUserBiodata clickSeeTableUserBiodata() {
//		btnSeeUserBiodata.click();
//		
//		CRUDBuilderTableUserBiodata crudBuilderTableUserBiodata = PageFactory.initElements(driver, CRUDBuilderTableUserBiodata.class);
//				
//		return crudBuilderTableUserBiodata;
//	}
}
