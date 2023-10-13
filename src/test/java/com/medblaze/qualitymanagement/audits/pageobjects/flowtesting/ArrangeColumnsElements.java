package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;

public class ArrangeColumnsElements {
	WebDriver driver;
	public String section;
	String elementxpath;

	public ArrangeColumnsElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//mat-icon[text()='low_priority']")
	WebElement reviewarrangecolumns;

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//mat-icon[text()='low_priority']")
	WebElement closedarrangecolumns;

	@FindBy(xpath = "//med-list[@key='Rejected-audits-list']//mat-icon[text()='low_priority']")
	WebElement rejectedarrangecolumns;

	@FindBy(xpath = "//mat-icon[text()='close']")
	WebElement close;

	public void toogleSelection(String fieldname) throws InterruptedException, IOException {
       boolean result;
		WebElement tabletoogle = driver
				.findElement(By.xpath("//div[contains(text(),'" + fieldname + "')]//parent::div//div[3]//button"));
		tabletoogle.click();
		String checked = tabletoogle.getAttribute("aria-checked");
		//Thread.sleep(2000);
		close.click();
		//Thread.sleep(2000);
		if (checked.equalsIgnoreCase("true")) {
			try {
				WebElement field = driver.findElement(
						By.xpath("//med-list[@key='" + elementxpath + "']//div[contains(text(),'" + fieldname + "')]"));
				boolean b = field.isDisplayed();
				//result=true;
				BaseClass.log.info("Arrangecolumn Pass!");
				assertTrue(true);
				
				//System.out.println("pass!");
			} catch (Exception e) {
				BaseClass.log.info("Field is not Available");
				BaseClass.log.info("Arrangecolumn Fail!");
				BaseClass b1 = new BaseClass();
				b1.screenshot(driver, "ArrangeColumnFields");
				assertTrue(false);
				
				//System.out.println("Field is not Available");
				//System.out.println("Fail!");
			}

		} else {
			try {
				//Thread.sleep(2000);
				WebElement field = driver.findElement(
						By.xpath("//med-list[@key='" + elementxpath + "']//div[contains(text(),'" + fieldname + "')]"));
				boolean b = field.isDisplayed();
				BaseClass.log.info("Arrangecolumn Fail!");
				BaseClass.log.info("Field is Available");
				BaseClass b1 = new BaseClass();
				b1.screenshot(driver, "ArrangeColumnFields");
				assertTrue(false);
				
				//System.out.println("Fail!");
				//System.out.println("Field is Available");
			} catch (Exception e) {
				BaseClass.log.info("Arrangecolumn Pass!");
				assertTrue(true);
				//System.out.println("Pass!e");
			}

		}
	}

	public void selectfilter(String sec) {
		section = sec;

		if (sec.equalsIgnoreCase("Review pending")) {
			elementxpath = "Review Pending-audits-list";
		} else if (sec.equalsIgnoreCase("closed")) {
			elementxpath = "Closed-audits-list";
		} else {
			elementxpath = "Rejected-audits-list";
		}

	}

	public void clickarrangecolumns() {
		if (section.equalsIgnoreCase("Review pending")) {
			reviewarrangecolumns.click();
		} else if (section.equalsIgnoreCase("closed")) {
			closedarrangecolumns.click();
		} else {
			rejectedarrangecolumns.click();
		}
	}

}
