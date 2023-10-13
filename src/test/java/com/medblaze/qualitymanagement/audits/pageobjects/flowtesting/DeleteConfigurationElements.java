package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;

public class DeleteConfigurationElements {
	WebDriver driver;
	
	public DeleteConfigurationElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='list-search']")
	WebElement search;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]//ancestor::button")
	WebElement deletebutton;
	
	@FindBy(xpath = "//span[contains(text(),'Yes ')]//ancestor::button")
	WebElement yes;
	
	@FindBy(xpath = "//span[contains(text(),'No ')]//ancestor::button")
	WebElement No;
	
	public void verify(String auditname,String audittype) {
		try {
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+auditname+"')]//ancestor::tr//td[3]//span[contains(text(),'"+audittype+"')]"));
			boolean b=element.isDisplayed();
			BaseClass.log.info("Delete Configuration Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "DeleteAuditConfiguration");
			assertTrue(false);
			
			//System.out.println("Delete Configuration Fail!");
		}
		catch(Exception e) {
			BaseClass.log.info("Delete Configuration Pass!");
			assertTrue(true);
			
			//System.out.println("Delete Configuration Pass!");
		}
		
	}
	
	public void clickyes() {
		yes.click();
	}
	
	public void clickNo() {
		No.click();
	}
	
	public void clickDeletebutton() {
		deletebutton.click();
	}
	
	public void serachRecord(String input) {
		search.sendKeys(input);
	}
	
	public void clearSearch() {
		search.clear();
	}
	
	public void clickvDots(String auditname) {
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+auditname+"')]//ancestor::tr//mat-icon[contains(text(),'more_vert')]"));
		ele.click();
	}	
	

}
