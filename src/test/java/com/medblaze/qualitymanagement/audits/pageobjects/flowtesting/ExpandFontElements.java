package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.BaseTest.BaseClass;



public class ExpandFontElements {
	WebDriver driver;
	String Elementfontsize;
	String font;

	public ExpandFontElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//med-list[@key='Closed-audits-list']//med-ng-select[@label='Font size']//span[@class='ng-arrow-wrapper']")
	WebElement FontsizeDD;

	public void clickFSdd() {
		FontsizeDD.click();
	}

	public void selectfont(String font1) throws InterruptedException { // div[@class='ng-dropdown-panel-items
																		// scroll-host']
		font = font1;

		int font2 = Integer.parseInt(font1);
		if (font2 < 7) {
			WebElement font11 = driver
					.findElement(By.xpath("//div[@class='scrollable-content']//div//span[text()=' 11']"));
			Actions action = new Actions(driver);
			action.moveToElement(font11).perform();
			Thread.sleep(3000);
			WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(font11);
			new Actions(driver).scrollFromOrigin(scrollOrigin, 0, -200).perform();
			WebElement element = driver
					.findElement(By.xpath("//div[@class='scrollable-content']//div//span[text()=' " + font1 + "']"));
			element.click();
		} else {
			WebElement element = driver
					.findElement(By.xpath("//div[@class='scrollable-content']//div//span[text()=' " + font1 + "']"));
			element.click();
		}

	}

	public void verify() throws InterruptedException, IOException {

		List<WebElement> listele = driver
				.findElements(By.xpath("//med-list[@key='Closed-audits-list']//span[@id='ellipsis-ex']"));
		for (int i = 0; i < 2; i++) {
			Elementfontsize = listele.get(i).getCssValue("font-size");

		}
		if (Elementfontsize.contains(font)) {
			BaseClass.log.info("Font size Pass!");
			BaseClass.log.info(Elementfontsize);
			assertTrue(true);
			//System.out.println("Font size Pass!");
			//System.out.println(Elementfontsize);
		} else {
			BaseClass.log.info("Font Size Fail!");
			BaseClass.log.info(Elementfontsize);
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "CollapseandExpandFontsize");
			assertTrue(false);
			
			//System.out.println("Font Size Fail!");
			//System.out.println(Elementfontsize);
		}

	}

}
