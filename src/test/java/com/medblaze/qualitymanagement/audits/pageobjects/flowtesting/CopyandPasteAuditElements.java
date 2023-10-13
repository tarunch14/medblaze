package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyandPasteAuditElements {
	WebDriver driver;
	
	
	public CopyandPasteAuditElements(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//mat-icon[contains(text(),'content_copy')]")
	WebElement copy;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'content_paste')]")
	WebElement paste;
	
	public void clickPaste() {
		paste.click();
	}
	
	public void clickCopy() {
		copy.click();
	}
	
	
	
	public void clicview(String Audit_Name, String date) {
		
		WebElement edit = driver.findElement(By.xpath("//med-list[@key='Review Pending-audits-list']//span[contains(text(),'"+Audit_Name+"')]//ancestor::tr//span[contains(text(),'"+date+"')]//ancestor::tr//td[7]//button[2]"));
		edit.click();
	}
	
	public int getnoofRecords() {
		List<WebElement> records = driver.findElements(By.xpath("//div[contains(text(),'Order')]//parent::div//span"));
		int size= records.size();
		return size;
	}	
	
	public String checkToggle(int i) {
		String value=null;
		String s = Integer.toString(i);
		WebElement toggle = driver.findElement(By.xpath("//div[contains(text(),'Order')]//parent::div//span[contains(text(),'"+s+"')]//ancestor::tr//mat-cell[22]//button"));
		String check = toggle.getAttribute("aria-checked");
		boolean b = Boolean.parseBoolean(check);
		
		if(b) {
		   WebElement field = driver.findElement(By.xpath("//div[contains(text(),'Order')]//parent::div//span[contains(text(),'"+s+"')]//ancestor::tr//mat-cell[4]//textarea"));
		   value = field.getAttribute("value");
		}
		else {
			value=null;
		}
		return value;
	}
	
	public String checkFieldValue(String fieldname) {
		String s =null;
		try {
			WebElement fieldvalue= driver.findElement(By.xpath("//div[contains(text(),'"+fieldname+"')]//parent::div/div[2]"));
			 s=fieldvalue.getText();	
			//s1=s.substring(1, 9);
			System.out.println(s);
			
		}
		catch(Exception e){
			s=null;
		}
		return s;
	}

}
