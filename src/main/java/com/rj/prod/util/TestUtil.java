package com.rj.prod.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.rj.repacked.selenium;
import org.testng.Reporter;

import com.rj.prod.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	
	public static String PROJECT_NAME = "RJAutomationTest";
	public static boolean TAKE_SCREENSHOT = true;
	public static boolean SLOW_DOWN = true;
	public static String TESTDATA_SHEET_PATH = "\\\prodtestserv01\\TokenAutomationTest\\testdata\\RaymondJamesTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

	public static void takeScreenshot(WebDriver driver, String StrProjectName) {
if(TAKE_SCREENSHOT) {
	

		String dir = "screenshot";
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String time = new SimpleDateFormat("HHmmss").format(new Date());
		String screenShotPath = "";
		if (StrProjectName!=null){
			screenShotPath = "test-output-final" + File.separator + dir + File.separator + date + File.separator + time + ".png";
		}else{
			screenShotPath = StrProjectName + File.separator +  "test-output-final" + File.separator + dir + File.separator + date + File.separator + time + ".png";	
		}
		System.out.println("screenShotPath=[" + screenShotPath + "]");
		String srcForDisplay = "screenshot/" + date + "/" + time + ".png";
		try {
			if (driver != null) {
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File(screenShotPath));
				screenShotPath = screenShotPath.substring(screenShotPath.indexOf("\\"));
				String log = new File("screenshot").getAbsolutePath();
				System.out.println("Screen Captured Successfully!");
			}
		
		} catch (IOException e) {
			screenShotPath = "Failed to capture screenshot: " + e.getMessage();
		}
}
else {
	System.out.println("Screenshot disabled");
}
	
	}
	public static void suiteSlowdown() throws InterruptedException {
		if(SLOW_DOWN) {
			Thread.sleep(3000);
		}

	}
}
