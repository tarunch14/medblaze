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




public class NavigationElements {

	WebDriver driver;
	int tt = 0;

	public NavigationElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//div[@class='mat-paginator-range-label']")
	WebElement number;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//button[@aria-label='Previous page']")
	WebElement previouspage;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//button[@aria-label='Next page']")
	WebElement nextpage;

	public int getrecordcount() {
		String s = number.getText();
		String s1 = s.substring(11, 13);
		int total = Integer.parseInt(s1);
		return total;
	}

	public void action() throws InterruptedException {

		List<WebElement> records = driver.findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']"));
		int size = records.size();
		tt = tt + size;

		for (int i = 0; i < 1; i--) {
			try {
				WebElement e = driver.findElement(By.xpath(
						"//med-list[@key='Review Pending-audits-list']//button[@aria-label='Next page' and @disabled='true']"));
				boolean b = e.isDisplayed();
				if (b == true) {
					break;
				}
			} catch (Exception e) {
				nextpage.click();
				Thread.sleep(3000);
				List<WebElement> record = driver
						.findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']"));
				int size1 = record.size();
				tt = tt + size1;
			}
		}

	}

	// ---------------------------------------------
	/*
	 * for (int i = 0; i < 1; i--) { String s = nextpage.getAttribute("disabled");
	 * System.out.println(s);
	 * 
	 * if (s != null && s.equals("true")) {
	 * 
	 * System.out.println(tt); System.out.println("into if block");
	 * 
	 * } else { System.out.println("into else block"); break; }
	 * 
	 * }
	 */

	// ----------------------------------

	public void verify() throws IOException {
		if (tt == getrecordcount()) {
			BaseClass.log.info("Navigation Pass!");
			assertTrue(true);
			clickPreviouspage();
			
     		//System.out.println("Navigation Pass!");
			// System.out.println(tt);
		} else {
			BaseClass.log.info("Navigation Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "NavigationbetweenNextandPreviouspage");
			assertTrue(false);
			
			//System.out.println("Navigation Fail!");
			// System.out.println(tt);
		}
	}

	public void clickPreviouspage() {
		previouspage.click();
	}

	public void clicknextpage() {
		nextpage.click();
	}

}
