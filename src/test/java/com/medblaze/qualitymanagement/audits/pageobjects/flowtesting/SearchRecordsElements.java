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


public class SearchRecordsElements {

	WebDriver driver;

	public SearchRecordsElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	public static String Record_X = "//med-list[@key='Review Pending-audits-list']//tr[@class='mat-row cdk-row ng-star-inserted']//td[2]//med-show-more/span[@id='ellipsis-ex']";

	@FindBy(xpath = "//div[@class='mat-tab-labels']//div[text()='Review pending']")
	WebElement Reviewpending;

	@FindBy(xpath = "//med-list[@key='Review Pending-audits-list']//div/input[@id='list-search']")
	WebElement search;

	public void clickreview() {
		Reviewpending.click();
	}

	public void clicksearch(String input) {
		search.sendKeys(input);
	}
	
	public void clearSearch() {
		search.clear();
	}

	public void find_records(String input) throws IOException {
		int j=0;
		List<WebElement> records = driver.findElements(By.xpath(Record_X));
		int size = records.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {
			String rec = records.get(i).getText();
			if (rec.contains(input)) {
				j++;
		       }
	    }
		if(j==size) {
			BaseClass.log.info("Search Pass!");
			assertTrue(true);
			//System.out.println("Search Pass!");
		    }
		else {
			BaseClass.log.info("Search Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "SearchRecords");
			assertTrue(false);

			//System.out.println("Search Fail!");
			//System.out.println(j);
		    }
	}
	

}
		
	
