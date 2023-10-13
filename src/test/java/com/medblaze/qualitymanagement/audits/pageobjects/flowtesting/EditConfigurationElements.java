package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.utilities.WaitHelper;

public class EditConfigurationElements {

	WebDriver driver;

	public EditConfigurationElements(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='list-search']")
	WebElement search;

	@FindBy(xpath = "//span[text()='Submit ']")
	WebElement submit;
	
	public void clickSubmit() {
		WaitHelper.waitForElementtoBeClickable(submit, driver, 30);
		submit.click();
	}
	
	
	public void changeOrder(String from, String to) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		
		WebElement el=driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][3]//mat-cell[4]//textarea"));
		
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(el);
		new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 1200).perform();
		
		WebElement elefrom= driver.findElement(By.xpath("//span[text()=' "+from+"']//ancestor::med-ng-select//span[2][@class='ng-arrow-wrapper']"));	
		Thread.sleep(3000);		
		elefrom.click();
		Thread.sleep(1000);	
		WebElement eleto =driver.findElement(By.xpath("//div[@class='scrollable-content']//span[text()=' "+to+"']"));
		eleto.click();
	}
	
	public String getvalue(String no) throws InterruptedException {
		WaitHelper.sleepWait(2000);
		WebElement v = driver.findElement(
				By.xpath("//span[text()=' " + no + "']//ancestor::mat-cell//parent::tr//mat-cell[3]//textarea"));
		String value = v.getAttribute("value");
		return value;
	}
	
	
	public void clickeditbutton(String auditname) {
	WebElement editbutton=	driver.findElement(By.xpath("//span[contains(text(),'"+auditname+"')]//parent::med-show-more//parent::td//parent::tr//mat-icon[text()='edit']"));
		editbutton.click();
	}
	
	public void clickViewbutton(String auditname) {
		WebElement editbutton=	driver.findElement(By.xpath("//span[contains(text(),'"+auditname+"')]//parent::med-show-more//parent::td//parent::tr//mat-icon[text()='remove_red_eye']"));
			editbutton.click();
		}
	
	
	public void clickSearch(String input) throws InterruptedException {
		WaitHelper.sleepWait(2000);
		search.sendKeys(input);
	}

}
