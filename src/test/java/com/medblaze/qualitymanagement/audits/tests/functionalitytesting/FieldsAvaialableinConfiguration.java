package com.medblaze.qualitymanagement.audits.tests.functionalitytesting;

import java.io.IOException;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield.FieldsAvaialableinConfigurationElements;

public class FieldsAvaialableinConfiguration extends BaseClass {

	public void chechFields() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);

		el.clickaudits();

		ConfigurationElements ce = new ConfigurationElements(driver);

		ce.clickconfigbutton();

		ce.clickOnAddButton();

		ce.enterAuditname(auditname);

		ce.clickAdditem();

		ce.clickSubmit();

		ce.enterAudittype("Test");

		ce.selectAudittype("Test");

		ce.clickactivetoggle();

		ce.clickaddnewfield();
		
		ce.field("Enter your Text", "1");
		
		ce.section("Section 1: Employee details", "1");

		ce.typeofField("TEXT FIELD", "1");

		FieldsAvaialableinConfigurationElements faice = new FieldsAvaialableinConfigurationElements(driver);

		faice.verifyFields();
		
		ce.clicktoogle("Enabled/Disabled", "1");
		
		ce.clickSubmit();
	}

}
