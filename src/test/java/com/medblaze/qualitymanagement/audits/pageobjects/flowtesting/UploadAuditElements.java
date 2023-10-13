package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;


public class UploadAuditElements {
	WebDriver driver;

	public UploadAuditElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Perform audit')]")
	WebElement performAudit;

	@FindBy(xpath = "//div[text()='Audit Name']//parent::div//div[2]/input")
	WebElement Auditname;

	@FindBy(xpath = "//span[contains(text(),'Submit ')]")
	WebElement submit;

	@FindBy(xpath = "//span[contains(text(),'Upload ')]")
	WebElement Upload;

	@FindBy(xpath = "//mat-error[contains(text(),'Audit name is Mandatory')]")
	WebElement errormsg;

	@FindBy(xpath = "//span[@title='Clear all']")
	WebElement auditcancel;

	@FindBy(xpath = "//mat-icon[text()='highlight_off']")
	WebElement cancel;

	@FindBy(xpath = "//div[contains(text(),'Audit incharge review pending')]")
	WebElement AIRPbtn;
	
	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//input[@id='list-search']")
	WebElement search;
	
	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-icon[contains(text(),'delete_sweep')]")
	WebElement deletecache;
	
	public void clickDeletecache() {
		deletecache.click();
	}
	
	public void clickAIRPbtn() {
		AIRPbtn.click();
	}
	
	public void searchRecord(String input) {
		search.sendKeys(input);
	}

	public void clickcancel() {
		cancel.click();
	}

	public void clickAuditcancel() {
		auditcancel.click();
	}

	public void clickperformAUdit() {
		performAudit.click();
	}

	public void enterAuditName(String audit) {
		Auditname.sendKeys(audit);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),' " + audit + "')]"));
		element.click();
	}

	public void clickUpload() {
		Upload.click();
	}

	public void checkerrormsg() {
		String message = errormsg.getText();
		System.out.println(message);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void uploadAudit(String path) throws AWTException, InterruptedException {
		Robot rb = new Robot();
		rb.delay(2000);

		// copy path to clipboard
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Paste the path(ctrl+v)
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		 rb.delay(1000);

		rb.keyRelease(KeyEvent.VK_CONTROL) ;
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(1000);
		
		Thread.sleep(2000);

		// hit enter					
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void verify(String auditname, String date) throws InterruptedException, IOException {
		WebElement auditrecord = driver.findElement(By.xpath("//med-list[@key='Review Pending-audits-list']//span[contains(text(),'"+auditname+"')]//ancestor::tr//span[contains(text(),'"+date+"')]"));
		boolean b = auditrecord.isDisplayed();
		if (b) {
			BaseClass.log.info("Upload audit Pass!");
			assertTrue(true);
			//System.out.println("Upload audit Pass!");
		}
		else {
			BaseClass.log.info("Upload Audit Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "UploadAuditusingTemplete");
			assertTrue(false);
			//System.out.println("Upload Audit Fail!");
		}

	}

}
