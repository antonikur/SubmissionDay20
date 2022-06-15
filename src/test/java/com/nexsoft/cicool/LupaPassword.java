package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LupaPassword {

	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement fieldEmail;
	
	@FindBy(xpath = "//input[@name='captcha']")
	private WebElement fieldCaptcha;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnReset;
	
	@FindBy(xpath = "//p[contains(text(),'You must submit Captcha word that appears in the')]")
	private WebElement pesanError;
	
	public LupaPassword (WebDriver driver) {
		this.driver = driver;
	}
	
	public String inputEmailCaptchaAndClickResetToSeeError(String email, String captcha) {
		fieldEmail.sendKeys(email);
		fieldCaptcha.sendKeys(captcha);
		btnReset.click();
		
		return pesanError.getText();
	}
	
	
	
}
