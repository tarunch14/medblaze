package com.medblaze.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.medblaze.BaseTest.BaseClass;

public class WaitHelper extends BaseClass {
	
	public static WebDriverWait wait;
	public static void waitForElementtoBeVisible(WebElement we, WebDriver driver, long sec)
	{
		//log.info("Waiting for the WebElement "+we+" for "+sec);
		wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public static void waitForElementtoBeClickable(WebElement we, WebDriver driver, long sec)
	{
		//log.info("Waiting for the WebElement "+we+" for "+sec);
		wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public static void sleepWait(long sec) throws InterruptedException
	{
		//log.info("Waiting for the WebElement for "+sec);
		Thread.sleep(sec);
	}

}
