package com.orangeHRM.testcases;

import org.testng.annotations.Test;

import com.orangeHRM.Pages.DashboardPage;
import com.orangeHRM.Pages.LoginPage;

public class LoginPageTest extends TestSetup{
	public LoginPage login;
	public DashboardPage dashboard;
	
	@Test
	public void verifyLogin() {
		login=new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		login.setUsername();
    	login.setPassword();
    	login.clickLoginButton();;
		dashboard.verifyDashboardTabTitle();
		
	}

	@Test
	public void verifyDashboard() {
		dashboard = new DashboardPage(driver);
		dashboard.verifyDashboardTabTitle();
	}
	
	// F6: Next Line
	// F5:Inside method
	// F8: Skip or Goto next breakout
	// CTL + Shift + I : Inspect Data
	//Drop to frame: Take us to first line of current method(inline method)

}
