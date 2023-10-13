package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTestElements {
	
	WebDriver driver;
	
	public LoginTestElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='username']")
	WebElement User_Name;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement login_btn;
	
	
	
	public void setUsername(String user) {
		User_Name.sendKeys(user);
	}
	
	public void setPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void loginclick() {
		login_btn.click();
	}
	
	

}
