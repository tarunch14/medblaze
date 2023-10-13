package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;


public class ReopenAuditElements {
	WebDriver driver;
	JavascriptExecutor js;
	

	public ReopenAuditElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Closed Date']")
	WebElement closedtsortbtn;

	@FindBy(xpath = "//span[contains(text(),'Reopen')]")
	WebElement reopn;

	@FindBy(xpath = "//div[@id='dateOfAudit_time']//span[text()='Mins']//parent::label/parent::span//parent::div/mat-select/div/div/span/span")
	WebElement mins;

	@FindBy(xpath = "//div[@id='dateOfAudit_time']//span[text()='Mins']//parent::label/parent::span//parent::div/mat-select")
	WebElement minsdd;

	@FindBy(xpath = "//span[contains(text(),'Submit ')]")
	WebElement submitbtn;

	@FindBy(xpath = "//span[contains(text(),'Go to List Page ')]")
	WebElement gotolist;

	@FindBy(xpath = "//div[@id='dateOfAudit']//med-keyvalue/div//div[2]")
	WebElement datedetails;

	public void clickgotolist() {
		gotolist.click();
	}

	public void clicksubmit() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitbtn);
		Thread.sleep(2000);
		submitbtn.click();
	}

	public void selectminvalue(String value) {
		WebElement ele = driver
				.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'" + value + "')]"));
		ele.click();
	}

	public void clickminsdropdown() {
		minsdd.click();
	}

	public String getminsvalue() {
		String mm = mins.getText();
		return mm;
	}

	public void clickclosedDtSbtn() {
		closedtsortbtn.click();
	}

	public void clickreopen() {
		reopn.click();
	}

	public void action(String auditname, String date) throws InterruptedException {
		String record = "//med-list[@key='Closed-audits-list']//tr//span[contains(text(),'"+auditname+"')]//ancestor::tr//td[4]//span[contains(text(),'"+date+"')]";

		boolean check = false;
		for (int i = 0; i < 2; i++) {
			//clickclosedDtSbtn();
			Thread.sleep(2000);
			try {
				WebElement closedrec = driver.findElement(By.xpath(record));
				boolean b = closedrec.isDisplayed();
				if (!check) {
					check = (b == true);
				}
			} catch (Exception e) {
				System.out.print("Inside exception");
			}
		}

		if (check) {
			WebElement reopen = driver.findElement(By.xpath("//med-list[@key='Closed-audits-list']//tr//span[contains(text(),'"+auditname+"')]//ancestor::tr//td[4]//span[contains(text(),'"+date+"')]//ancestor::tr//td[10]//button[3]"));
			reopen.click();
			clickreopen();
			PerformAuditElements pa = new PerformAuditElements(driver);
			pa.enterUnitname("HOSPITAL THREE");		
			clicksubmit();
			Thread.sleep(5000);
			clickgotolist();

		} else {
			System.out.println("Audit not found!");
		}

	}

	public void verifydetails(String auditname, String date) throws InterruptedException, IOException {
			
		WebElement details = driver.findElement(By.xpath("//med-list[@key='Closed-audits-list']//tr//span[contains(text(),'"+auditname+"')]//ancestor::tr//td[4]//span[contains(text(),'"+date+"')]//ancestor::tr//td[10]//button[1]"));
		details.click();
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath("//div[@id='unitId']//mat-chip[@class='mat-chip mat-focus-indicator mat-primary mat-standard-chip']"));
		String s2 = e.getText();

		if (s2.equalsIgnoreCase("HOSPITAL THREE")) {
			BaseClass.log.info("Re-open Pass!");
			assertTrue(true);
			//System.out.println("Re-open Pass!");
		} else {
			BaseClass.log.info("Re-open Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "ReopenClosedAudit");
			assertTrue(false);
			//System.out.println("Re-open Fail!");
		}
		

	}

}
