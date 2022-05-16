package com.orangeHRM.testcases;

import org.testng.annotations.Test;

import com.orangeHRM.Pages.AdminPage;

public class AdminPageTest extends TestSetup{

	AdminPage admin;
	
	@Test
	public void verifyAddUserDetails() {
		admin=new AdminPage(driver);
		admin.clickAdminTab();
		admin.verifySystemUsertitle();
		admin.clickAdd();
		admin.verifyAddUsertitle();
		admin.setUserRole("Admin");
		admin.setEmployeeName("Shivani");
		admin.setUsername("Shivani");
		admin.setStatus("Enabled");
		admin.setPassword("Test@123");
		admin.setConfirmPassword("Test@123");
		admin.clickSaveUser();
	}
	
	@Test 
	public void verifyNewUser() {
		admin=new AdminPage(driver);
		admin.clickAdminTab();
		admin.verifySystemUsertitle();
		admin.clickAdd();
		admin.verifyAddUsertitle();
		admin.setUserRole("Admin");
		admin.setEmployeeName("Shivani");
		admin.clickCancelUser();
		admin.verifySystemUsertitle();
	}

	@Test
	public void verifyCancelUserDetails() {
		admin=new AdminPage(driver);
		admin.clickAdminTab();
		admin.verifySystemUsertitle();
		admin.clickAdd();
		admin.verifyAddUsertitle();
		admin.setUserRole("Admin");
		admin.setEmployeeName("Shivani");
		admin.clickCancelUser();
		admin.verifySystemUsertitle();
	}
	
	@Test 
	public void verifyDeleteUser() {
		admin=new AdminPage(driver);
		admin.clickAdminTab();
		admin.verifySystemUsertitle();
		admin.clickAdd();
		admin.verifyAddUsertitle();
		admin.setUserRole("Admin");
		admin.setEmployeeName("Shivani");
		admin.setUsername("Shivani");
		admin.setStatus("Enabled");
		admin.setPassword("Test@123");
		
	}
}
