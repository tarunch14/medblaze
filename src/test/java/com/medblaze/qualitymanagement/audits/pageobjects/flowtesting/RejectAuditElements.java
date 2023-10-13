package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;




public class RejectAuditElements {
	WebDriver driver;
	
	public RejectAuditElements(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Reject']")
	WebElement reject;
	
	@FindBy(xpath = "//div[text()='Rejected']")
	WebElement rej123;
	
	@FindBy(xpath = "//div[text()='Rejected Date']")
	WebElement rejDtSbtn;
	
	@FindBy(xpath = "//textarea[@data-placeholder='Please enter your comments']")
	WebElement comments;
	
	@FindBy(xpath = "//mat-icon[text()='check']")
	WebElement yes;
	
	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//input[@id='list-search']")
	WebElement search;
	
	public void searchRecord(String input) {
		search.sendKeys(input);
	}
	
	public void clickYes() {
		yes.click();
	}
	
	public void enterRejectedcomments(String coms) {
		comments.sendKeys();
	}
	
	public void clickdots(String auditname,String date) {
		WebElement vdots = driver.findElement(By.xpath("//med-list[@key='Review Pending-audits-list']//span[contains(text(),'"+auditname+"')]//ancestor::tr//span[contains(text(),'"+date+"')]//ancestor::tr//td[7]//button[3]"));
		vdots.click();
	}
	
	public void clickreject() {
		reject.click();
	}
	
	public void clickRejected1() {
		WaitHelper.waitForElementtoBeClickable(rej123, driver, 10);
		rej123.click();
	}
	
    public void	clickrejectedDtSbtn(){
    	rejDtSbtn.click();
	}
	
	public void verifyelement(String auditname, String date) throws InterruptedException, IOException {
	String record = "//med-list[@key='Rejected-audits-list']//tr//td//med-show-more/span[contains(text(),'"+auditname+"')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"+date+"')]";
			
		boolean check = false;
		for(int i=0;i<2;i++) {
			clickrejectedDtSbtn();
			Thread.sleep(5000);
			try {
				WebElement closedrec = driver.findElement(By.xpath(record));
				boolean b = closedrec.isDisplayed();	
				if(!check) {
					check = (b == true);
				}
			}
			catch(Exception e){
				System.out.print("Inside exception");
			}	
		}
		
		if(check) {
			BaseClass.log.info("Reject audit PASS!");
			assertTrue(true);
			//System.out.println("Reject audit PASS!");
		}
		else {
			BaseClass.log.info("Reject Audit Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "RejectExistingAudit");
			assertTrue(false);
			//System.out.println("Reject Audit Fail!");
		}
	}
	
	
}
