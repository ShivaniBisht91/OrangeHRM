package com.orangeHRM.commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethodsUtil {

	public static Properties loadProperties() {
		Properties pro = null;
		File pFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\environment.properties");
		try {
			FileInputStream fis = new FileInputStream(pFile);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pro;
	}

	public static void clickAndWait(WebDriver driver, String locName) {
		By element = formByProp(locName);
		driver.findElement(element).click();
	}

	public static void clearAndType(WebDriver driver, String locName, String value) {
		By element = formByProp(locName);
		WebElement ele = driver.findElement(element);
		ele.clear();
		ele.sendKeys(value);
	}

	public static String getTextOfElement(WebDriver driver, String locName) {
		By element = formByProp(locName);
		WebElement ele = driver.findElement(element);
		String value = ele.getText();
		return value;
	}

	public static String getAttributeValueOfElement(WebDriver driver, String locName, String attributeName) {
		WebElement ele = driver.findElement(formByProp(locName));
		String value = ele.getAttribute(attributeName);
		return value;
	}

	public static void selectDropdownValue(WebDriver driver, String locName, String value) {
		Select dropdown = new Select(driver.findElement(formByProp(locName)));
		dropdown.selectByVisibleText(value);
	}

	public static void captureScreenshot(WebDriver driver, String destination) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(destination);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static By formByProp(String element) {
		String[] loc = element.split("=", 2);
		String strategy = loc[0];
		By elem = null;

		switch (strategy) {
		case "id":
			elem = By.id(loc[1]);
			break;
		case "xpath":
			elem = By.xpath(loc[1]);
			break;
		case "name":
			elem = By.name(loc[1]);
			break;
		case "linkText":
			elem = By.linkText(loc[1]);
			break;
		case "partialLinkText":
			elem = By.partialLinkText(loc[1]);
			break;
		case "tagName":
			elem = By.tagName(loc[1]);
			break;
		case "className":
			elem = By.className(loc[1]);
			break;
		case "cssSelector":
			elem = By.cssSelector(loc[1]);
			break;
		case "HTMLSelector":
			elem = By.cssSelector(loc[1]);
			break;
		}
		return elem;
	}

	public static void waitForElementToLoad(WebDriver driver, int duration, String timeType, String locName) {
		WebDriverWait wait = null;
		if (timeType.equalsIgnoreCase("second")) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		} else if (timeType.equalsIgnoreCase("minute")) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		} else if (timeType.equalsIgnoreCase("hour")) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		}
		WebElement ele = driver.findElement(formByProp(locName));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
