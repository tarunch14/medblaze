package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadReportElements {
	WebDriver driver;
	
	public DownloadReportElements(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//div[@class='mat-paginator-range-label']")
	WebElement range;
	
	public int getrange() {
		String rng=range.getText();
		String s=rng.substring(10);
		int i=Integer.parseInt(s); 
		return i;	
	}
	
	
	public void clickdownload(String typeofreport) throws InterruptedException {
		String ele;
		if(typeofreport.equalsIgnoreCase("Review pending")) {
			 ele="//med-list[@key='Review Pending-audits-list']";
			 EditAuditElements el = new EditAuditElements(driver);
			 el.clickReviewpending();
			 Thread.sleep(3000);
		}
		else if(typeofreport.equalsIgnoreCase("Closed")){
			 ele="//med-list[@key='Closed-audits-list']";
			 ApproveAuditElements obj = new ApproveAuditElements(driver);
			 obj.clickclsdbtn();
			 Thread.sleep(5000);
			 
		}
		else {
			 ele="//med-list[@key='Rejected-audits-list']";
			 RejectAuditElements obj1 = new RejectAuditElements(driver);
			 obj1.clickRejected1();
			 Thread.sleep(5000);
		}
		
		WebElement element =driver.findElement(By.xpath(ele+"//mat-icon[text()='cloud_download']"));
		element.click();
		
	}
	
	public void verifyrange() {
		
	}

}
