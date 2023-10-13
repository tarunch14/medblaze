package com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputTestingofTextFieldElements {
	WebDriver driver;

	public InputTestingofTextFieldElements(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
	}

	String[] inputs = {"    ", "tarun kumar" ,"tarunkumar", "TARUNKUMAR", "TARUNkumar", "8919158393", "!@#$%^&*",
			"tarUN8393", "t!a@r#u$n", "!8@9#1$9%09",};

	@FindBy(xpath = "//span[text()=' Section 1: Employee details ']/ancestor::mat-card[1]//input[@type='text']")
	WebElement textfield;

	@FindBy(xpath = "//mat-error[contains(text(),'Invalid input')]")
	WebElement error;

	@FindBy(xpath = "//mat-icon[text()='help_outline ']")
	WebElement escape;

	@FindBy(xpath = "//med-input//mat-icon[text()='close']")
	WebElement clearbutton;
	
	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	WebElement calenderButton;
	
	@FindBy(xpath = "//mat-icon[text()='close']")
	WebElement cancel;
	
	public void checkclearButton() throws Throwable {
		sendInput("manoj");
		escapeCurser();
		Thread.sleep(2000);
		cancel.click();
		escapeCurser();
		String s2 = textfield.getAttribute("value");
		if (s2.equalsIgnoreCase("")) {
			System.out.println("Clear button Pass!");
		}
		else {
			System.out.println("Clear button Fail!");
		}
	}
	
	public void clickCalenderbutton() {
		cancel.click();
	}

	public void clickClearbutton() {
		clearbutton.click();
	}

	public boolean verifyError() {
		boolean b = true;
		try {
			driver.findElement(By.xpath("//mat-error[contains(text(),'Invalid input')]"));
			b = true;
		} catch (NoSuchElementException e) {
			b = false;
		}
		return b;
	}

	public void sendInput(String input) {
		textfield.sendKeys(input);
	}

	public void escapeCurser() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void clearInput() {
		textfield.clear();
	}
	
	

	public void verify() throws InterruptedException, Throwable {

		for (String s : inputs) {

			switch (s) {

			case "tarunkumar":
				sendInput(s);
				escapeCurser();
				boolean b = verifyError();
				if (b) {
					System.out.println("case:1 Fail!");
				}
				clearInput();
				System.out.println("case:1 Pass!");
				break;

			case "TARUNKUMAR":
				sendInput(s);
				escapeCurser();
				boolean b1 = verifyError();
				if (b1) {
					System.out.println("case:2 Fail!");
				}
				clearInput();
				System.out.println("case:2 Pass!");
				break;

			case "TARUNkumar":
				sendInput(s);
				escapeCurser();
				boolean b2 = verifyError();
				if (b2) {
					System.out.println("case:3 Fail!");
				}
				clearInput();
				System.out.println("case:3 Pass!");
				break;

			case "8919158393":
				sendInput(s);
				escapeCurser();
				boolean b3 = verifyError();
				if (b3) {
					System.out.println("case:4 Fail!");
				}
				clearInput();
				System.out.println("case:4 Pass!");
				break;

			case "!@#$%^&*":
				sendInput(s);
				escapeCurser();
				boolean b4 = verifyError();
				if (b4) {
					System.out.println("case:5 Fail!");
				}
				clearInput();
				System.out.println("case:5 Pass!");
				break;

			case "tarUN8393":
				sendInput(s);
				escapeCurser();
				boolean b5 = verifyError();
				if (b5) {
					System.out.println("case:6 Fail!");
				}
				clearInput();
				System.out.println("case:6 Pass!");
				break;

			case "t!a@r#u$n":
				sendInput(s);
				escapeCurser();
				boolean b6 = verifyError();
				if (b6) {
					System.out.println("case:7 Fail!");
				}
				clearInput();
				System.out.println("case:7 Pass!");
				break;

			case "!8@9#1$9%09":
				sendInput(s);
				escapeCurser();
				boolean b7 = verifyError();
				if (b7) {
					System.out.println("case:8 Fail!");
				}
				clearInput();
				System.out.println("case:8 Pass!");
				break;

			case "tarun kumar":
				sendInput(s);
				escapeCurser();
				boolean b8 = verifyError();
				if (b8) {
					System.out.println("case:9 Fail!");
				}
				clearInput();
				System.out.println("case:9 Pass!");
				break;

							
			case "    " :
				sendInput(s);
				escapeCurser();
				clickCalenderbutton();		
				boolean b9 = verifyError();
				if (!b9) {
					System.out.println("case:10 Fail!");
				}
				clearInput();
				System.out.println("case:10 Pass!");
				break;

			}

		}
	}
	
	
	
}
