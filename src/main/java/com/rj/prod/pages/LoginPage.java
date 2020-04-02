package com.rj.prod.pages;

import org.rj.repacked.selenium;
import com.rj.prod.base.TestBase;
import com.rj.prod.util.TestUtil;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	@FindBy(name="user_loginid")
	WebElement user_loginid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='raymond james logo']")
	WebElement rjLogo;
	
	//we have to initialize all the above object repositories : will create the constructor of the class "LoginPage"
	public LoginPage() {
		
		PageFactory.initElements(driver, this); //this means current class object
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validaterjImage() {
		return rjLogo.isDisplayed();
	}
	public HomePage login(String un,String pwd) {
		try {
		user_loginid.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(3000);
		//TestUtil.takeScreenshot(driver,TestUtil.PROJECT_NAME);
		return new HomePage();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void validateuserlogin() {
		
	}
	
	
	
	
	
	
	
	
	
	

}
