package com.orangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.orangeHRM.commonUtil.CommonMethodsUtil;

public class LoginPage {
	WebDriver driver;

	String locUsername="id=txtUsername";
	String locPassword="id=txtPassword";
	String locLoginbtn="id=btnLogin";
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUsername() {
		CommonMethodsUtil.clearAndType(driver, locUsername, "Admin");
	}
	
    public void setPassword() {
		CommonMethodsUtil.clearAndType(driver, locPassword, "admin123");
	}
	
    public void clickLoginButton() {
    	CommonMethodsUtil.clickAndWait(driver, locLoginbtn);
   	}
	
    public void login() {
    	setUsername();
    	setPassword();
    	clickLoginButton();
    }
}