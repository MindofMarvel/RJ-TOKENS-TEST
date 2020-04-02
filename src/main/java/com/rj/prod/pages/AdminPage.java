package com.rj.prod.pages;
import org.rj.repacked.selenium;

public class AdminPage extends TestBase {
	
	@FindBy(id="addnew")
	WebElement addNewButton;
	
	@FindBy(id="company_pan")
	WebElement companyPAN;
	
	@FindBy(id="company_name")
	WebElement companyName;
	
	@FindBy(id="btn_save")
	WebElement saveButton;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement closeMessage;
	
	@FindBy(id="bu")
	WebElement businessUnit;
	
	@FindBy(id="sbu_name")
	WebElement subBusinessUnit;
	
	@FindBy(id="address1")
	WebElement addressNo1;
	
	@FindBy(id="location_code")
	WebElement locationCode;
	
	@FindBy(id="address2")
	WebElement addressNo2;
	
	@FindBy(id="place")
	WebElement placeNew;
	
	@FindBy(id="location_name")
	WebElement locationName;
	
	@FindBy(id="pin_code")
	WebElement pinCode;

	//Initializing the Page Objects
		public AdminPage() {
			PageFactory.initElements(driver, this);
		}
	
	public void addNewCompany(String comppan, String compname) {
		addNewButton.click();
		companyPAN.sendKeys(comppan);
		companyName.sendKeys(compname);
		saveButton.click();
		closeMessage.click();
	}
	public void addNewBusinessUnit(String ddlComapnyList,String bunit) {
		addNewButton.click();
		Select selectDropdown = new Select(driver.findElement(By.id("ddlComapnyList")));
		selectDropdown.selectByVisibleText(ddlComapnyList);
		businessUnit.sendKeys(bunit);
		saveButton.click();
		closeMessage.click();
	}
	public void addNewSubBusinessUnit(String companyName,String businessUnit,String subBusinessUnitName) {
		addNewButton.click();
		Select selectDropdown1 = new Select(driver.findElement(By.id("ddlComapnyList")));
		selectDropdown1.selectByVisibleText(companyName);
		Select selectDropdown = new Select(driver.findElement(By.id("ddlBusinessUnit")));
		selectDropdown.selectByVisibleText(businessUnit);
		subBusinessUnit.sendKeys(subBusinessUnitName);
		saveButton.click();
		closeMessage.click();
	}
	public void addNewLocation(String companyName,String addressNew1,String locatCode,String addressNew2,
			String locationCategory,String placenew,String locatName,String pinCod,
			String stateNew) {
		
		addNewButton.click();
		Select selectDropdown = new Select(driver.findElement(By.id("ddlComapnyList")));
		selectDropdown.selectByVisibleText(companyName); 
		
		addressNo1.sendKeys(addressNew1);
		locationCode.sendKeys(locatCode);
		addressNo2.sendKeys(addressNew2);
		
		Select selectDropdown1 = new Select(driver.findElement(By.id("DDLLocationCat")));
		selectDropdown1.selectByVisibleText(locationCategory);
		
		placeNew.sendKeys(placenew);
		
		locationName.sendKeys(locatName);
		pinCode.sendKeys(pinCod);
		
		Select selectDropdown2 = new Select(driver.findElement(By.id("ddlState")));
		selectDropdown2.selectByVisibleText(stateNew);
		
		saveButton.click();
		closeMessage.click();
	}
	

}