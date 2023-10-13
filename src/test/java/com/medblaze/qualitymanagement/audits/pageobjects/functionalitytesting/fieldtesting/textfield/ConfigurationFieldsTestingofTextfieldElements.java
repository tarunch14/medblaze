package com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.CopyandPasteAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.PerformAuditElements;

public class ConfigurationFieldsTestingofTextfieldElements {
	WebDriver driver;
	String fieldinfor;
	ConfigurationElements ce;
	
	public ConfigurationFieldsTestingofTextfieldElements(WebDriver dr) {
		driver=dr;
		PageFactory.initElements(driver, this);	
		ce= new ConfigurationElements(driver);
	}
	
	@FindBy(xpath = "//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[3]//textarea")
	WebElement orderId;
	
	@FindBy(xpath = "//med-form-controls[6]//mat-form-field/div/div[1]/div[1]/span/label/span[1]")
	WebElement fieldValue;
	
	@FindBy(xpath = "//med-form-controls[6]/div/div/mat-card/div/div/div[1]/div/span")
	WebElement sectionValue;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//mat-cell[10]//input")
	WebElement defaultResponse;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//mat-cell[10]//mat-icon[text()='close']")
	WebElement defaultResponsecancelbutton;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//div[text()='Dashboard']/parent::div/parent::div//span[@class='ng-arrow-wrapper']")
	WebElement dashboard;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//div[text()='Dashboard']/parent::div/div//input")
	WebElement dashboardinput;	
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//div[text()='Link to demographic']/parent::div/parent::div//span[@class='ng-arrow-wrapper']")
	WebElement linktodemographic;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//mat-cell[19]//input")
	WebElement linktodemographicInput;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//mat-cell[20]//textarea")
	WebElement fieldInformation;
	
	@FindBy(xpath = "//med-form-controls[6]//mat-form-field/div/div[1]/div[1]/input")
	WebElement defaultresponsevalue;
	
	@FindBy(xpath = "//input[@id='enterYourText']")
	WebElement defaultresponsevalue01;
	
	@FindBy(xpath = "//med-form-controls[6]//mat-form-field/div/div[1]/div[1]/span/label/span[2]")
	WebElement star;
	
	@FindBy(xpath = "//med-form-controls[6]//mat-form-field//mat-error[1]")
	WebElement error;
	
	@FindBy(xpath = "//mat-icon[text()='inventory']")
	WebElement botomateIcon;
	
	@FindBy(xpath = "//input[@id='UHID']")
	WebElement enterUHID;
	
	@FindBy(xpath = "//mat-icon[text()='help_outline ']")
	WebElement fieldinformationbutton;
	
	@FindBy(xpath = "//p[@id='undefined']")
	WebElement fieldinfo;
	
	@FindBy( xpath = "//span[text()='Yes']//ancestor::label/span[1]")
	WebElement Yesradiobutton;
	
	@FindBy( xpath = "//span[text()='No']//ancestor::label/span[1]")
	WebElement Noradiobutton;
	
	@FindBy( xpath = "//span[text()='N/A']//ancestor::label/span[1]")
	WebElement N_Aradiobutton;
	
	@FindBy(xpath ="//a[text()='Audits']//ancestor::li//a[text()=' Dashboard']")
	WebElement dashboardbutton;
	
	@FindBy(xpath = "//div[text()='Audit Name']/parent::div/div[2]/input")
	WebElement dashboardAuditname;
	
	@FindBy(xpath = "//tr[@class='mat-row cdk-row ng-star-inserted'][2]//div[contains(text(),'Parent Response')]//parent::div//parent::div//span[@title='Clear all']")
	WebElement parentresponsecancelbutton;
	
