package com.orangeHRM.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverSetup {

	public WebDriver driver = null;

	public void createBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	}

}
