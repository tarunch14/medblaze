package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;
import java.util.Arrays;

import com.medblaze.utilities.WaitHelper;
import com.medblaze.utilities.Xlsutils;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;


public class AuditConfiguration extends BaseClass {
	
	public void configurtion() throws InterruptedException, IOException {
		
		// login
		
		// click on audits
		
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

		ce.clickauditinchargetoggle();

		ce.clickauditadmintoggle();

		ce.selectitemsperpage("10");

		ce.createConfiguration();
		
		ce.clickSubmit();
		
		log.info("Audit Configuration Pass!");
	}
}
