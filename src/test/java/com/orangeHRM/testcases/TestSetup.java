package com.orangeHRM.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.orangeHRM.commonUtil.CommonMethodsUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {

	WebDriver driver;
	Properties pro;

	@BeforeClass
	public void initiateBrowser() {
		setupBrowser();
	}

	@AfterClass
	public void tearDown() {

	}

	public void setupBrowser() {
		pro = CommonMethodsUtil.loadProperties();

		if (pro.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (pro.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(pro.getProperty("orangehrm.url"));
		driver.manage().window().maximize();
	}
}
