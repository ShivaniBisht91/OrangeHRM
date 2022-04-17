package com.orangeHRM.commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		WebElement ele=driver.findElement(element);
		ele.clear();
		ele.sendKeys(value);
		
	}
	
	public void hoverOnElement(WebDriver driver, String locName) {
		By element=formByProp(locName);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(element)).build().perform();
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
		}
		// ExecLog.clilogger.info("Locator being used: " + elem.toString());
		return elem;
	}
	
	

}
