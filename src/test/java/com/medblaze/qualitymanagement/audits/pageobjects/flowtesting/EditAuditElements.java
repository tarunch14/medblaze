package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.utilities.WaitHelper;
import com.medblaze.utilities.utilityMethods;


public class EditAuditElements {
	WebDriver driver;

	public EditAuditElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	String Audit_Name = "Handover";

	public String View_X = "//tr//td//med-show-more/span[contains(text(),'" + Audit_Name
			+ "')]//parent::med-show-more//parent::td//parent::tr//td[7]//button[2]";

	@FindBy(xpath = "//a[text()='Audits']")
	WebElement Audits;

	@FindBy(xpath = "//div[4]//ul//li[3]/div//li[3]/a[text()=' List']")
	WebElement list;

	@FindBy(xpath = "//div[@class='mat-tab-labels']//div[text()='Review pending']")
	WebElement Reviewpending;

	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-5']//span")
	WebElement radiobtn;

	@FindBy(xpath = "//span[text()='Save as draft ']")
	WebElement draft;

	@FindBy(xpath = "//span[text()='Submit ']")
	WebElement Submit;

	@FindBy(xpath = "//med-module-redirection/div/button[1]")
	WebElement Go_to_List;

	@FindBy(xpath = "//input[@id='list-search']")
	WebElement search;

	@FindBy(xpath = "//input[@id='reasonOrDetails']")
	WebElement reasons;

	@FindBy(xpath = "//span[contains(text(),'Go to List Page ')]")
	WebElement gotoListpage;

	public void clickgotoListpage() {
		gotoListpage.click();
	}

	public void verify(String auditname, String date) throws InterruptedException, IOException {

		String record1 = "//span[contains(text(),' " + auditname + "')]//ancestor::tr//td[4]//span[contains(text(),'"
				+ date + "')]";
		WebElement closedrec = driver.findElement(By.xpath(record1));
		boolean b = closedrec.isDisplayed();

		if (b == true) {
			BaseClass.log.info("Edit Audit PASS!");
			assertTrue(true);
			//System.out.print("Edit Audit PASS!");
		} else {
			BaseClass.log.info("Edit Audit Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "EditExistingAudit");
			assertTrue(false);

			//System.out.println("Edit Audit Fail!");
		}
	}

	public void searchAudit(String input) {
		WaitHelper.waitForElementtoBeVisible(search, driver, 10);
		search.sendKeys(input);
	}

	public void clickRadiobutton(String rb) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//span[text()='" + rb + "']//ancestor::label/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();
	}

	public void enterReason(String inp) {
		reasons.sendKeys(inp);
	}

	public void clicksubmit() {
		Submit.click();
	}

	public void clickaudits() {
		WaitHelper.waitForElementtoBeVisible(Audits, driver, 10);
		Audits.click();
	}

	public void clicklist() {
		WaitHelper.waitForElementtoBeClickable(list, driver, 10);
		list.click();
	}

	public void clickReviewpending() {
		Reviewpending.click();
	}

	public void clickedit(String Audit_Name, String date) {
		WebElement edit = driver.findElement(By.xpath("//med-list[@key='Review Pending-audits-list']//span[contains(text(),'"+Audit_Name+"')]//ancestor::tbody/tr[1]//span[contains(text(),'"+date+"')]//ancestor::tr//td[7]//button[1]"));
		WaitHelper.waitForElementtoBeVisible(edit, driver, 10);
		edit.click();
	}

	public void clickradiobtn() {
		radiobtn.click();
	}

	public WebElement scrollradiobtn() {
		return radiobtn;
	}

	public void clickdraft() {
		draft.click();
	}

	public WebElement scrolldraft() {
		return draft;
	}

	public void click_gotolist() {
		Go_to_List.click();
	}

	public void clickview() {
		WebElement viewbtn = driver.findElement(By.xpath(View_X));
		viewbtn.click();
	}

}
