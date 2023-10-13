package com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.medblaze.BaseTest.BaseClass;

public class FieldsAvaialableinConfigurationElements {
	WebDriver driver;

	public FieldsAvaialableinConfigurationElements(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
	}

	String [] fieldElements = { "responses", "score", "defaultResponse", "mandatoryToggle", "filterableToggle", "readonlyToggle",
			"dashboardField", "parentQuestion", "parentResponse", "validationParentQuestion", "linktoDemographic",
			"fieldInformation", "enableddisabledToggle", "copyEnabledToggle" };

	public void verifyFields() {

		boolean check1 = true;
		boolean check2 = true;

		for (String ele : fieldElements) {
			
			switch (ele) {
            case "responses":
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[8]/med-form-controls"));
					check1 = false;
					BaseClass.log.info("Responses field is available - Fail!");
				} catch (NoSuchElementException e) {
					if (check1) {
						check1 = true;
					}
				}
				break;
					
            case "score" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[9]/med-form-controls"));
					check1 = false;
					BaseClass.log.info("Score field is available - Fail!");
				} catch (NoSuchElementException e) {
					if (check1) {
						check1 = true;
					}
				}
				break;
				
            case "defaultResponse":
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[10]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {				
					check2 = false;
					BaseClass.log.info("Default Responses field is not available - Fail!");
				}
				break;
				
            case "mandatoryToggle" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[11]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Mandatory Toggle field is not available - Fail!");
				}
				break;
            	
            case "filterableToggle" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[12]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Filterable Toggle field is not available - Fail!");
				}
				break;
				
            case "readonlyToggle" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[13]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Readonly Toggle field is not available - Fail!");
				}
				break;
				
            case "dashboardField" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[14]/med-form-controls"));
					if (check2) {
						check2 = true;			
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Dashboard field is not available - Fail!");
				}
				break;
				
            case "parentQuestion" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[15]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Parent Question field is not available - Fail!");
				}
				break;
				
            case "parentResponse" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[16]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Parent Response field is not available - Fail!");
				}
				break;
				
            case "validationParentQuestion" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[17]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("validation Parent Question field is not available - Fail!");
				}
				break;
				
            case "linktoDemographic" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[19]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Link to Demographic field is not available - Fail!");
				}
				break;
				
            case "fieldInformation" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[20]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Field Information is not available - Fail!");
				}
				break;
				
            case "enableddisabledToggle" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[21]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("Enable/Disable Toggle is not available - Fail!");
				}
				break;
				
            case "copyEnabledToggle" :
				try {
					driver.findElement(By.xpath("//mat-table[@id='listOfAuditQuestions']//tr[2]//mat-cell[22]/med-form-controls"));
					if (check2) {
						check2 = true;
					}
				} catch (NoSuchElementException e) {
					check2 = false;
					BaseClass.log.info("copy Enable Toggle is not available - Fail!");
				}
				default :
					System.out.println("default case");
			}

		}

		if (check1 && check2) {
			BaseClass.log.info("Fields available in configuration - Pass");
		} else {
			BaseClass.log.info("Fields available in configuration - Fail");
		}

	}

}

