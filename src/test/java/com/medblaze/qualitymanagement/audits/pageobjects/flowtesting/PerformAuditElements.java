package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;



public class PerformAuditElements {
	WebDriver driver;

	public PerformAuditElements(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Perform audit']")
	WebElement performbutton;

	@FindBy(xpath = "//div[text()='Audit Name']//ancestor::mat-card//span[text()='Submit ']")
	WebElement submit;
	
	@FindBy(xpath = "//span[text()='Save as draft ']")
	WebElement SaveasDraft;
	

	@FindBy(xpath = "//input[@id='employeeID']")
	WebElement employeeId;

	@FindBy(xpath = "//span[text()='Text Area']//ancestor::mat-form-field//textarea")
	WebElement textArea;
	
	@FindBy(xpath = "//mat-label[contains(text(),' Audit Date ')]//ancestor::div//button[@aria-label='Open calendar']")
	WebElement datepicker;
	
	@FindBy(xpath = "//*[local-name()='svg'][@class='mat-calendar-arrow']")
	WebElement yeardropdown;
	
	@FindBy(xpath = "//med-form-controls/div[contains(@id,'unitId')]")
	WebElement enterUnitname;
	
	public void clickDraft() {
		SaveasDraft.click();
	}

	public void enterTextArea(String input) {
		textArea.sendKeys(input);
	}

	public void enterNumericField(String num) {
		WebElement ele = driver.findElement(By.xpath("//input[@id='numericField']"));
		ele.sendKeys(num);
	}

	public void multiSelectdropdown(String value) {
		WebElement ele = driver.findElement(By.xpath("//div[text()='Multi Select Drop down']//parent::div//input"));
		ele.sendKeys(value);
		driver.findElement(By.xpath("//span[text()=' " + value + "']")).click();
	}

	public void clickcheckbox(String option) {
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+option+"')]//ancestor::label/span[@class='mat-checkbox-inner-container']"));
		ele.click();
	}

	public void clickRadiobutton(String rb) {
		WebElement element = driver.findElement(By.xpath("//span[text()='" + rb + "']//ancestor::label/span"));
		element.click();
	}

	public void enterReportingmanager(String input) {
		WebElement ele = driver.findElement(By.xpath("//div[text()='Reporting Manager']//parent::div//input"));
		ele.sendKeys(input);
		driver.findElement(By.xpath("//span[text()='Add item']")).click();
	}

	public void enterDepartment(String input) {
		WebElement ele = driver.findElement(By.xpath("//div[text()='Employee department']//parent::div//input"));
		ele.sendKeys(input);
		driver.findElement(By.xpath("//span[text()=' " + input + "']")).click();
	}

	public void enteremployeeId(String input) {
		employeeId.sendKeys(input);
	}
	
	public void enterUnitname(String unit) throws InterruptedException {
		WaitHelper.waitForElementtoBeVisible(enterUnitname, driver, 10);
		enterUnitname.click();
		WebElement ele= driver.findElement(By.xpath("//div[text()='Unit']//parent::div//input"));
		ele.sendKeys(unit);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),' "+unit+"')]")).click();
	}
	
	public void clickSubmit() {
		submit.click();
	}

	public void clickPerformAudit() {
		performbutton.click();
	}

	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	WebElement auditName;
	
	public void enterAuditName(String input) throws InterruptedException {
		WebElement AuditNameDD = driver.findElement(By.xpath("//div[contains(@class, 'ng-value-container')]/div[contains(text(),'Audit Name')]"));
		AuditNameDD.click();
		Thread.sleep(1000);

		WebElement AuditName1 = driver.findElement(By.xpath("//div[contains(text(),'Audit Name')]//parent::div//input"));
		AuditName1.sendKeys(input);
		driver.findElement(By.xpath("//span[text()=' " + input + "']")).click();
	}
	
	public void goToAuditListPage() {
		WebElement GoToListPageButton = new  WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Go to List Page')]")));
			GoToListPageButton.click();
	}
	
	public  void clickOnPerformNewAuditButton() {
		WebElement PerformNewAuditButton = new  WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Perform new audit')]")));
			PerformNewAuditButton.click();
	}
	
	
	public void verify(String auditname, String date) throws InterruptedException, IOException {
		WaitHelper.sleepWait(2000);
		String record = "//med-list[@key='Review Pending-audits-list']//tr//td//med-show-more/span[contains(text(),' "+auditname+"')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),' "+date+"')]";
		WebElement auditrecord = driver.findElement(By.xpath(record));
		boolean b = auditrecord.isDisplayed();
		if (b) {
			BaseClass.log.info("Perform Audit Pass!");
			assertTrue(true);
			//System.out.println("Perform Audit Pass!");
		}
		else {
			BaseClass.log.info("Perform Audit Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "PerformnewAudit");
			assertTrue(false);
			//System.out.println("Perform Audit Fail!");
		}

	}
	
	public void selectDate(String date) throws InterruptedException {
		int length= date.length();
		System.out.println(length);
		String DD="";
		String MM="";
		String YYYY="";
		if(length==11) {
			 DD=date.substring(0, 2);
			 MM=date.substring(3, 6);
			 YYYY=date.substring(7,11);
		}
		else if(length==10) {
			 DD=date.substring(0, 1);
			 MM=date.substring(2, 5);
			 YYYY=date.substring(6,10);
		}
		
			
		datepicker.click();			
		
		yeardropdown.click();	
		
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
		Thread.sleep(2000);
		WebElement Date = driver.findElement(By.xpath("//div[text()=' " + DD + " ']"));
		Date.click();
	}
	
}

