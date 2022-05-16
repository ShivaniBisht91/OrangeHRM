package com.orangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangeHRM.commonUtil.CommonMethodsUtil;

public class AdminPage {
	WebDriver driver;
	String username;

	String locAdminTab = "id=menu_admin_viewAdminModule";
	String locSystemUsersTitle = "xpath=//*[@id='systemUser-information']/div/h1";

	String locAddBtn = "id=btnAdd";
	String locAddUserTitle = "id=UserHeading";
	String locUserRoleDropdwn = "id=systemUser_userType";
	String loccEmployeeNameTextbox = "id=systemUser_employeeName_empName";
	String locUsernameTextbox = "id=systemUser_userName";
	String locStatusDropdown = "id=systemUser_status";
	String locPasswordTextbox = "id=systemUser_password";
	String locConfirmPassword = "id=systemUser_confirmPassword";
	String locSaveButton = "id=btnSave";
	String locCancelButton = "id=btnCancel";

	String locDeleteButton = "id=btnDelete";

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAdminTab() {
		CommonMethodsUtil.clickAndWait(driver, locAdminTab);
	}
	
	public void verifySystemUsertitle() {
		String addUserTitle = CommonMethodsUtil.getTextOfElement(driver, locSystemUsersTitle);
		if (addUserTitle.equals("System Users")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void clickAdd() {
		CommonMethodsUtil.clickAndWait(driver, locAddBtn);
	}

	public void verifyAddUsertitle() {
		String addUserTitle = CommonMethodsUtil.getTextOfElement(driver, locAddUserTitle);
		if (addUserTitle.equals("Add User")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void setUserRole(String value) {
		CommonMethodsUtil.selectDropdownValue(driver, locUserRoleDropdwn, value);
	}

	public void setEmployeeName(String employeeName) {
		CommonMethodsUtil.clearAndType(driver, loccEmployeeNameTextbox, employeeName);
	}

	public void setUsername(String username) {
		CommonMethodsUtil.clearAndType(driver, locUsernameTextbox, username);
	}

	public void setStatus(String status) {
		CommonMethodsUtil.selectDropdownValue(driver, locUserRoleDropdwn, status);
	}

	public void setPassword(String password) {
		CommonMethodsUtil.clearAndType(driver, locPasswordTextbox, password);
	}

	public void setConfirmPassword(String confirmPassword) {
		CommonMethodsUtil.clearAndType(driver, locConfirmPassword, confirmPassword);
	}

	public void clickSaveUser() {
		CommonMethodsUtil.clickAndWait(driver, locSaveButton);
	}

	public void clickCancelUser() {
		CommonMethodsUtil.clickAndWait(driver, locDeleteButton);
	}
	
	public void selectUserFromList(String username) {
		CommonMethodsUtil.clickAndWait(driver, "xpath=//a[text()='"+username+"']/parent::td/preceding-sibling::td");
	}
	
		public 

}
