package com.orangeHRM.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverSetup {
	WebDriver driver = null;

	public void createBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

}
