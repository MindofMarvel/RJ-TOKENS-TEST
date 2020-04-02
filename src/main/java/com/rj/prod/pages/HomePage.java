package com.rj.prod.pages;

import java.util.concurrent.TimeUnit;

import org.rj.repacked.selenium;
import com.rj.prod.base.TestBase;
import com.rj.prod.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(id = "idlogout")
	WebElement logOut;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button[2]")
	WebElement logoutYes;
	
	@FindBy(linkText = "Yes")
	WebElement logoutConfirm;

	@FindBy(xpath = "//a[text()='user']")
	WebElement userNameLabel;

	@FindBy(xpath = "(//a[contains(text(),'Token')])[2]")
	WebElement TokenLink;

	@FindBy(linkText = "Generate")
	WebElement GenerateLink;

	@FindBy(xpath = "(//a[contains(text(),'Data')])[2]")
	WebElement dataLink;

	@FindBy(xpath = "(//li[2]/ul/li/a/span)[1]")
	WebElement dataUploadLink;

	@FindBy(xpath = "(//a[contains(text(),'Report')])[2]")
	WebElement reportLink;

	@FindBy(xpath = "(//a[contains(text(),'Dashboard')])[2]")
	WebElement dashboardLink;

	@FindBy(xpath = "(//a[contains(text(),'Admin')])[2]")
	WebElement adminLink;

	@FindBy(linkText = "Company Setup")
	WebElement companySetupLink;

	@FindBy(xpath = "//a[contains(text(),'Company')]")
	WebElement companyLink;
	
	@FindBy(xpath="(//a[contains(text(),'Business Unit')])[1]")
	WebElement businessUnitLink;
	
	@FindBy(xpath="//a[contains(text(),'Sub Business Unit')]")
	WebElement subBusinessUnitLink;
	
	@FindBy(xpath="(//a[contains(text(),'Location')])[1]")
	WebElement locationLink;

	@FindBy(xpath = "//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/ul/li[7]/a/span")
	WebElement allTokenLink;

	// Initializing the page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public TokenPage clickOnTokenLink() {
		TokenLink.click();
		return new TokenPage();
	}

	public DataPage clickOnDataLink() {
		dataLink.click();
		return new DataPage();
	}

	public ReportPage clickOnReportLink() {
		reportLink.click();
		return new ReportPage();
	}

	public DashboardPage clickOnDashboardLink() {
		dashboardLink.click();
		return new DashboardPage();
	}

	public AdminPage clickOnAdminLink() {
		adminLink.click();
		return new AdminPage();
	}

	public void clickOnDataUploadLink() {
		Actions action = new Actions(driver);
		action.moveToElement(dataLink).build().perform();
		dataUploadLink.click();
	}

	public void clickOnCompanyLink() {
		Actions action = new Actions(driver);
		action.moveToElement(companySetupLink).moveToElement(companyLink).build().perform();
		companyLink.click();
	}
	
	public void clickOnBusinessUnitLink() {
		Actions action = new Actions(driver);
		action.moveToElement(companySetupLink).moveToElement(businessUnitLink).build().perform();
		businessUnitLink.click();
	}
	public void clickOnSubBusinessUnitLink() {
		Actions action = new Actions(driver);
		action.moveToElement(companySetupLink).moveToElement(subBusinessUnitLink).build().perform();
		subBusinessUnitLink.click();
	}
	public void clickOnLocationLink() {
		Actions action = new Actions(driver);
		action.moveToElement(companySetupLink).moveToElement(locationLink).build().perform();
		locationLink.click();
	}

	public void clickonGenerateLink() {
		Actions action = new Actions(driver);
		action.moveToElement(GenerateLink).build().perform();
		GenerateLink.click();
	}

	public void clickOnAllTokenLink() {
		Actions action = new Actions(driver);
		action.moveToElement(allTokenLink).build().perform();
		allTokenLink.click();
	}

	public void clickOnLogout() {
		//Actions action = new Actions(driver);
		logOut.click();
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//action.moveToElement(logoutConfirm).build().perform();
		logoutYes.click();
	}

}