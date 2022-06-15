package com.nexsoft.cicool;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableUserBiodataNew {

	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement fieldFirstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement fieldLastName;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement fieldEmail;
	
	@FindBy(xpath = "//input[@id='gender']")
	private WebElement fieldGender;
	
	@FindBy(xpath = "//input[@title='file input']")
	private WebElement fieldPhoto;
	
	public TableUserBiodataNew (WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputDataTableAndSaveGotoList(String firstName, String lastName, String email, String gender, String photo) {
		//input data ke field
		fieldPhoto.sendKeys(photo);
		fieldFirstName.sendKeys(firstName);
		fieldLastName.sendKeys(lastName);
		fieldEmail.sendKeys(email);
		fieldGender.sendKeys(gender);
		
		
		//save with ctrl + d
		String kbType = Keys.chord(Keys.CONTROL, "d");
		fieldGender.sendKeys(kbType);
		
		//karena terlalu cepat jadi di wait dulu
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
