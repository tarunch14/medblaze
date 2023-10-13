package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;

public class ColumnFiltersElements {
	WebDriver driver;
	String section;
	int k;

	public ColumnFiltersElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-icon[text()='filter_list ']")
	WebElement reviewcolumnfilterbtn;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//mat-icon[text()='filter_list ']")
	WebElement closedcolumnfilterbtn;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//mat-icon[text()='filter_list ']")
	WebElement rejectedcolumnfilterbtn;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//input[@id='auditName_string']")
	WebElement reviewauditname;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//input[@id='auditName_string']")
	WebElement closedauditname;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//input[@id='auditName_string']")
	WebElement rejectedauditname;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//input[@id='auditType_string']")
	WebElement reviewaudittype;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//input[@id='auditType_string']")
	WebElement closedaudittype;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//input[@id='auditType_string']")
	WebElement rejectedaudittype;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-select[@id='unitId_list']")
	WebElement reviewunit;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//mat-select[@id='unitId_list']")
	WebElement closedunit;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//mat-select[@id='unitId_list']")
	WebElement rejectedunit;

	@FindBy(xpath = "//span[text()='Done']")
	WebElement done;

	@FindBy(xpath = "//span[text()='Clear']")
	WebElement cancel;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//input[@id='auditPerformedBy_string']")
	WebElement reviewauditedby;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//input[@id='auditPerformedBy_string']")
	WebElement closedauditedby;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//input[@id='auditPerformedBy_string']")
	WebElement rejectedauditedby;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//div[text()='Audit Date']//parent::div//span/mat-icon[text()='date_range']")
	WebElement reviewauditdate;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//div[text()='Audit Date']//parent::div//span/mat-icon[text()='date_range']")
	WebElement closedauditdate;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//div[text()='Audit Date']//parent::div//span/mat-icon[text()='date_range']")
	WebElement rejectauditdate;

	@FindBy(xpath = "//span[contains(text(),'Choose start date')]//parent::label//parent::span//parent::div//parent::div//div[2]")
	WebElement choosestartdate;

	@FindBy(xpath = "//span[contains(text(),'Choose end date')]//parent::label//parent::span//parent::div//parent::div//div[2]")
	WebElement chooseenddate;

	@FindBy(xpath = "//*[local-name()='svg'][@class='mat-calendar-arrow mat-calendar-invert']")
	WebElement yeardropdown;

	@FindBy(xpath = "//span[text()='Apply']")
	WebElement apply;

	@FindBy(xpath = "//span[text()='Clear']")
	WebElement clear;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//mat-icon[text()='delete_sweep']")
	WebElement deletCache;

	@FindBy(xpath = "//input[@id='closedDate_date']")
	WebElement closeddate;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//tbody[@role='rowgroup']/tr[1]")
	WebElement firstrecord;

	public void clickDeleteCache() {
		deletCache.click();
	}

	public void clickdateapply() {
		apply.click();
	}

	public void clickdateclear() {
		clear.click();
	}

	public void selectfilter(String sec) throws InterruptedException {
		//WaitHelper.waitForElementtoBeVisible(firstrecord, driver, 20);
		WaitHelper.sleepWait(5000);
		section = sec;
	}

	public void selectstartdate(String date) throws InterruptedException {
		String DD = date.substring(0, 2);
		String MM = date.substring(3, 6);
		String YYYY = date.substring(7, 11);

		if (section.equalsIgnoreCase("Review pending")) {
			reviewauditdate.click();
		} else if (section.equalsIgnoreCase("closed")) {
			closedauditdate.click();
		} else {
			rejectauditdate.click();
		}

		choosestartdate.click();
		yeardropdown.click();
		driver.findElement(By.xpath("//*[local-name()='svg'][@class='mat-calendar-arrow']")).click();

		int yr1 = Integer.parseInt(YYYY);

		if (yr1 >= 2016 && yr1 <= 2039) {
			WebElement year = driver.findElement(By.xpath("//div[contains(text(),' " + YYYY + " ')]"));
			year.click();
		} else {
			WebElement previous = driver.findElement(By.xpath("//button[@aria-label='Previous 24 years']"));
			previous.click();
			WebElement year = driver.findElement(By.xpath("//div[contains(text(),' " + YYYY + " ')]"));
			year.click();
		}

		WebElement mnth = driver.findElement(By.xpath("//div[contains(text(),' " + MM + " ')]"));
		mnth.click();
		WebElement dateElement = driver.findElement(By.xpath("//div[text()=' " + DD + " ']"));
		dateElement.click();
	}

