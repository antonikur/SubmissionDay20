package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	protected WebDriver driver;
	
	//this is must have
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
//	//object element in page browser (tanpa Factory)
//	private By signIn = By.cssSelector(".fa.fa-sign-in");
//	private By languageString = By.xpath("//a[@class='dropdown-toggle']");
	
//	//not using factory
//	public SignInPage clickSignIn() {
//		driver.findElement(signIn).click();
//		
//		return new SignInPage(driver);
//	}
	
	
	//dengan Factory (dari org.openqa.selenium.supoort.Findby)
	@FindBy(css = ".fa.fa-sign-in")
	private WebElement signIn;
	
	@FindBy(css = "//a[@class='dropdown-toggle']")
	private WebElement languageString;
	

	
	//using factory
	public SignInPage clickSignIn() {
		signIn.click();
		
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		
		return signInPage;
	}
}
