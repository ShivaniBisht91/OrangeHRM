package com.orangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangeHRM.commonUtil.CommonMethodsUtil;

public class DashboardPage {

	WebDriver driver;

	String locdashboardTab = "id=menu_dashboard_index";

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyDashboardTabTitle() {
		String dashboardTabTitle = CommonMethodsUtil.getTextOfElement(driver, locdashboardTab);
		if (dashboardTabTitle.equals("Dashboard")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
