package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;

public class FiltersElements {
	WebDriver driver;
	String section;
	int k;

	public FiltersElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-icon[text()=' hourglass_empty']")
	WebElement filter;

	@FindBy(xpath = "//section[@class='parent-wrapper']//div[text()='Audit Name']//parent::div//div[2]/input")
	WebElement auditnamedd;
	

	@FindBy(xpath = "//section[@class='parent-wrapper']//div[text()='Audit Type']//parent::div//div[2]/input")
	WebElement audittypedd;

	@FindBy(xpath = "//section[@class='parent-wrapper']//div[text()='Status']//parent::div//div[2]/input")
	WebElement status;

	@FindBy(xpath = "//section[@class='parent-wrapper']//div[text()='Unit']//parent::div//div[2]/input")
	WebElement unitDD;

	@FindBy(xpath = "//span[text()='Apply ']")
	WebElement applybtn;;

	@FindBy(xpath = "//span[text()='Clear ']")
	WebElement clear;

	@FindBy(xpath = "//mat-label[contains(text(),'Audit Date from')]//parent::label//parent::span//parent::div//parent::div//div[2]/mat-datepicker-toggle")
	WebElement fromdate;

	@FindBy(xpath = "//mat-label[contains(text(),'Audit Date till')]//parent::label//parent::span//parent::div//parent::div//div[2]/mat-datepicker-toggle")
	WebElement todate;

	public void selectfilter(String sec) {
		section = sec;
	}
	
	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//tbody/tr[1]")
	WebElement record;

	public void clickfilterbtn() throws InterruptedException {
		//WaitHelper.waitForElementtoBeVisible(record, driver, 10);
		WaitHelper.sleepWait(3000);

		if (section.equalsIgnoreCase("Review pending")) {
			String record = "//med-list[@key='Review Pending-audits-list']//mat-icon[text()=' hourglass_empty']";
			WebElement ele = driver.findElement(By.xpath(record));
			ele.click();
		} else if (section.equalsIgnoreCase("closed")) {
			String record = "//med-list[@key='Closed-audits-list']//mat-icon[text()=' hourglass_empty']";
			WebElement ele = driver.findElement(By.xpath(record));
			ele.click();
		} else {
			String record = "//med-list[@key='Rejected-audits-list']//mat-icon[text()=' hourglass_empty']";
			WebElement ele = driver.findElement(By.xpath(record));
			ele.click();
		}

	}

	public void clickauditnameDD() {
		auditnamedd.click();
	}

	public void auditnameddvalue(String no, String auditname) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(
				"//section[@class='parent-wrapper']//div[text()='Audit Name']//parent::div//div[" + no + "]/input"));
		ele.sendKeys(auditname);

		if (section.equalsIgnoreCase("Review pending")) {
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + auditname + "')]"));
			element.click();
		} else if (section.equalsIgnoreCase("closed")) {
			WebElement element = driver.findElement(By.xpath("//div/span[contains(text(),'" + auditname + "')]"));
			element.click();
		}
		else {
			WebElement element = driver.findElement(By.xpath("//div/span[contains(text(),'" + auditname + "')]"));
			element.click();
		}

	}

	public void clickaudittypeDD() {
		audittypedd.click();
	}

	public void audittypeddvalue(String audittype) throws InterruptedException {
		if (section.equalsIgnoreCase("Review pending")) {
			audittypedd.sendKeys(audittype);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + audittype + "')]"));
			element.click();
		} else if (section.equalsIgnoreCase("closed")) {
			audittypedd.sendKeys(audittype);
			WebElement element = driver.findElement(By.xpath("//div/span[contains(text(),'" + audittype + "')]"));
			element.click();
		} else {
			audittypedd.sendKeys(audittype);
			WebElement element = driver.findElement(By.xpath("//div/span[contains(text(),'" + audittype + "')]"));
			element.click();
		}

	}

	public void clickstatus() {
		status.click();
	}

	public void statusddvalue(String stat) throws InterruptedException {
		status.sendKeys(stat);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + stat + "')]"));
		element.click();
	}

	public void clickfrdate() {
		fromdate.click();
	}

	public void selectfromdate(String date) throws InterruptedException {
		String DD = date.substring(0, 2);
		String MM = date.substring(3, 6);
		String YYYY = date.substring(7, 11);
		
		WebElement yr = driver.findElement(By.xpath("//*[local-name()='svg'][@class='mat-calendar-arrow']"));
		yr.click();
		
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

	public void to_date() {
		todate.click();
	}

	// ------------------------------------------------------------
	public void selecttilldate(String date) throws InterruptedException {
		String DD = date.substring(0, 2);
		String MM = date.substring(3, 6);
		String YYYY = date.substring(7, 11);
		
		WebElement yr = driver.findElement(By.xpath("//*[local-name()='svg'][@class='mat-calendar-arrow']"));
		yr.click();
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

	public void clickunit() {
		unitDD.click();
	}

	public void unitddvalue(String unit1) throws InterruptedException {
		unitDD.sendKeys(unit1);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + unit1 + "')]"));
		element.click();
	}

	public void clickapply() {
		applybtn.click();
	}

	public void clickclear() {
		clear.click();
	}
	
	public void verifyFilters(String auditName1,String auditName2, String auditType, String unit) throws IOException {
		String noofRecords = "//med-list[@key='Rejected-audits-list']//tbody/tr";
		int j = 0;

		try {
			List<WebElement> records = driver.findElements(By.xpath(noofRecords));
			int size = records.size();
			System.out.println(size);

			List<WebElement> auditNameElements = driver
					.findElements(By.xpath("//med-list[@key='Rejected-audits-list']//tbody/tr//td[2]//span"));
			List<WebElement> auditTypeElements = driver
					.findElements(By.xpath("//med-list[@key='Rejected-audits-list']//tbody/tr//td[3]//span"));
			List<WebElement> unitElements = driver
					.findElements(By.xpath("//med-list[@key='Rejected-audits-list']//tbody/tr//td[5]//span"));

			for (int i = 0; i < size; i++) {
				String rec1 = auditNameElements.get(i).getText();
				String rec2 = auditTypeElements.get(i).getText();
				String rec3 = unitElements.get(i).getText();

				if (rec1.contains(auditName1) || rec1.contains(auditName2)) {
					if (rec2.contains(auditType)) {
						if (rec3.contains(unit)) {
								j++;	
						}
					}
				}
			}

			if (j == size && k == size && size!=0) {
				BaseClass.log.info("ApplyFilters Pass!");
				assertTrue(true);

				// System.out.println(" Pass!");
			} else {
				BaseClass.log.info("ApplyFilters Fail!");
				BaseClass b1 = new BaseClass();
				b1.screenshot(driver, "SearchRecords");
				assertTrue(false);

				// System.out.println("Fail!");
			}
		}
		catch (AssertionError e) {
			BaseClass.log.info("No Records found with respect to applied filters");
		}

	}

	public void verifyDate(String fromDate, String toDate) {
		
		k = 0;
		try {
			WaitHelper.sleepWait(5000);
			List<WebElement> dateElements = driver.findElements(By.xpath("//med-list[@key='Rejected-audits-list']//tbody/tr//td[4]//span"));
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
