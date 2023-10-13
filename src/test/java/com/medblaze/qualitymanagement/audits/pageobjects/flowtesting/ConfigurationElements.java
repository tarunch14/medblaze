package com.medblaze.qualitymanagement.audits.pageobjects.flowtesting;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medblaze.utilities.WaitHelper;
import com.medblaze.utilities.Xlsutils;

public class ConfigurationElements {
	WebDriver driver;

	public ConfigurationElements(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Configuration']")
	WebElement configurationbutton;

	@FindBy(xpath = "//span//mat-icon[text()='add']")
	public WebElement addbutton;

	@FindBy(xpath = "//div[contains(@class, 'ng-value-container')]/div[contains(text(),'Audit Name')]//parent::div//div/input")
	WebElement auditname;

	@FindBy(xpath = "//span[text()='Add item']")
	WebElement additem;

	@FindBy(xpath = "//span[text()='Submit ']")
	WebElement submit;

	@FindBy(xpath = "//div[text()='Audit Type']//parent::div//div/input")
	WebElement auditType;

	@FindBy(xpath = "//h4[text()=' Active']//parent::div//button")
	WebElement activetoggle;

	@FindBy(xpath = "//h4[text()=' Approval by Audit Incharge']//parent::div//button")
	WebElement auditinchargetoggle;

	@FindBy(xpath = "//h4[text()=' Approval by Audit Admin']//parent::div//button")
	WebElement auditadmintoggle;

	@FindBy(xpath = "//span[text()=' Add new field']")
	WebElement addnewfield;

	@FindBy(xpath = "//div[text()='Items per page']//parent::div//parent::div//span[@class='ng-arrow-wrapper']")
	WebElement itemsperpagedropdown;

	@FindBy(xpath = "")
	WebElement no_ofitems;
	
	@FindBy(xpath = "//span[text()='Save as draft ']")
	WebElement saveasdraft;
	
	public void clickonDraft() {
		saveasdraft.click();
	}

	public void createConfiguration() throws IOException, InterruptedException {
		String configurationdata[][];
		String path = "C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\src\\main\\java\\com\\medblaze\\Testdata\\Configdata.xlsx";

		int row = Xlsutils.getrowcount(path, "configuration");
		int column = Xlsutils.getcellcount(path, "configuration");
		configurationdata = new String[row][column];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < column; j++) {
				configurationdata[i - 1][j] = Xlsutils.getcelldata(path, "configuration", i, j);
			}
		}

