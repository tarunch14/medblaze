package com.medblaze.qualitymanagement.audits.tests.functionalitytesting;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.PerformAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield.ConfigurationFieldsTestingofTextfieldElements;

public class ConfigurationFieldsTestingofTextfield extends BaseClass {
	
	public void configurationFieldsFunctionality() throws Throwable {
		
		EditAuditElements el = new EditAuditElements(driver);

		el.clickaudits();
		Thread.sleep(3000);
		
		ConfigurationElements ce = new ConfigurationElements(driver);

		ce.clickconfigbutton();

		ce.clickOnAddButton();

		ce.enterAuditname(auditname);

		ce.clickAdditem();

		ce.clickSubmit();

		ce.enterAudittype("Test");

		ce.selectAudittype("Test");

		ce.clickactivetoggle();

		ce.clickauditinchargetoggle();

		ce.clickaddnewfield();

		ce.field("Doing Hand Hygiene", "1");

		ce.section("Section A: Compliance Criteria", "1");

		ce.typeofField("SINGLE SELECT RADIO-BUTTON", "1");

		ce.clicktoogle("Enabled/Disabled", "1");

		ce.clickaddnewfield();
		 
		
		ConfigurationFieldsTestingofTextfieldElements cfttfe = new ConfigurationFieldsTestingofTextfieldElements(driver);
		
		
		cfttfe.textFieldConfigurationOne("Enter your Text", "Section 1: Employee details", "testing text field",
				"TEXT FIELD", "Tarun", "field info enabled", "UHID", "Mandatory", "Filterable", "PIE CHART",
				"Doing Hand Hygiene", "No", "Enabled/Disabled", "copyenabletoggle", "2");

		ce.clickSubmit();
		Thread.sleep(6000);

		ce.clickconfigbutton();
		 
		
		EditConfigurationElements ec = new EditConfigurationElements(driver);

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);

		cfttfe.checkIdGeneration();
		 
		
		PerformAuditElements pa = new PerformAuditElements(driver);

		pa.clickPerformAudit();

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);

		pa.enterUnitname("TEST UNIT");

		cfttfe.checkParentquestionFunctionality();

		cfttfe.checkFieldValue("Enter your Text");

		cfttfe.checkSectionValue("Section 1: Employee details");

		cfttfe.defaultResponseFieldFunctionality("Tarun", "Sahitya", "yes");

		cfttfe.checkFieldInfromationFunctionality("field info enabled");

		cfttfe.mandatoryFieldFunctionality("yes");

		cfttfe.linktoDemographicFunctionality("950255");
		Thread.sleep(3000);

		ce.clickonDraft();

		pa.goToAuditListPage();
		Thread.sleep(5000);

		cfttfe.clickDashboardbutton();
		Thread.sleep(3000);

		cfttfe.selectauditnameinDashboardFilter(auditname);

		cfttfe.checkDashboard("PIE CHART");

		ce.clickconfigbutton();

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);

		cfttfe.configurationTwo();
		Thread.sleep(10000);
		 
		
		cfttfe.checkCopyEnabledFunctionality(auditname, datep, true);	
		
		cfttfe.mandatoryFieldFunctionality("No");

		ce.clickconfigbutton();

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);
		Thread.sleep(2000);
		
		ce.clicktoogle("readonly", "2"); //turning on
		
		ce.clickSubmit();
		Thread.sleep(10000);
		
		pa.clickPerformAudit();

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);
		
		cfttfe.defaultResponseFieldFunctionality("","","No");
		
		cfttfe.readonlyFieldFunctionality("test it");
		
		ce.clickconfigbutton();

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);
		Thread.sleep(2000);
		
		ce.clicktoogle("readonly", "2"); //turning off
		
		ce.clicktoogle("copyenabledtoogle", "2"); //disabled
		
		ce.clickSubmit();
		Thread.sleep(10000);
		
		cfttfe.checkCopyEnabledFunctionality(auditname, datep, false);

		ce.clickconfigbutton();

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);
		
		ce.clicktoogle("Enabled/Disabled", "2"); //disabled
		
		ce.clickSubmit();
		Thread.sleep(10000);
		
		pa.clickPerformAudit();

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);
		
		cfttfe.disableTogglefunctionality();
				
	}

}