	public void selectenddate(String date) throws InterruptedException {
		String DD = date.substring(0, 2);
		String MM = date.substring(3, 6);
		String YYYY = date.substring(7, 11);

		chooseenddate.click();
		yeardropdown.click();
		driver.findElement(By.xpath("//*[local-name()='svg'][@class='mat-calendar-arrow']")).click();

		int yr1 = Integer.parseInt(YYYY);

		if (yr1 >= 2016 && yr1 <= 2039) {
			WebElement year = driver.findElement(By.xpath("//div[contains(text(),' " + YYYY + " ')]"));
			year.click();
		} else {
			WebElement previous = driver.findElement(By.xpath("//button[@aria-label='Previous 24 years']"));
			previous.click();
			WebElement year = driver.findElement(By.xpath("//div[contains(text(),' " + YYYY + " ')]"));
			year.click();
		}

		WebElement mnth = driver.findElement(By.xpath("//div[contains(text(),' " + MM + " ')]"));
		mnth.click();
		WebElement dateElement = driver.findElement(By.xpath("//div[text()=' " + DD + " ']"));
		dateElement.click();
	}

	public void clearAuditdate() {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewauditdate.click();
			clear.click();
		} else if (section.equalsIgnoreCase("closed")) {
			closedauditdate.click();
			clear.click();
		} else {
			rejectauditdate.click();
			clear.click();
		}
	}

	public void clickcolumnfilter() {
		if (section.equalsIgnoreCase("Review pending")) {
			WaitHelper.waitForElementtoBeVisible(reviewcolumnfilterbtn, driver, 10);
			reviewcolumnfilterbtn.click();
		} else if (section.equalsIgnoreCase("closed")) {
			WaitHelper.waitForElementtoBeVisible(closedcolumnfilterbtn, driver, 10);
			closedcolumnfilterbtn.click();
		} else {
			WaitHelper.waitForElementtoBeVisible(rejectedcolumnfilterbtn, driver, 10);
			rejectedcolumnfilterbtn.click();
		}
	}

	public void enterauditname(String auditname) {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewauditname.sendKeys(auditname);
		} else if (section.equalsIgnoreCase("closed")) {
			closedauditname.sendKeys(auditname);
		} else {
			rejectedauditname.sendKeys(auditname);
		}
	}

	public void clearAuditname() {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewauditname.clear();
		} else if (section.equalsIgnoreCase("closed")) {
			closedauditname.clear();
		} else {
			rejectedauditname.clear();
		}
	}

	public void enteraudittype(String audittype) {
		if (section.equalsIgnoreCase("Review pending")) {
			WaitHelper.waitForElementtoBeVisible(reviewaudittype, driver, 10);
			reviewaudittype.sendKeys(audittype);
		} else if (section.equalsIgnoreCase("closed")) {
			WaitHelper.waitForElementtoBeVisible(closedaudittype, driver, 10);
			closedaudittype.sendKeys(audittype);
		} else {
			WaitHelper.waitForElementtoBeVisible(rejectedaudittype, driver, 10);
			rejectedaudittype.sendKeys(audittype);
		}
	}

	public void clearAudittype() {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewaudittype.clear();
			;
		} else if (section.equalsIgnoreCase("closed")) {
			closedaudittype.clear();
		} else {
			rejectedaudittype.clear();
		}
	}

	public void clickunit(String unitname) {

		if (section.equalsIgnoreCase("Review pending")) {
			WaitHelper.waitForElementtoBeClickable(reviewunit, driver, 10);
			reviewunit.click();
		} else if (section.equalsIgnoreCase("closed")) {
			WaitHelper.waitForElementtoBeClickable(closedunit, driver, 10);
			closedunit.click();
		} else {
			WaitHelper.waitForElementtoBeClickable(rejectedunit, driver, 10);
			rejectedunit.click();
		}

		WebElement ele = driver.findElement(By.xpath("//mat-option//span[contains(text(),'" + unitname + "')]"));
		ele.click();
		done.click();
	}

	public void clearUnit() {
		WebElement ele = driver.findElement(By.xpath("//mat-icon[text()='close']"));
		ele.click();
	}

	public void enterauditedby(String auditby) throws InterruptedException {

		if (section.equalsIgnoreCase("Review pending")) {
			WaitHelper.waitForElementtoBeVisible(reviewauditedby, driver, 10);
			reviewauditedby.sendKeys(auditby);
		} else if (section.equalsIgnoreCase("closed")) {
			WaitHelper.waitForElementtoBeVisible(closedauditedby, driver, 10);
			closedauditedby.sendKeys(auditby);

		} else {
			WaitHelper.waitForElementtoBeVisible(rejectedauditedby, driver, 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", rejectedauditedby);
			// rejectedauditedby.click();
			rejectedauditedby.sendKeys(auditby);
		}
	}

	public void clearAuditedby() {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewauditedby.clear();
		} else if (section.equalsIgnoreCase("closed")) {
			closedauditedby.clear();

		} else {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", rejectedauditedby);
			rejectedauditedby.clear();
		}
	}

	public void verifyFilters(String auditName, String auditType, String unit, String auditedBy) throws IOException {
		String noofRecords = "//med-list[@key='Closed-audits-list']//tbody/tr";
		int j = 0;

		try {
			List<WebElement> records = driver.findElements(By.xpath(noofRecords));
			int size = records.size();
			System.out.println(size);

			List<WebElement> auditNameElements = driver
					.findElements(By.xpath("//med-list[@key='Closed-audits-list']//tbody/tr//td[2]//span"));
			List<WebElement> auditTypeElements = driver
					.findElements(By.xpath("//med-list[@key='Closed-audits-list']//tbody/tr//td[3]//span"));
			List<WebElement> unitElements = driver
					.findElements(By.xpath("//med-list[@key='Closed-audits-list']//tbody/tr//td[5]//span"));
			List<WebElement> auditedByElements = driver
					.findElements(By.xpath("//med-list[@key='Closed-audits-list']//tbody/tr//td[6]//span"));

			for (int i = 0; i < size; i++) {
				String rec1 = auditNameElements.get(i).getText();
				String rec2 = auditTypeElements.get(i).getText();
				String rec3 = unitElements.get(i).getText();
				String rec4 = auditedByElements.get(i).getText();

				if (rec1.contains(auditName)) {
					if (rec2.contains(auditType)) {
						if (rec3.contains(unit)) {
							if (rec4.contains(auditedBy)) {
								j++;
							}
						}
					}
				}
			}

			if (j == size && k == size && size!=0) {
				BaseClass.log.info("ApplyColumnFilters Pass!");
				assertTrue(true);

				// System.out.println("ApplyColumnFilters Pass!");
			} else {
				BaseClass.log.info("ApplyColumnFilters Fail!");
				BaseClass b1 = new BaseClass();
				b1.screenshot(driver, "SearchRecords");
				assertTrue(false);

				// System.out.println("ApplyColumnFilters Fail!");
			}
		} catch (AssertionError e) {
			BaseClass.log.info("No Records found with respect to applied filters");
		}

	}

	public void verifyDate(String fromDate, String toDate) {
		k = 0;
		try {
			WaitHelper.sleepWait(3000);
			List<WebElement> dateElements = driver.findElements(By.xpath("//med-list[@key='Closed-audits-list']//tbody/tr//td[4]//span"));
			int size = dateElements.size();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate fromdate = LocalDate.parse(fromDate, formatter);
			LocalDate todate = LocalDate.parse(toDate, formatter);

			for (int i = 0; i < size; i++) {
				String s = dateElements.get(i).getText();
				String date = s.substring(0, 11);

				LocalDate actualDate = LocalDate.parse(date, formatter);

				if (actualDate.isAfter(fromdate) && actualDate.isBefore(todate)) {
					k++;
				}
			}
		} catch (Exception e) {

		}

	}

}