		for (int i = 0; i < row; i++) {
			clickaddnewfield();
			String n = Integer.toString(i + 1);
			for (int j = 0; j < column; j++) {
				if (j == 0) {
					field(configurationdata[i][j], n);
				} else if (j == 1) {
					section(configurationdata[i][j], n);
				} else if (j == 2) {
					typeofField(configurationdata[i][j], n);
				} else if (j == 3) {
					if (configurationdata[i][j].equalsIgnoreCase("true")) {
						clicktoogle("Mandatory", n);
					}
				} else if (j == 4) {
					if (!configurationdata[i][j].equalsIgnoreCase("null") && checkIfParentQuestionExistsInFieldName(
							configurationdata[i][j], configurationdata, row)) {
						parentQuestion(configurationdata[i][j], "No", n);
						Thread.sleep(2000);
					}
				} else if (j == 5) {
					if (configurationdata[i][j].equalsIgnoreCase("true")) {
						clicktoogle("Enabled/Disabled", n);
					}
				} else if (j == 6) {
					if (configurationdata[i][j].equalsIgnoreCase("true")) {
						clicktoogle("copyEnabled", n);
					}
				}

			}

		}
	}

	private boolean checkIfParentQuestionExistsInFieldName(String parentQuestion, String[][] configuration,
			int rowCount) {

		for (int i = 0; i < rowCount; i++) {
			if (configuration[i][0].equals(parentQuestion)) {
				return true;
			}
		}
		return false;
	}

	public void parentQuestion(String input, String response, String no) throws InterruptedException {
		WebElement parentQ = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no
				+ "]//div[contains(text(),'Parent Question')]//parent::div//div/input"));
		parentQ.sendKeys(input);
		driver.findElement(By.xpath("//span[contains(text(),'" + input + "')]")).click();

		// ----------------------

		Actions action = new Actions(driver);
		action.moveToElement(parentQ).perform();
		Thread.sleep(3000);
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(parentQ);
		new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 400).perform();

		WebElement parentR = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no
				+ "]//div[contains(text(),'Parent Response')]//parent::div//div/input"));
		parentR.sendKeys(response);

		// driver.findElement(By.xpath("//tr[@class='mat-row cdk-row
		// ng-star-inserted'][5]//div[contains(text(),'Parent
		// Response')]//parent::div//parent::div/span")).click();
		/*
		 * Actions action = new Actions(driver); action.moveToElement(no1).perform();
		 * action.click(no1).perform();
		 */

		WebElement no1 = driver.findElement(By.xpath("//div[@role='option']//span[contains(text(),'" + response + "')]"));
		no1.click();

	}

	public void addresponses(String input, String no) {
		WebElement ele = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no
				+ "]//div[text()='Responses']//parent::div//input"));
		ele.sendKeys(input);
		driver.findElement(By.xpath("//span[text()='Add item']")).click();
	}

	public void clicktoogle(String toogletype, String no) {
		if (toogletype.equalsIgnoreCase("Mandatory")) {
			WebElement mandatorytoogle = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["
					+ no + "]//h4[text()=' Mandatory ?']//parent::div/ui-switch"));
			mandatorytoogle.click();
		} else if (toogletype.equalsIgnoreCase("Filterable")) {
			WebElement Filterabletoogle = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["
					+ no + "]//h4[text()=' Filterable ?']//parent::div/ui-switch"));
			Filterabletoogle.click();
		} else if (toogletype.equalsIgnoreCase("readonly")) {
			
			WebElement readonlytoogle = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["
					+ no + "]//h4[text()=' Read Only']//parent::div/ui-switch"));
			WaitHelper.waitForElementtoBeClickable(readonlytoogle, driver, 10);
			readonlytoogle.click();
		} else if (toogletype.equalsIgnoreCase("Enabled/Disabled")) {
			WebElement Enable_Disabletoogle = driver
					.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no
							+ "]//h4[text()=' Enabled/Disabled']//parent::div/ui-switch"));
			Enable_Disabletoogle.click();
		} else {
			WebElement copyenabledtoogle = driver
					.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no
							+ "]//h4[text()=' Copy Enabled ?']//parent::div/ui-switch"));
			copyenabledtoogle.click();
		}

	}

	public void selectitemsperpage(String no) {
		itemsperpagedropdown.click();
		WebElement no_ofitems = driver.findElement(By.xpath("//span[text()=' " + no + "']"));
		no_ofitems.click();
	}

	public void typeofField(String input, String no) throws InterruptedException, IOException {
		String path = "C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\src\\main\\java\\com\\medblaze\\Testdata\\Configdata.xlsx";

		WebElement ele = driver.findElement(
				By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no + "]//mat-cell[7]//input"));
		ele.sendKeys(input);
		driver.findElement(By.xpath("//div[@role='option']//span[text()=' " + input + "']")).click();

		if (input.equalsIgnoreCase("SINGLE SELECT DROP DOWN")) {
			String singleselectDDdata[];

			int row = Xlsutils.getrowcount(path, "responses");
			int column = Xlsutils.getcellcount(path, "responses");
			singleselectDDdata = new String[column];

			for (int j = 1; j < column; j++) {
				singleselectDDdata[j] = Xlsutils.getcelldata(path, "responses", 1, j);
			}

			// String[] resp = { "BLOOD BANK", "Laboratory", "Admin", "Icu" };
			for (String s : singleselectDDdata) {
				if (s != null && !s.equalsIgnoreCase("")) {
					addresponses(s, no);
				}

			}
		} else if (input.equalsIgnoreCase("SINGLE SELECT RADIO-BUTTON")) {
			String singleselectRBdata[];

			int row = Xlsutils.getrowcount(path, "responses");
			int column = Xlsutils.getcellcount(path, "responses");
			singleselectRBdata = new String[column];

			for (int j = 1; j < column; j++) {
				singleselectRBdata[j] = Xlsutils.getcelldata(path, "responses", 2, j);
			}

			// String[] resp = { "Yes", "No", "N/A" };
			for (String s : singleselectRBdata) {
				if (s != null && !s.equalsIgnoreCase("")) {
					addresponses(s, no);
				}

			}
		} else if (input.equalsIgnoreCase("MULTI SELECT CHECKBOX")) {
			String multiselectCBdata[];

			int row = Xlsutils.getrowcount(path, "responses");
			int column = Xlsutils.getcellcount(path, "responses");
			multiselectCBdata = new String[column];

			for (int j = 1; j < column; j++) {
				multiselectCBdata[j] = Xlsutils.getcelldata(path, "responses", 3, j);
			}

			// String[] resp = { "Option 1", "Option 2", "Option 3" };
			for (String s : multiselectCBdata) {
				if (s != null && !s.equalsIgnoreCase("")) {
					addresponses(s, no);
				}
			}
		} else if (input.equalsIgnoreCase("MULTI SELECT DROPDOWN")) {
			String multiselectDDdata[];

			int row = Xlsutils.getrowcount(path, "responses");
			int column = Xlsutils.getcellcount(path, "responses");
			multiselectDDdata = new String[column];

			for (int j = 1; j < column; j++) {
				multiselectDDdata[j] = Xlsutils.getcelldata(path, "responses", 4, j);
			}

			// String[] resp = { "Dropdown 1", "Dropdown 2", "Dropdown 3" };
			for (String s : multiselectDDdata) {
				if (s != null && !s.equalsIgnoreCase("")) {
					addresponses(s, no);
				}
			}
		}

	}

	public void sectiondescription(String input,String no) {
		WebElement ele = driver
				.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no + "]//mat-cell[6]//textarea"));
		ele.sendKeys(input);
	}

	public void section(String input, String no) {
		WebElement ele = driver.findElement(
				By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no + "]//mat-cell[5]//textarea"));
		ele.sendKeys(input);
	}

	public void field(String input, String no) {
		WebElement ele = driver.findElement(
				By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + no + "]//mat-cell[4]//textarea"));
		ele.sendKeys(input);
	}

	public void clickaddnewfield() {
		addnewfield.click();
	}

	public void clickauditadmintoggle() {
		auditadmintoggle.click();
	}

	public void clickauditinchargetoggle() {
		auditinchargetoggle.click();
	}

	public void clickactivetoggle() {
		activetoggle.click();
	}

	public void selectAudittype(String audittype) {
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),' " + audittype + "')]"));
		ele.click();
	}

	public void enterAudittype(String audittype) {
		auditType.sendKeys(audittype);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void clickAdditem() {
		additem.click();
	}

	public void enterAuditname(String audit) {
		auditname.sendKeys(audit);
	}

	public void clickOnAddButton() {
		addbutton.click();
	}

	public void clickconfigbutton() throws InterruptedException {

		configurationbutton.click();
		WaitHelper.sleepWait(3000);
	}

}
