package com.rj.prod.pages;

import java.util.ArrayList;

import org.rj.repacked.selenium;
import org.testng.Assert;

import com.rj.prod.base.TestBase;
import com.rj.prod.util.TestUtil;

public class TransporterPage extends TestBase{
	@FindBy(xpath = ".//*[@id='transporter_updatevehicle']/span/span")
	WebElement updatevehicle;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[1]/button")
	WebElement transMode;
	@FindBy(xpath = "//*[@id=\"vehicle_typeOverDim\"]")
	WebElement vehicleType;
	@FindBy(name = "from_place")
	WebElement vehPlace;

	@FindBy(xpath = "//*[@id=\"ddlState\"]")
	WebElement vehState;

	// update-reason
	@FindBy(xpath = "//*[@id=\"ddlReason\"]")
	WebElement updateReason;

	@FindBy(xpath = "//*[@id=\"btnVehicleUpdateSubmit\"]")
	WebElement update_submit;
	
	@FindBy(xpath = ".//*[@id='refereshtable']")
	WebElement refreshButton;
	
	@FindBy(xpath = "/html/body/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/button")
	WebElement move_status;

	@FindBy(id = "txtplace")
	WebElement txtplace;

	@FindBy(id = "txtremarks")
	WebElement txtremarks;

	@FindBy(xpath = "//*[@id=\"btnsubmitupdatemovement\"]")
	WebElement updateMovementButton;
	
	// //*[@id="transporter_updatemovement"]
	@FindBy(xpath = "//*[@id=\"transporter_updatemovement\"]")
	WebElement updateMovement;
	@FindBy(id = ".//*[@id='idlogout']")
	WebElement logOut;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button[2]")
	WebElement logoutYes;
	
	@FindBy(linkText = "Yes")
	WebElement logoutConfirm;
	
	public void updateVehicle(){
		System.out.println("This is the test");	
	}
	public void UpdateVehicleTransporter() {
		System.out.println("entered");
		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		ArrayList<String> tmpList = new ArrayList<String>();
		try {
			System.out.println("entered2");
			for (int i = 1; i < 21; i++) {
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				System.out.println("entered3");
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("141001196810")) {
				
				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();

				//updatevehicle.click();
				driver.findElement(By.xpath(".//*[@id='transporter_updatevehicle']/span/span")).click();
				Thread.sleep(3000);
				System.out.println("entered4");
				driver.findElement(By.xpath(".//*[@id='excludePopup2']/div[1]/div[2]/div[1]/button")).click();
				//transMode.click();
				Thread.sleep(10000);
				//vehicleType.click();
				driver.findElement(By.xpath(".//*[@id='vehicle_typeOverDim']")).click();
				//vehPlace.clear();
				driver.findElement(By.xpath(".//*[@id='from_place']")).clear();
				driver.findElement(By.xpath(".//*[@id='from_place']")).sendKeys("Trivandrum");
				//vehPlace.sendKeys("Trivandrum");
				Select sel1 = new Select(driver.findElement(By.xpath(".//*[@id='ddlState']")));
				sel1.selectByValue("32");
				Select sel2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlReason']")));
				sel2.selectByValue("1");
				//update_submit.click();
				driver.findElement(By.xpath(".//*[@id='btnVehicleUpdateSubmit']")).click();
				Thread.sleep(10000);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				driver.navigate().refresh();
				System.out.println("close");
				tmpList.add(name);
				System.out.println("Arralist value is:" + tmpList.toString());
				Thread.sleep(3000);
				String status1 = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]")).getText();
				System.out.println(status1);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				if (status1.equals("Sent For vehicle update")) {
					for (int j = 0; j < 30; j++) {
						//refreshButton.click();
						driver.findElement(By.xpath(".//*[@id='refereshtable']")).click();
						System.out.println("Count" + j);
						 String stat2 = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
	                                .getText();
	                        System.out.println(stat2);
	                    if (!stat2.equals("Sent For vehicle update")) {
	                        break;
	                    }
					}
					String status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
							.getText();
					System.out.println(status);
					TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
					Assert.assertEquals(status,"Vehicle Updated");
					if (status.equals("Vehicle Updated")) {
						System.out.println("status====success==Vehicle Updated");
					} else {
						System.out.println("failed");
					}
				}
				break;
				 }
			}
		} catch (Exception e) {
		}

	}
	public void UpdateMovementTransporter() {
		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		try {
			ArrayList<String> tmpList = new ArrayList<String>();
			for (int i = 1; i < 21; i++) {
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("181001196304")) {
				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();
				//updateMovement.click();
				driver.findElement(By.xpath(".//*[@id='transporter_updatemovement']/span/span")).click();
				
				
				Thread.sleep(3000);
				
				//move_status.click();
				//driver.findElement(By.xpath("")).click();
				driver.findElement(By.xpath(".//*[@id='excludePopup']/div[1]/div/div[1]/button")).click();
				Thread.sleep(10000);
				//txtplace.clear();
				driver.findElement(By.xpath(".//*[@id='txtplace']")).clear();
				//txtplace.sendKeys("Trivandrum");
				driver.findElement(By.xpath(".//*[@id='txtplace']")).sendKeys("Kochi");
				//txtremarks.clear();
				driver.findElement(By.xpath(".//*[@id='txtremarks']")).clear();
				//
				driver.findElement(By.xpath(".//*[@id='txtremarks']")).sendKeys("Not yet started");
				//txtremarks.sendKeys("not yet started");
				//updateMovementButton.click();
				driver.findElement(By.xpath(".//*[@id='btnsubmitupdatemovement']")).click();
				Thread.sleep(3000);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				driver.navigate().refresh();
				System.out.println("Completed update remarks");
				tmpList.add(name);
				System.out.println("Arralist value is:" + tmpList.toString());
				Thread.sleep(3000);
				String status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]")).getText();
				System.out.println(status);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				Assert.assertEquals(status,"Generated");
				if (status.equals("Generated")) {
					System.out.println("status====success==Updated Movement");
				} else {
					System.out.println("failed");
					
				}
				break;
				 }
			}
		} catch (Exception c) {
		}
	}
	public void Test_test() {
		
		System.out.println("method 1");
		try {
		
		//driver.findElement(By.xpath(".//*[@id='transporter_updatevehicle']/span/span")).click();
		updatevehicle.click();
		Thread.sleep(3000);
	}catch (Exception e) {
		// TODO: handle exception
	}
		
		}
	



}
