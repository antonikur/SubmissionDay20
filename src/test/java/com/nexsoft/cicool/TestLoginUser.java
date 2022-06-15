package com.nexsoft.cicool;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginUser {
	protected WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool");
		System.setProperty("webdriver.chrome.driver", "C:\\Antoni\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
	}
	
  @Test(enabled = false)
  public void login() {	
//	  //not using factory initialize is like this
//	  HomePage home = new HomePage(driver);
	  
	  //using factory need to initialize page factory
	  HomePage home = PageFactory.initElements(driver, HomePage.class);
	  //===================================================================
	  
//	  SignInPage formSignIn = home.clickSignIn();
//	  
//	  Dashboard dashboard = formSignIn.loginValidUser("antoni.nexsoft@gmail.com", "antoni2000");
//	  
//	  CRUDBuilder crudBuilder = dashboard.clickCrudBuilderMenu();
//	  
//	  CRUDBuilderTableUserBiodata crudBuilderTableUserBiodata = crudBuilder.clickSeeTableUserBiodata();
//	  
//	  TableUserBiodataNew tableUserBiodataNew = crudBuilderTableUserBiodata.clickTableUserBiodataNew();
//	  
//	  tableUserBiodataNew.inputDataTableAndSaveGotoList("Antoni", "Kurniawan", "Jakarta", "Male", "C:\\Antoni\\selenium\\profile.jpg");
//	  
//	  crudBuilderTableUserBiodata.clickTableUserBiodataNew();
//	  
//	  tableUserBiodataNew.inputDataTableAndSaveGotoList("Inotna", "Nawainruk", "Meikarta", "Female", "C:\\Antoni\\selenium\\profile.jpg");
	  
	  //================================================================
	  home.clickSignIn().loginValidUser("antoni.nexsoft@gmail.com", "antoni2000").clickCrudBuilderMenu().clickSeeButtonWithTitle("Userbiodata");
  }
  
  @Test(priority = 0)
  public void loginValid() {
	  Dashboard dashboard = PageFactory.initElements(driver, HomePage.class).clickSignIn().loginValidUser("antoni.nexsoft@gmail.com", "antoni2000");
	  String username = dashboard.getUsernameAtTopRight();
	  dashboard.clickButtonExit();
	  assertEquals(username, "Antoninexsoft");
  }
  
  @Test(priority = 1)
  public void emailValidPasswordError() {
	  String pesanError = PageFactory.initElements(driver, HomePage.class).clickSignIn().loginInvalid("antoni.nexsoft@gmail.com", "12345");
	  assertEquals(pesanError, "E-mail, Username or Password do not match.");
  
  }
  
  @Test(priority = 2)
  public void emailErrorPasswordError() {
	  String pesanError = PageFactory.initElements(driver, HomePage.class).clickSignIn().loginInvalid("antoni.nex@gmail.com", "12345");
	  assertEquals(pesanError, "User does not exist");
  }
  
  @Test(priority = 3)
  public void emailKosongPasswordKosong() {
	  String pesanError = PageFactory.initElements(driver, HomePage.class).clickSignIn().emailPasswordKosong();
	  assertEquals(pesanError, "The Username field is required.The Password field is required.");
  }
  @Test(priority = 4)
  public void masukHalamanLupaPassword() {
	  String pesanError = PageFactory.initElements(driver, HomePage.class).clickSignIn().lupaPassword().inputEmailCaptchaAndClickResetToSeeError("antoni.nexsoft@gmail.com", "abcd");
	  
	  assertEquals(pesanError, "You must submit Captcha word that appears in the image.");
  }
  
}
