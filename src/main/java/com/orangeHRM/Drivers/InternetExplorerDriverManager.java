package com.orangeHRM.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetExplorerDriverManager extends DriverSetup {
	WebDriver driver = null;

	public void createBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
}
