package com.medblaze.utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.PageFactory;

public class utilityMethods {
	WebDriver driver;
	
	public utilityMethods(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public void scrolltoelement(WebElement ele,int x,int y) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(3000);
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(ele);
		new Actions(driver).scrollFromOrigin(scrollOrigin, x, y).perform();
	}
	
	public static String generateRandomString(int length) {
		String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characterSet.length());
			char randomChar = characterSet.charAt(randomIndex);
			stringBuilder.append(randomChar);
		}

		return stringBuilder.toString();
	}

}
