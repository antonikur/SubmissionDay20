package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	protected WebDriver driver;
	
	//this is must have
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	//object element in page browser (tanpa Factory)
//	private By email = By.cssSelector("input[placeholder='Email']");
//	private By password = By.cssSelector("input[placeholder='Password']");
//	private By btnSubmit = By.cssSelector("button[type='submit']");
	
//	//not using factory
//	public Dashboard loginValidUser(String username, String user_password) {
//		driver.findElement(email).clear();
//		driver.findElement(email).sendKeys(username);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(user_password);
//		driver.findElement(btnSubmit).click();
//		
//		return new Dashboard(driver);
//	}
	
	//dengan Factory (dari org.openqa.selenium.supoort.Findby)
	@FindBy(css = "input[placeholder='Email']")
	private WebElement email;
	
	@FindBy(css = "input[placeholder='Password']")
	private WebElement password;
	
	@FindBy(css = "button[type='submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/p")
	private WebElement pesanErrorPassword; 
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/p[2]")
	private WebElement pesanErrorUsernameKosong;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/p[3]")
	private WebElement pesanErrorPasswordKosong;
	
	@FindBy(xpath = "//a[normalize-space()='I forgot my password.']")
	private WebElement btnLupaPassword;
	
	//using factory
	public Dashboard loginValidUser(String username, String user_password) {
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSubmit.click();
		
		return PageFactory.initElements(driver, Dashboard.class);
	}	
	
	public String loginInvalid(String username, String user_password) {
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSubmit.click();
		
		return pesanErrorPassword.getText();
	}
	
	
	public String emailPasswordKosong() {
		email.clear();
		password.clear();
		btnSubmit.click();
		
		return pesanErrorUsernameKosong.getText()+pesanErrorPasswordKosong.getText();
	}
	
	public LupaPassword lupaPassword() {
		btnLupaPassword.click();
		return PageFactory.initElements(driver, LupaPassword.class);
	}
	
	
}
