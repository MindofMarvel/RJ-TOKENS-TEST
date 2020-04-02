package com.rj.prod.pages;

import java.util.ArrayList;
import org.rj.repacked.selenium;
import org.testng.Assert;

import com.rj.prod.base.TestBase;
import com.rj.prod.util.TestUtil;

public class TokenPage extends TestBase {
	@FindBy(xpath="//img[@alt='raymond james logo']")
	WebElement rjLogo;
	
	@FindBy(id = "btnapply")
	WebElement applyButton;

	@FindBy(xpath = "//*[@id=\\\"table1\\\"]/tbody/tr[")
	WebElement beforeXpath;
	
	@FindBy(xpath =".//*[@id='idreferece']")
	WebElement gridRefresh;

	@FindBy(xpath = "]/td[5]")
	WebElement afterXpath;

	@FindBy(xpath = "//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[\" + i + \"]/td[1]/input[1]")
	WebElement checkBoxInput;

	@FindBy(className = "bootbox-body")
	WebElement poupupText;

	@FindBy(xpath = ".//*[@id='txtRemarks']")
	WebElement excludePopupReason;

	@FindBy(xpath = ".//*[@id='dropdownResionExclude']")
	WebElement excludePopupRemarks;

	@FindBy(xpath = ".//*[@id='btndone']")
	WebElement excludePopupSubmit;

	@FindBy(id = "idlogout")
	WebElement logoutButton;

	@FindBy(xpath = "(/html/body/div[5]/div/div/div[3]/button[2]")
	WebElement logoutConfirm;

	@FindBy(className = "dataTables_info")
	WebElement text;

	@FindBy(xpath = ".//*[@id='ddlOperation']")
	WebElement allTokendropdown;

	@FindBy(xpath = ".//*[@id='btnapply']")
	WebElement applyButtonX;

	@FindBy(xpath = "//*[@id=\"ddlReasonCancel\"]")
	WebElement cancelReason;

	@FindBy(id = "nic_remark")
	WebElement cancelRemark;

	@FindBy(xpath = "//*[@id=\"btnCancelTokenSubmit\"]")
	WebElement cancelSubmit;

	@FindBy(xpath = ".//*[@id='refereshtable']")
    WebElement refreshButton;

	// Transport Mode:Road
	@FindBy(xpath = "/html/body/div[1]/div/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/button")
	WebElement transMode;

	// Vehicle Type
	@FindBy(xpath = "//*[@id=\"vehicle_typeOverDim\"]")
	WebElement vehicleType;

	//
	@FindBy(name = "from_place")
	WebElement vehPlace;

	@FindBy(xpath = "//*[@id=\"ddlState\"]")
	WebElement vehState;

	// update-reason
	@FindBy(xpath = "//*[@id=\"ddlReason\"]")
	WebElement updateReason;

	@FindBy(xpath = "//*[@id=\"btnVehicleUpdateSubmit\"]")
	WebElement update_submit;

	@FindBy(xpath = "//*[@id=\"span_from_place\"]")
	WebElement blank_vallidation;

	@FindBy(id = "vehicle_no")
	WebElement vehicle_no;

	@FindBy(id = "transportation_document_no")
	WebElement transportation_document_no;

	@FindBy(id = "transportation_document_date")
	WebElement transportation_document_date;

	@FindBy(xpath = "/html/body/div[1]/div/div[8]/div/div/div[2]/div/div[1]/div/div[1]/button")
	WebElement move_status;

	@FindBy(id = "txtplace")
	WebElement txtplace;

	@FindBy(id = "txtremarks")
	WebElement txtremarks;

	@FindBy(xpath = "//*[@id=\"btnsubmitupdatemovement\"]")
	WebElement updateMovementButton;

