package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;

public class ApproveAuditElements {
	WebDriver driver;
	JavascriptExecutor js;

	public ApproveAuditElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/div[text()='Audit incharge review pending']")
	WebElement AIRPbtn;

	@FindBy(xpath = "//span[text()='Please enter your comments']//parent::label//parent::span//parent::div/textarea")
	WebElement commentsfield;

	@FindBy(xpath = "//span/mat-icon[text()='check']")
	WebElement yes;

	@FindBy(xpath = "//div/div[text()='Audit admin review pending']")
	WebElement AARPbtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']//span[text()='Approve']")
	WebElement aprbtn;

	@FindBy(xpath = "//tr//td//med-show-more/span[contains(text(),'med table form')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),' 10-Aug-2023 11:40 am')]")
	WebElement closedrec;

	@FindBy(xpath = "//div[text()='Closed']")
	WebElement closedbtn;

	@FindBy(xpath = "//div[text()='Closed Date']")
	WebElement closedtsortbtn;
	
	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//input[@id='list-search']")
	WebElement search;
	
	public void searchRecord(String auditname) throws InterruptedException {
		search.sendKeys(auditname);
		Thread.sleep(2000);
	}

	public void clickAIRPbtn() {
		AIRPbtn.click();
	}

	public void clickapprove(String auditname, String date) {
		String record_X = "//med-list[@key='Review Pending-audits-list']//tr//span[contains(text(),'" + auditname
				+ "')]//ancestor::tr//td[4]/med-show-more/span[contains(text(),'" + date
				+ "')]//ancestor::tr//td[7]//button[2]";
		WebElement ele = driver.findElement(By.xpath(record_X));
		ele.click();
	}

	public void entercomments(String comments) {
		commentsfield.sendKeys(comments);
	}

	public void clickyes() {
		yes.click();
	}

	public void clcikAARPbtn() {
		AARPbtn.click();
	}

	public void clickedit(String auditname, String date) {
		String record_x = "//tr//td//med-show-more/span[contains(text(),'" + auditname
				+ "')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"
				+ date + "')]//parent::med-show-more//parent::td//parent::tr//td[7]//button[1]";
		WebElement editelement = driver.findElement(By.xpath(record_x));
		editelement.click();
	}

	public void clickapproveedit() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aprbtn);
		Thread.sleep(3000);
		aprbtn.click();

	}

	public void clickclosedDtSbtn() {
		closedtsortbtn.click();
	}

	public void clickclsdbtn() throws InterruptedException {
		WaitHelper.sleepWait(2000);
		closedbtn.click();
	}

	public void verifyApprovedAudit(String auditname, String date) throws Exception {

		String record = "//med-list[@key='Closed-audits-list']//tr//span[contains(text(),'" + auditname
				+ "')]//ancestor::tr//td[4]/med-show-more/span[contains(text(),'" + date + "')]";
		WebElement closedrec = driver.findElement(By.xpath(record));
		
		boolean check = closedrec.isDisplayed();

		if (check) {
			BaseClass.log.info("Audit approve Pass!");
			assertTrue(true);
			//System.out.println("Audit approve Pass!");
		} else {
			BaseClass.log.info("Audit approve Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "ApproveAudit");
			assertTrue(false);
			//System.out.println("Audit approve Fail!");
		}

		//driver.navigate().refresh();

	}
	
	

	public void verify() throws InterruptedException {
		boolean check = false;
		for (int i = 0; i < 2; i++) {
			clickclosedDtSbtn();
			Thread.sleep(20000);
			try {
				WebElement closedrec = driver.findElement(By.xpath(""));
				boolean b = closedrec.isDisplayed();
				if (!check) {
					check = (b == true);
				}
			} catch (Exception e) {
				System.out.println("Inside exception");
			}
		}

		if (check) {
			System.out.println("Audit approve Pass!");
		} else {
			System.out.println("Audit approve Fail!");
		}
	}

}
