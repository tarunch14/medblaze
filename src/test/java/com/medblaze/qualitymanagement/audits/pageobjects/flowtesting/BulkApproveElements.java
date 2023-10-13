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



public class BulkApproveElements {
	WebDriver driver;
	int size;
	int count;

	public BulkApproveElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//mat-icon[text()='check_box_outline_blank']")
	WebElement bulkbtn;

	@FindBy(xpath = "//span[text()='Bulk Approve']")
	WebElement Bulkapprovebtn;

	@FindBy(xpath = "//div/button[1]/span/mat-icon[text()='check_circle_outline']")
	WebElement bulkapprovebtn;

	@FindBy(xpath = "//textarea[@data-placeholder='Please enter your comments']")
	WebElement entercomments;

	@FindBy(xpath = "//mat-icon[text()='check']")
	WebElement yes;

	@FindBy(xpath = "//span[text()='Bulk Reject']")
	WebElement Rejectbtn;

	@FindBy(xpath = "//mat-icon[text()='cancel']")
	WebElement rej;

	@FindBy(xpath = "//div//button[2]//mat-icon[text()='close']")
	WebElement No;

	@FindBy(xpath = "//div[text()='Rejected']")
	WebElement rejectedlist;

	@FindBy(xpath = "//div[text()='Rejected Date']")
	WebElement Rejdatesort;

	public void clickNo() {
		No.click();
	}

	public void clickrej() {
		rej.click();
	}

	public void clickbulkreject() {
		Rejectbtn.click();
	}

	public void clickbulkbtn() {
		bulkbtn.click();
	}

	public void clickBulkapprovebtn() {
		Bulkapprovebtn.click();
	}

	public void selectkaudits(String auditname, String date) {
		String record_X = "//tr//td//med-show-more/span[contains(text(),'" + auditname
				+ "')]//parent::med-show-more//parent::td//parent::tr//td[5]/med-show-more/span[contains(text(),'"
				+ date
				+ "')]//parent::med-show-more//parent::med-show-more//parent::td//parent::tr//td[2]//mat-checkbox";
		List<WebElement> element = driver.findElements(By.xpath(record_X));
		 size = element.size();
		
		for (int i = 0; i < size; i++) {
			element.get(i).click();
		}
	}

	public void clickbulkaprbtn() {
		bulkapprovebtn.click();
	}

	public void entercomments(String comments) {
		entercomments.sendKeys(comments);
	}

	public void clickyes() {
		yes.click();
	}

	public void verifyrejlist(String auditname, String date) throws InterruptedException, IOException {
		String rec_X = "//med-list[@key='Rejected-audits-list']//tr//td//med-show-more/span[contains(text(),'"
				+ auditname
				+ "')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"
				+ date + "')]";
		rejectedlist.click();

		boolean check = false;
		for (int i = 0; i < 2; i++) {
			Rejdatesort.click();
			Thread.sleep(5000);
			try {
				List<WebElement> Rejectedrec = driver.findElements(By.xpath(rec_X));
				count = Rejectedrec.size();
				for (int j = 0; j < count; j++) {
					boolean b = Rejectedrec.get(j).isDisplayed();
					if (!check) {
						check = (b == true);
					}

				}
			} catch (Exception e) {
				System.out.print("Inside exception");
			}
		}

		if (check && (count == size)) {
			BaseClass.log.info("Bulk approve PASS!");
			assertTrue(true);
			//System.out.print("Bulk approve PASS!");
		} else {
			BaseClass.log.info("Bulk Approve Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "ApproveandRejectAuditbyBulkaction");

			//System.out.println("Bulk Approve Fail!");
		}
	}

}
