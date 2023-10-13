package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HospitalStatsElements {
	WebDriver driver;
	
	public HospitalStatsElements(WebDriver dr) {
		driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Hospital Stats']")
	WebElement hospitaistats;
	
	@FindBy(xpath = "//a[text()='Hospital Stats']//parent::a//parent::li//a[text()=' Submission']")
	WebElement submission;
	
	@FindBy(xpath = "//div[text()='Unit']//parent::div//input")
	WebElement unit;
	
	@FindBy(xpath = "//span[contains(text(),' CARE Nagpur')]")
	WebElement clickunit;
	
	@FindBy(xpath = "//div[text()='Statistics']//parent::div//input")
	WebElement statistics;
	
	@FindBy(xpath = "//span[contains(text(),' Integration Statistics')]")
	WebElement clickstatistics;
	
	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	WebElement calendericon;
	
	@FindBy(xpath = "//div[contains(text(),'31')]")
	WebElement date;
	
	@FindBy(xpath = "//span[text()='Submit ']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//input[@id='totalCASHDischarges']")
	WebElement cashdischarges;
	
	@FindBy(xpath = "//input[@id='totalCREDITDischarges']")
	WebElement creditdischarges;
	
	@FindBy(xpath = "//input[@id='totalDeaths']")
	WebElement totaldeaths;
	
	@FindBy(xpath = "//input[@id='totalAdmissions']")
	WebElement totaladmissions;
	
	
	@FindBy(xpath = "//input[@id='oPCount']")
	WebElement opcount;
	
	@FindBy(xpath = "//input[@id='inpatientdays']")
	WebElement inpatientdays;
	
	@FindBy(xpath = "//span[text()=' Submit']")
	WebElement recordsubmit;
	
	public void verifyrecord(String unitname) {
		WebElement element= driver.findElement(By.xpath("//span[contains(text(),'May-2021')]//parent::med-show-more//parent::td//parent::tr//td[4]//span[contains(text(),'"+unitname+"')]"));
	}
	
	public void clickrecordsubmit() {
		recordsubmit.click();
	}
	
	
	public void enterinpatientdays(String input) {
		inpatientdays.sendKeys(input);
	}
	
	public void enteropcount(String input) {
		opcount.sendKeys(input);
	}
	
	
	public void enteradmissions(String input) {
		totaladmissions.sendKeys(input);
	}
	
	
	public void enterdeaths(String input) {
		totaldeaths.sendKeys(input);
	}
	
	public void enterCreditdischarges(String input) {
		creditdischarges.sendKeys(input);
	}
	
	public void entercashdischarges(String input) {
		cashdischarges.sendKeys(input);
	}
	
	
	public void clicksubmit() {
		submitbtn.click();
	}	
	
	public void selectdate() {
		date.click();
	}	
	
	public void clickcalendericon() {
		calendericon.click();
	}
	
	
	public void clickstatistics(String stat) {
		WebElement clickstatistics=driver.findElement(By.xpath("//span[contains(text(),' "+stat+"')]"));
		clickstatistics.click();
	}
	
	public void enterstatistics(String statisticsname ) {
		statistics.sendKeys(statisticsname);
	}
	
	public void clickunit(String unitname) {
		WebElement clickunit=driver.findElement(By.xpath("//span[contains(text(),' "+unitname+"')]"));
		clickunit.click();
	}
	
	public void enterunitname(String unitname) {
		unit.sendKeys(unitname);
	}
	
	
	
	public void clicksubmission() {
		submission.click();
	}
	
	public void clickhospitalstatbtn() {
		hospitaistats.click();
	}
	

}