	public void selectauditnameinDashboardFilter(String input) throws InterruptedException {
		dashboardAuditname.sendKeys(input);
		driver.findElement(By.xpath("//span[text()= ' "+input+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()= ' Draft ']/ancestor::label/span[1]")).click();
		driver.findElement(By.xpath("//span[text()= 'Apply ']")).click();	
	}
	
	public void clickDashboardbutton() {
		dashboardbutton.click();
	}
	
	public String getFieldinformation() {
		String s=fieldinfo.getText();
		return s;
	}
	
	public void clickFieldInformationbutton() {
		Actions action = new Actions(driver);
		action.moveToElement(fieldinformationbutton).perform();
		action.click().perform();
	}
	
	public void enterFieldInformation(String input) {
		fieldinfor=input;
		fieldInformation.sendKeys(input);
	}
	
	public void selectDemographic(String input) {
		linktodemographic.click();
		linktodemographicInput.sendKeys(input);
		WebElement element = driver.findElement(By.xpath("//span[text()=' "+input+"']"));
		element.click();
	}
	
	public void selectDashboard(String input) {
		dashboard.click();
		dashboardinput.sendKeys(input);
		WebElement element = driver.findElement(By.xpath("//span[text()=' "+input+"']"));
		element.click();
	}
	
	public void addDefaultResponse(String input) {
		defaultResponse.sendKeys(input);
	}
	
	public void textFieldConfigurationOne(String fieldname, String section,String sectiondescription,String fieldtype, String defaultresponse,
			String fieldinformation,String linktodemographic, String mandatorytoggle, String filterabletoggle,
			String dashboardtype,String parentquestion,String parentresponse,String enabletoggle, String copyenabletoggle, String no) throws InterruptedException, IOException {
		
		ce.field(fieldname, no);
		
		ce.section(section, no);
		
		ce.sectiondescription(sectiondescription,no);
		
		ce.typeofField(fieldtype, no);
		
		addDefaultResponse(defaultresponse);
		
		ce.clicktoogle(mandatorytoggle, no);
		
		ce.clicktoogle(filterabletoggle, no);
		
	//	ce.clicktoogle(readonlytoggle, no);
		
		selectDashboard(dashboardtype);
		
		ce.parentQuestion(parentquestion, parentresponse, no);
		
		selectDemographic(linktodemographic);
		
		enterFieldInformation(fieldinformation);
		
		ce.clicktoogle(enabletoggle, no);
		
		ce.clicktoogle(copyenabletoggle, no);

	}
	
	public void configurationTwo() {
		defaultResponsecancelbutton.click();
		ce.clicktoogle("Mandatory", "2");
		parentresponsecancelbutton.click();
		ce.clickSubmit();
	}
	
	public void checkIdGeneration() {
		String oid=orderId.getAttribute("value");
		if(oid !=null) {
			System.out.println("ID generation Pass!");
		}
		else {
			System.out.println("ID generation Fail!");
		}
	}
	
	public void checkFieldValue(String input) {
		String value=fieldValue.getText();
		if(value.equals(input)) {
			System.out.println("checkFieldValue Pass!");
		}
		else {
			System.out.println("checkFieldValue Fail!");
		}
	}
	
	public void checkSectionValue(String input) {
		String value=sectionValue.getText();
		if(value.equals(input)) {
			System.out.println("checkSectionValue Pass!");
		}
		else {
			System.out.println("checkSectionValue Fail!");
		}
	}	
	
	public void defaultResponseFieldFunctionality(String input1,String input2, String enabled) throws AWTException {
		switch (enabled) {
		case "yes":
			String s= defaultresponsevalue.getAttribute("value");
			defaultresponsevalue.clear();
			defaultresponsevalue.sendKeys(input2);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			String s1= defaultresponsevalue.getAttribute("value");
			
			if(s.equalsIgnoreCase(input1) && s1.equalsIgnoreCase(input2) && s!=null) {
				System.out.println("defaultResponseFieldFunctionality Pass!");
			}
			else {
				System.out.println("defaultResponseFieldFunctionality Fail!");
			}
			break;
			
		case "No":
			String ss1= defaultresponsevalue.getAttribute("value");
			if(!ss1.equals("")) {
				System.out.println("defaultResponseFieldFunctionality Fail!");
			}
			else {
				System.out.println("defaultResponseFieldFunctionality Pass!");
			}
			break;

		default:
			break;
		}
		
	}
	
	public void mandatoryFieldFunctionality(String enabled) throws Throwable {
		switch (enabled) {
		case "yes":
			String s= (star.getText()).substring(0, 1);
			defaultresponsevalue.clear();
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			driver.findElement(By.xpath("//span[text()='Submit ']")).click();
			String s1=error.getText();
			
			if(s.contains("*") && s1.contains("Mandatory field")) {
				System.out.println("mandatoryFieldFunctionality pass!");
			}
			else {
				System.out.println("mandatoryFieldFunctionality Fail!");
			}
			break;
			
		case "No" :
			defaultresponsevalue01.clear();
			driver.findElement(By.xpath("//span[text()='Submit ']")).click();
			boolean result;
			try {
				WebElement ele=driver.findElement(By.xpath("//span[text()='Go to List Page ']"));
				result = ele.isDisplayed();
				ele.click();
			} catch (NoSuchElementException e) {
				result=false;
			}
			
			if(result) {
				System.out.println("mandatoryFieldFunctionality Pass!");
			}
			else {
				System.out.println("mandatoryFieldFunctionality Fail!");
			}
			Thread.sleep(6000);
			
		//	driver.findElement(By.xpath("//span[text()='Perform new audit ']")).click();
			break;

		default:
			break;
		}

	}
	

	
	@SuppressWarnings("unused")
	public void readonlyFieldFunctionality(String input) throws InterruptedException {	
		String s = null;
		try {
			defaultresponsevalue.sendKeys(input);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		s=defaultresponsevalue.getAttribute("value");
	
		if(s.equalsIgnoreCase(input) || !s.equals("")) {
			System.out.println("readonlyFieldFunctionality Fail!");
		}
		else if(s.equals("")) {
			System.out.println("readonlyFieldFunctionality Pass!");
		}
	}
	
	public void linktoDemographicFunctionality(String UHID) {
		botomateIcon.click();
		enterUHID.sendKeys(UHID);
		driver.findElement(By.xpath("//med-form-controls[2]//span[text()='Submit ']")).click(); //submit
		driver.findElement(By.xpath("//span[contains(text(),' prasanth')]//ancestor::tr//span[@class='mat-radio-outer-circle']")).click(); //record radiobutton
		driver.findElement(By.xpath("//span[contains(text(),'Next ')]")).click(); //nextbutton
		String s=defaultresponsevalue.getAttribute("value");
		if(s.equalsIgnoreCase(UHID)) {
			System.out.println("linktoDemographicFunctionality Pass!");
		}
		else {
			System.out.println("linktoDemographicFunctionality Fail!");
		}
	}
	
	public void checkFieldInfromationFunctionality(String input) {
		clickFieldInformationbutton();
		String s=getFieldinformation();
		if(s.equalsIgnoreCase(input)) {
			System.out.println("checkFieldInfromationFunctionality Pass!");
		}
		else {
			System.out.println("checkFieldInfromationFunctionality Fail!");
		}
		clickFieldInformationbutton();
	}
	
	public void checkCopyEnabledFunctionality(String auditname,String datep,boolean enabled) throws InterruptedException, IOException {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
		    Date date = new Date();  
		    datep =formatter.format(date);
		
		EditAuditElements el = new EditAuditElements(driver);
		CopyandPasteAuditElements cpae = new CopyandPasteAuditElements(driver);
		el.clicklist();

		el.searchAudit(auditname);
		Thread.sleep(5000);

		el.clickedit(auditname, datep);
		Thread.sleep(3000);
		
		String s= defaultresponsevalue01.getAttribute("value");

		cpae.clickCopy();
		Thread.sleep(3000);

		PerformAuditElements pa = new PerformAuditElements(driver);

		pa.clickPerformAudit();
		Thread.sleep(3000);

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);

		pa.enterUnitname("TEST UNIT");

		cpae.clickPaste();
		Thread.sleep(3000);
		
		String s1= defaultresponsevalue.getAttribute("value");
		
		if(enabled) {
			if(s!="" && s.equals(s1)) {
				System.out.println("Copy Enabled Functionality pass");
			}
			else {
				System.out.println("Copy Enabled Functionality Fail!");
			}
		}
		else if(!enabled) {
			if(s1.equals("")) {
				System.out.println("Copy disabled Functionality Pass!");	
			}
			else {
				System.out.println("Copy disabled Functionality Fail!");
			}
		}
	}
	
	public void checkParentquestionFunctionality() {
		
		Yesradiobutton.click();
		boolean yes= sectionValue.isDisplayed();
		N_Aradiobutton.click();
		boolean na= sectionValue.isDisplayed();
		Noradiobutton.click();
		boolean no= sectionValue.isDisplayed();	
		
		if(no && yes==false && na==false) {
			System.out.println("checkParentquestionFunctionality Pass!");
		}
		else {
			System.out.println("checkParentquestionFunctionality Fail!");
		}
	}
	
	public void disableTogglefunctionality() {
		boolean visibility;
		try {
			visibility = sectionValue.isDisplayed();
		} catch (NoSuchElementException e) {
			visibility = false;
		}
		
		
		if(visibility) {
			System.out.println("disableTogglefunctionality Fail!");
		}
		else {
			System.out.println("disableTogglefunctionality Pass!");
		}
	}
	
	public void checkDashboard(String graphname) {
		WebElement graphtype = driver.findElement(By.xpath("//mat-card-title[text()=' Enter your Text']/ancestor::mat-card//div[@class='ngx-charts-outer']//*[local-name()='svg']/*[local-name()='g']"));
		String graph=graphtype.getAttribute("class");
		switch (graphname) {

		case "HORIZONTAL BAR CHART":
			if(graph.equals("bar-chart chart")) {
				System.out.println("Pass!");	
			}
			else {
				System.out.println("Fail!");
			}
			break;
			
		case "PIE CHART" :
			if(graph.equals("pie-chart chart")) {
				System.out.println("Pass!");	
			}
			else {
				System.out.println("Fail!");
			}
			break;

		default:
			break;
		}
	}
	
	

}
