package com.rj.prod.base.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.rj.repacked.selenium;
import com.rj.util.TestUtil;

public class TestUtil {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestUtil() {
		try {
		prop = new Properties();
			FileInputStream ip = new FileInputStream("\\\prodtestserv01\\Software\\rjAutomationTest\\src\\main\\java\\com\\prod\\"
					+ "prod\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	}

}
public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "\\\prodtestserv01\\Software\\Selenium_Drivers\\Chrome_\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}
