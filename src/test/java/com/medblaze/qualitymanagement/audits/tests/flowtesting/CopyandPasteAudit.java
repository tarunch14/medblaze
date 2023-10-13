package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.CopyandPasteAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.PerformAuditElements;

public class CopyandPasteAudit extends BaseClass {

	ArrayList<String> fieldNames;
	ArrayList<String> fieldValues1;
	ArrayList<String> fieldValues2;

	public void copyAudit() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		//el.clickaudits();

		ConfigurationElements ce = new ConfigurationElements(driver);
		ce.clickconfigbutton();
		Thread.sleep(3000);

		EditConfigurationElements ec = new EditConfigurationElements(driver);

		ec.clickSearch(auditname);

		ec.clickViewbutton(auditname);

		ce.selectitemsperpage("10");

		CopyandPasteAuditElements cpae = new CopyandPasteAuditElements(driver);

		int size = cpae.getnoofRecords();

		fieldNames = new ArrayList<String>();

		for (int i = 1; i <= size; i++) {
			if (cpae.checkToggle(i) != null) {
				fieldNames.add(cpae.checkToggle(i));
			}
		}

		System.out.println(fieldNames);

		el.clicklist();

		el.searchAudit(auditname);
		Thread.sleep(3000);

		cpae.clicview(auditname, datep);

		fieldValues1 = new ArrayList<String>();

		for (String s : fieldNames) {
			String s1 = cpae.checkFieldValue(s);
			if (s1 != null) {
				fieldValues1.add(s1);
			}
		}
		System.out.println(fieldValues1);
//----------
		el.clickaudits();

		el.clicklist();

		el.searchAudit(auditname);
		Thread.sleep(3000);

		el.clickedit(auditname, datep);
		Thread.sleep(3000);

		cpae.clickCopy();
		Thread.sleep(3000);

		PerformAuditElements pa = new PerformAuditElements(driver);

		pa.clickPerformAudit();
		Thread.sleep(3000);

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);

		pa.enterUnitname("TEST UNIT");

		pa.selectDate(date4);

		cpae.clickPaste();
		Thread.sleep(3000);

		pa.clickDraft();

		pa.goToAuditListPage();

		el.searchAudit(auditname);
		Thread.sleep(5000);

		cpae.clicview(auditname, datec);

		fieldValues2 = new ArrayList<String>();

		for (String s : fieldNames) {
			String s1 = cpae.checkFieldValue(s);
			if (s1 != null) {
				fieldValues2.add(s1);
			}
		}
		System.out.println(fieldValues2);
		
		boolean bool = fieldValues1.equals(fieldValues2);
		if(bool) {
			BaseClass.log.info("Copy and Paste Audit Pass!");
			assertTrue(true);
			//System.out.println("Copy and Paste Audit Pass!");
		}
		else {
			BaseClass.log.info("Copy and Paste Audit Fail!");
			BaseClass b1 = new BaseClass();
			b1.screenshot(driver, "PerformAuditbyCopyPaste");
			assertTrue(false);
			//System.out.println("Copy and Paste Audit Fail!");
		}
		
		driver.navigate().refresh();

	}
}
