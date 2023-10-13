package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;


public class ReopenClosedAuditElements {	

		WebDriver driver;
		JavascriptExecutor js;
		String s1 = "50";

		public ReopenClosedAuditElements(WebDriver d) {
			driver = d;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//div[text()='Closed Date']")
		WebElement closedtsortbtn;

		@FindBy(xpath = "//span[contains(text(),'Reopen')]")
		WebElement reopn;

		@FindBy(xpath = "//div[@id='dateOfAudit_time']//span[text()='Mins']//parent::label/parent::span//parent::div/mat-select/div/div/span/span")
		WebElement mins;

		@FindBy(xpath = "//div[@id='dateOfAudit_time']//span[text()='Mins']//parent::label/parent::span//parent::div/mat-select")
		WebElement minsdd;

		@FindBy(xpath = "//span[contains(text(),'Submit ')]")
		WebElement submitbtn;

		@FindBy(xpath = "//span[contains(text(),'Go to List Page ')]")
		WebElement gotolist;

		@FindBy(xpath = "//div[@id='dateOfAudit']//med-keyvalue/div//div[2]")
		WebElement datedetails;

		public void clickgotolist() {
			gotolist.click();
		}

		public void clicksubmit() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitbtn);
			Thread.sleep(10000);
			driver = (WebDriver) js;
			submitbtn.click();
		}

		public void clickclosedDtSbtn() {
			closedtsortbtn.click();
		}

		public void clickreopen() {
			reopn.click();
		}

		public void action(String auditname, String date) throws InterruptedException {
			String record = "//med-list[@key='Closed-audits-list']//tr//td//med-show-more/span[contains(text(),'"
					+ auditname
					+ "')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"
					+ date + "')]";

			boolean check = false;
			for (int i = 0; i < 2; i++) {
				clickclosedDtSbtn();
				Thread.sleep(25000);
				try {
					WebElement closedrec = driver.findElement(By.xpath(record));
					boolean b = closedrec.isDisplayed();
					if (!check) {
						check = (b == true);
					}
				} catch (Exception e) {
					System.out.print("Inside exception");
				}
			}

			if (check) {
				WebElement reopen = driver.findElement(By.xpath(
						"//med-list[@key='Closed-audits-list']//tr//td//med-show-more/span[contains(text(),'" + auditname
								+ "')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"
								+ date + "')]//parent::med-show-more//parent::td//parent::tr//td[10]//button[3]"));
				reopen.click();
				clickreopen();
				String s = getminsvalue();
				System.out.println(s);
				clickminsdropdown();
				selectminvalue(s1);
				clicksubmit();
				Thread.sleep(5000);
				clickgotolist();

			} else {
				System.out.println("Audit not found!");
			}

		}

		private void selectminvalue(String s12) {
			// TODO Auto-generated method stub
			
		}

		private void clickminsdropdown() {
			// TODO Auto-generated method stub
			
		}

		private String getminsvalue() {
			// TODO Auto-generated method stub
			return null;
		}

		public void verifydetails(String auditname, String date) throws InterruptedException, IOException {

			WebElement details = driver.findElement(By
					.xpath("//med-list[@key='Closed-audits-list']//tr//td//med-show-more/span[contains(text(),'" + auditname
							+ "')]//parent::med-show-more//parent::td//parent::tr//td[4]/med-show-more/span[contains(text(),'"
							+ date + "')]//parent::med-show-more//parent::td//parent::tr//td[10]//button[1]"));
			details.click();
			Thread.sleep(5000);
			WebElement e = driver.findElement(By.xpath("//div[@id='dateOfAudit']//div[@class='value mat-body-2']"));
			String s2 = e.getText();
			String s3 = s2.substring(15, 17);

			int i1 = Integer.parseInt(s1);
			int i2 = Integer.parseInt(s3);

			if (i1 == i2) {
				System.out.println("Pass!");
			} else {
				BaseClass b= new BaseClass();
				b.screenshot(driver, "reopen");
				System.out.println("Fail!");
			}
		}
}