	// Eway Bill Generation
	public void GenerateEwayBill() throws InterruptedException {

		WebElement ele = null;

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[5]";
		for (int i = 1; i < 3; i++) {
			String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			// System.out.println(name);
			// if (name.contains("IN924")) {
			driver.findElement(By.xpath(
					"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
					.click();
			Select selectDropdown = new Select(driver.findElement(By.xpath(".//*[@id='ddlOperation']")));
			selectDropdown.selectByIndex(0);

			// applyButton.click();
			driver.findElement(By.xpath(".//*[@id='btnapply']")).click();
			// Thread.sleep(3000);
			String val = driver.findElement(By.className("bootbox-body")).getText();
			// System.out.println(val);

			// poupupText.getText();
			// System.out.println(poupupText.getText());
			driver.navigate().refresh();
			Thread.sleep(5000);
			String genStatus=driver.findElement(By.xpath(
					".//*[@id='table1']/tbody/tr["+i+"]/td[9]"))
					.getText();
			if(genStatus.equals("Initiated")) {
				System.out.println("Token Generate successfully");
			}
			else {
				System.out.println("Failed Token Generate");
			}
			TestUtil.takeScreenshot(driver,TestUtil.PROJECT_NAME);
			// logoutButton.click();
			// Thread.sleep(10000);
			// logoutConfirm.click();
			driver.findElement(By.id("idlogout")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click();
			Thread.sleep(4000);
			Assert.assertEquals(genStatus, "Initiated");
			

			// }
			break;
		}
		// driver.close();

	}

	// Checking Excluded file retain or not
	public void CheckExcludedFileRetain() throws InterruptedException {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[5]";
		for (int i = 1; i < 2; i++) {
			String docno = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			// String docno = (beforeXpath)+ (i) + (afterXpath).getText();
			/*
			 * driver.findElement(By.xpath(
			 * "//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i +
			 * "]/td[1]/input[1]")) .click();
			 */
			checkBoxInput.click();
			Select selectDropdown = new Select(allTokendropdown);
			selectDropdown.selectByIndex(3);

			applyButtonX.click();

			Select selectDropdown1 = new Select(excludePopupRemarks);
			selectDropdown1.selectByIndex(2);
			excludePopupReason.sendKeys("test remarks");
			excludePopupSubmit.click();
			String val = poupupText.getText();
			System.out.println(val);

			driver.navigate().refresh();
			Thread.sleep(5000);
			
            gridRefresh.click();
			ArrayList<String> tmpList1 = new ArrayList<String>();
			for (int j = 1; j < 10; j++) {
				String docNo1 = driver.findElement(By.xpath(beforeXpath + j + afterXpath)).getText();
				// String docNo1 = (beforeXpath) + (i +((afterXpath).getText()));
				tmpList1.add(docNo1);
			}

			if (tmpList1.contains(docno)) {
				System.out.println(" File Exist Test Case Failed");
				System.out.println(docno);
			} else {
				System.out.println("File Excluded Test case Passed");
			}
            Assert.assertFalse(tmpList1.contains(docno));
			System.out.println(tmpList1.toString());
			System.out.println("================================================================");
			// break;
			driver.navigate().refresh();
			Thread.sleep(5000);
			TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
		}
		/*
		 * driver.findElement(By.id("idlogout")).click(); Thread.sleep(5000);
		 * driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).
		 * click();
		 */
	}

	// Excluding Without Reason
	public void ExcludeWithoutReason() throws InterruptedException {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[5]";
		for (int i = 1; i < 3; i++) {
			String docno = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();

			driver.findElement(By.xpath(
					"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
					.click();
			Select selectDropdown = new Select(driver.findElement(By.xpath(".//*[@id='ddlOperation']")));
			selectDropdown.selectByIndex(3);

			driver.findElement(By.xpath(".//*[@id='btnapply']")).click();

			/*
			 * Select selectDropdown1 = new
			 * Select(driver.findElement(By.xpath(".//*[@id='dropdownResionExclude']")));
			 * selectDropdown1.selectByIndex(2);
			 */
			// driver.findElement(By.xpath(".//*[@id='txtRemarks']")).sendKeys("test
			// remarks");
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='btndone']")).click();
			Thread.sleep(3000);
			String val = driver.findElement(By.xpath(".//*[@id='IdspanResionExclude']")).getText();
			TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
			System.out.println(val);

			driver.navigate().refresh();
			boolean LogoStatus= rjLogo.isDisplayed();
			 Assert.assertEquals(LogoStatus, true);

			break;
		}
		driver.findElement(By.id("idlogout")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click();
	}

	// Cancel Exclusion without reason
	public void CancelExclusionWithoutReason() throws InterruptedException {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[5]";
		for (int i = 1; i < 3; i++) {
			String docno = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();

			driver.findElement(By.xpath(
					"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
					.click();
			Select selectDropdown = new Select(driver.findElement(By.xpath(".//*[@id='ddlOperation']")));
			selectDropdown.selectByIndex(3);

			driver.findElement(By.xpath(".//*[@id='btnapply']")).click();

			driver.findElement(By.xpath(".//*[@id='txtRemarks']")).sendKeys("test remarks");
			TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
			driver.findElement(By.xpath("//*[@id='btnExcludeReset']")).click();
			/*
			 * driver.findElement(By.xpath(".//*[@id='btndone']")).click(); String val =
			 * driver.findElement(By.className("bootbox-body")).getText();
			 * System.out.println(val);
			 */

			driver.navigate().refresh();
			boolean LogoStatus= rjLogo.isDisplayed();
			 Assert.assertEquals(LogoStatus, true);

			break;
		}
		driver.findElement(By.id("idlogout")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click();

	}

	// Cancel Exclusion After selecting reason
	public void CancelExclusionAfterSelectReason() throws InterruptedException {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[5]";
		for (int i = 1; i < 3; i++) {
			String docno = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();

			driver.findElement(By.xpath(
					"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
					.click();
			Select selectDropdown = new Select(driver.findElement(By.xpath(".//*[@id='ddlOperation']")));
			selectDropdown.selectByIndex(3);

			driver.findElement(By.xpath(".//*[@id='btnapply']")).click();

			Select selectDropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='dropdownResionExclude']")));
			selectDropdown1.selectByIndex(2);
			TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
			driver.findElement(By.xpath("//*[@id='btnExcludeReset']")).click();
			/*
			 * driver.findElement(By.xpath(".//*[@id='btndone']")).click(); String val =
			 * driver.findElement(By.className("bootbox-body")).getText();
			 * System.out.println(val);
			 */

			driver.navigate().refresh();
			boolean LogoStatus= rjLogo.isDisplayed();
			 Assert.assertEquals(LogoStatus, true);

			break;
		}
		driver.findElement(By.id("idlogout")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click();

	}

	public TokenPage() {
		PageFactory.initElements(driver, this);
	}

	public void loadAllTokenPage() {
		try {
			Thread.sleep(10000);
			String text_data = text.getText();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
			Assert.assertTrue(text_data.contains("Showing"));
			System.out.println(text_data);
			System.out.println("text-success");
		} catch (Exception e) {
		}
	}

	public void cancelToken() {
		System.out.println("cancel-start");
		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		
		ArrayList<String> temp1 = new ArrayList<String>();
		try {
			for (int i = 1; i < 21; i++) {
				
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("151001196813")) {
				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();
				Select sel = new Select(allTokendropdown);
				sel.selectByValue("cancel");
				applyButtonX.click();
				Thread.sleep(3000);
				Select sel2 = new Select(cancelReason);
				sel2.selectByValue("3");
				cancelRemark.sendKeys("Test Remarks");
				cancelSubmit.click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				temp1.add(name);
				System.out.println("Arralist value is:" + temp1.toString());
				Thread.sleep(30000);
				Thread.sleep(3000);
                String status1 = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
                            .getText();
                    System.out.println(status1);
                if (status1.equals("Sent for cancellation")) {
                    for (int j = 0; j < 30; j++) {
                        refreshButton.click();
                        System.out.println("Count" + j);
                        String stat = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
                                .getText();
                        System.out.println(stat);
                    if (!stat.equals("Sent for cancellation")) {
                        break;
                    }
                    }
                    String status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
                            .getText();
                    System.out.println(status);
                    TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
                    Assert.assertEquals(status,"Cancelled");

                    if (status.equals("Cancelled")) {
                        TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
                        System.out.println("status====success==Cancelled");
                    } else {
                        TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
                        System.out.println("failed");
                    }}
                break;
		        }
		       
			}}
                catch (Exception e) {
                }
                }


	public void UpdateVehicle() {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		ArrayList<String> tmpList = new ArrayList<String>();
		try {
			for (int i = 1; i < 20; i++) {
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("141001196810")) {

				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();

				Select sel = new Select(allTokendropdown);
				sel.selectByValue("update-vehicle");
				applyButtonX.click();
				Thread.sleep(3000);
				transMode.click();
				Thread.sleep(10000);
				vehicleType.click();
				vehPlace.clear();
				vehPlace.sendKeys("Trivandrum");
				Select sel1 = new Select(vehState);
				sel1.selectByValue("32");
				Select sel2 = new Select(updateReason);
				sel2.selectByValue("1");
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				update_submit.click();
				Thread.sleep(3000);
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
                        refreshButton.click();
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
                        TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
                        System.out.println("status====success==Vehicle Updated");
                    } else {
                        System.out.println("failed");
                    }}
				break;
				 }
			}
		} catch (Exception e) {
		}

	}

	public void UpdateVechBlank() {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		ArrayList<String> tmpList = new ArrayList<String>();
		try {
			for (int i = 1; i < 20; i++) {
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("141001196810")) {

				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();

				Select sel = new Select(allTokendropdown);
				sel.selectByValue("update-vehicle");
				applyButtonX.click();
				Thread.sleep(3000);
				transMode.click();
				update_submit.click();
				Thread.sleep(3000);
				String validation = blank_vallidation.getText();
				System.out.println(validation);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				Assert.assertEquals(validation,"Please enter place of change");
				if (validation.equals("Please enter place of change")) {
					System.out.println("Validation Success");
				}
				break;
			}
			}
		} catch (Exception e) {
		}
	}

	public void UpdateVechInvalidValues() {

		String beforeXpath = "//*[@id=\"table1\"]/tbody/tr[";
		String afterXpath = "]/td[3]";
		ArrayList<String> tmpList = new ArrayList<String>();
		try {
			for (int i = 1; i < 20; i++) {
				String initial_status = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]"))
		                .getText();
		        System.out.println(initial_status);
		        if (initial_status.equals("Generated")) {
				String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
				System.out.println("name");
				System.out.println(name);
				// if (name.contains("141001196810")) {

				driver.findElement(By.xpath(
						"//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[" + i + "]/td[1]/input[1]"))
						.click();
				Select sel = new Select(allTokendropdown);
				sel.selectByValue("update-vehicle");
				applyButtonX.click();
				Thread.sleep(3000);
				transMode.click();
				Thread.sleep(10000);
				vehicleType.click();
				vehPlace.clear();
				vehPlace.sendKeys("123456");
				vehicle_no.clear();
				vehicle_no.sendKeys("qwerty");
				Select sel1 = new Select(vehState);
				sel1.selectByValue("32");
				Select sel2 = new Select(updateReason);
				sel2.selectByValue("1");
				transportation_document_no.clear();
				transportation_document_no.sendKeys("qwerty");
				transportation_document_date.clear();
				transportation_document_date.click();
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				update_submit.click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				System.out.println("close");
				tmpList.add(name);
				System.out.println("Arralist value is:" + tmpList.toString());
				Thread.sleep(3000);
				String status1 = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]")).getText();
				System.out.println(status1);
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				Assert.assertEquals(status1,"Vehicle Updation Failed, Inval.....Read More...");
				if (status1.equals("Vehicle Updation Failed, Inval.....Read More...")) {
					System.out.println("status====success==Vehicle Updation Failed");
				}
				break;
			}
			}
		} catch (Exception e) {
		}
	}

	public void UpdateMovement() {
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
				Select sel = new Select(allTokendropdown);
				sel.selectByValue("update-movement");
				applyButtonX.click();
				Thread.sleep(3000);
				move_status.click();
				Thread.sleep(10000);
				txtplace.clear();
				txtplace.sendKeys("Trivandrum");
				txtremarks.clear();
				txtremarks.sendKeys("not yet started");
				updateMovementButton.click();
				driver.navigate().refresh();
				System.out.println("Completed update remarks");
				tmpList.add(name);
				System.out.println("Arralist value is:" + tmpList.toString());
				Thread.sleep(5000);
				String status_movement = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[" + i + "]/td[8]")).getText();
				System.out.println(status_movement);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				TestUtil.takeScreenshot(driver, TestUtil.PROJECT_NAME);
				Assert.assertEquals(status_movement,"Generated");
				if (status_movement.equals("Generated")) {
					System.out.println("status====success==Updated Movement");
				} else {
					System.out.println("failed");
				}
			 }
		        break;
			}
		} catch (Exception c) {
		}
	}

}
