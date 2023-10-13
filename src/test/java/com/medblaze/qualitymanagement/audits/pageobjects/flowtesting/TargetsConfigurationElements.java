package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;

public class TargetsConfigurationElements {
	WebDriver driver;
	
	public TargetsConfigurationElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Targets')]")
	WebElement Targets;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']//mat-icon[contains(text(),'add')]")
	WebElement add;
	
	@FindBy(xpath = "//div[contains(text(),'Unit')]//parent::div[@class='ng-value-container']//input")
	WebElement Unit;
	
	@FindBy(xpath = "//div[contains(text(),'Audit Name')]//parent::div[@class='ng-value-container']//input")
	WebElement auditName;
	
	@FindBy(xpath = "//button[@class='switch checked switch-medium']")
	WebElement enabledToggle;
	
	@FindBy(xpath = "//span[contains(text(),'Submit ')]//ancestor::button")
	WebElement Submit;
	
	@FindBy(xpath ="//input[@id='noOfTargetNotifications']")
	WebElement noofNotifications;
	
	@FindBy(xpath = "//input[@id='targetSize']")
	WebElement noofAudits;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'notifications')]")
	WebElement notifications;
	
	@FindBy(xpath = "//med-notification-tile[1]/div/div")
	WebElement notificationMessage;
	
	@FindBy(xpath = "//input[@id='list-search']")
	WebElement search;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]//ancestor::button")
	WebElement delete;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'check')]//ancestor::button")
	WebElement yes;
	
	public void deleteVerifiaction(String auditname) throws IOException {
		boolean b;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + auditname + "')]"));
			b = ele.isDisplayed();
		} catch (Exception e) {
			b = false;
		}

		if (b) {
			BaseClass.log.info("Target Record Not Deleted!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "ConfigureAuditTargets");
			assertTrue(false);
			
			//System.out.println("Target Record Not Deleted!");
		} else {
			BaseClass.log.info("Target Record Deleted Successfully!");
			assertTrue(true);
			
			//System.out.println("Target Record Deleted Successfully!");
		}
	}
	
	public void deleteConfiguration(String auditname) throws InterruptedException {
		search.sendKeys(auditname);
		Thread.sleep(2000);
		WebElement dots=driver.findElement(By.xpath("//span[contains(text(),'"+auditname+"')]//ancestor::tr//td[7]//button[3]"));
		dots.click();
		delete.click();	
		yes.click();
		Thread.sleep(2000);
	}
	
	public void verify(String auditname) {
		String message=notificationMessage.getText();
		
		
		if(message.contains(auditname)) {
			System.out.println("Pass!");
		}
		else {
			System.out.println("Fail!");
		}
	}
	
	public void clickNotifications() {
		notifications.click();
	}
	
	public void setnoofAudits(String no) {
		noofAudits.sendKeys(no);
	}
	
	public void setnoofNotifications(String no) {
		noofNotifications.sendKeys(no);
	}
	
	public void sendFirstNotification(String Days,String Hour,String Mins) {
		WebElement days =driver.findElement(By.xpath("//mat-label[contains(text(),'Send first repeat notification after')]//parent::div//input[@data-placeholder='Days']"));
		days.clear();
		days.sendKeys(Days);
		
		WebElement hour =driver.findElement(By.xpath("//mat-label[contains(text(),'Send first repeat notification after')]//parent::div//input[@data-placeholder='Hour']"));
		hour.clear();
		hour.sendKeys(Hour);
		
		WebElement mins=driver.findElement(By.xpath("//mat-label[contains(text(),'Send first repeat notification after')]//parent::div//mat-select[@placeholder='Mins']"));
		mins.click();
		driver.findElement(By.xpath("//span[text()=' "+Mins+" ']")).click();
	}
	
	public void repeatNotofication(String Days,String Hour,String Mins) throws InterruptedException {
		WebElement days =driver.findElement(By.xpath("//mat-label[contains(text(),'Repeat notification frequency')]//parent::div//input[@data-placeholder='Days']"));
		days.clear();
		days.sendKeys(Days);
		
		Thread.sleep(5000);
		
		WebElement hour =driver.findElement(By.xpath("//mat-label[contains(text(),'Repeat notification frequency')]//parent::div//input[@data-placeholder='Hour']"));
		hour.clear();
		hour.sendKeys(Hour);
		
		WebElement mins=driver.findElement(By.xpath("//mat-label[contains(text(),'Repeat notification frequency')]//parent::div//mat-select[@placeholder='Mins']"));
		mins.click();
		driver.findElement(By.xpath("//span[text()=' "+Mins+" ']")).click();
	}
	
	public void clickSubmit() {
		Submit.click();
	}
	
	public void selectTargetFrequency(String Tfreq) {
		WebElement frequency=driver.findElement(By.xpath("//input[@value='"+Tfreq+"']//parent::span"));
		frequency.click();
	}
	
	public void clickEnable(String requirement) {
		String checked=enabledToggle.getAttribute("aria-checked");
		boolean check=Boolean.parseBoolean(checked);
		
		if(requirement.equalsIgnoreCase("yes")) {
			if(check) {
				System.out.println("Do Nothing");
			}
			else {
				enabledToggle.click();
			}
		}
		else {
			if(check) {
				enabledToggle.click();
				
			}
			else {
				System.out.println("Do Nothing");
			}
		}
		
	}
	
	public void enterauditName(String Auditname) {
		auditName.sendKeys(Auditname);
		driver.findElement(By.xpath("//span[contains(text(),'"+Auditname+"')]")).click();
	}
	
	public void enterUnit(String unit) {
		Unit.sendKeys(unit);
		driver.findElement(By.xpath("//span[contains(text(),'"+unit+"')]")).click();
	}
	
	public void clickAdd() {
		add.click();
	}
	
	public void clickTargets() {
		Targets.click();
	}

}
