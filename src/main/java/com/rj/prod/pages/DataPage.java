package com.rj.prod.pages;

import java.io.IOException;
import org.rj.repacked.selenium;
import com.rj.prod.base.TestBase;

public class DataPage extends TestBase {
	
	@FindBy(id="upload_data_btn")
	WebElement uploadDataButton;
	
	@FindBy(xpath="(//img[@alt='delete icon'])[1]")
	WebElement deleteButton;
	
	@FindBy(xpath="(//button[@type='button'])[8]")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@id='dropdownMenu5']")
	WebElement browseButton;
	
	//Initializing the Page Objects
	public DataPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyValidationMessage(String dropdownMenu1) {
		Select selectDropdown = new Select(driver.findElement(By.id("dropdownMenu1")));
		selectDropdown.selectByVisibleText(dropdownMenu1);
		uploadDataButton.click();
	}
	public void uploadFile() throws IOException, Exception {
		
		browseButton.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("\\\prodtestserv01\\AutoTest\\Newfile.exe");
		Thread.sleep(3000);
		uploadDataButton.click();
		Thread.sleep(5000);
	}
	

}