package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;



public class AuditIRPElements {

	WebDriver driver;
	int cnt2;
	int cnt3;
	

	public AuditIRPElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/div[text()='Audit incharge review pending']")
	WebElement AIRP_btn;
	
	@FindBy(xpath = "//div/div[text()='Audit admin review pending']")
	WebElement AARP_btn;

	@FindBy(xpath = "//div/div[text()='Audit incharge review pending']//parent::div//parent::mat-card//div[2]/span")
	WebElement count;
	
	@FindBy(xpath = "//div/div[text()='Audit admin review pending']//parent::div//parent::mat-card//div[2]/span")
	WebElement Acount;

	String rec_X = "//med-list[@key='Review Pending-audits-list']//tr[@class='mat-row cdk-row ng-star-inserted']//td[2]//med-show-more/span[@id='ellipsis-ex']";
	
	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-icon[text()='delete_sweep']")
	WebElement delteCache;
	
	public void clickDeleteCache() {
		delteCache.click();
	}

	
	public void clickAIRPbtn() {
		AIRP_btn.click();
	}

	public void getcount() {
		String cnt1 = count.getText();
		cnt2 = Integer.parseInt(cnt1);
		System.out.println(cnt2);

	}

	public void getlistofrecords() {
		List<WebElement> list = driver.findElements(By.xpath(rec_X));
		cnt3 = list.size();
	}

	public void verifycount1() throws IOException {
		if (cnt3 == cnt2) {
			BaseClass.log.info("AuditIRP pass!");
			BaseClass.log.info("List count is :" + cnt2);
			BaseClass.log.info("No.of Records :" + cnt3);
			assertTrue(true);
			
			//System.out.println("AuditIRP pass!");
			//System.out.println("List count is :" + cnt2);
			//System.out.println("No.of Records :" + cnt3);
		} else {
			BaseClass.log.info("AuditIRP Fail!");
			BaseClass.log.info("List count is :" + cnt2);
			BaseClass.log.info("No.of Records :" + cnt3);
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "noofAuditInchargeReviewPendingrecords");
			assertTrue(false);

		//	System.out.println("AuditIRP Fail!");
		//	System.out.println("List count is :" + cnt2);
		//	System.out.println("No.of Records :" + cnt3);
		}
	}
	

	
	public void clickAARPbtn() {
		AARP_btn.click();
	}
	
	public void getacount() {
		String cnt1 = Acount.getText();
		cnt2 = Integer.parseInt(cnt1);

	}
	


}
