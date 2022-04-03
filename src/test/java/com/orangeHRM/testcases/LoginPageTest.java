package com.orangeHRM.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangeHRM.Pages.LoginPage;

public class LoginPageTest extends TestSetup{
	public LoginPage lp;
	@Test
	public void verifyLogin() {
		lp=new LoginPage(driver);
		lp.login();
	}

}
