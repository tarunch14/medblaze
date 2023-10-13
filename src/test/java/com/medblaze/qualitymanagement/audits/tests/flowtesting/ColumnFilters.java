package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ColumnFiltersElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;

public class ColumnFilters extends BaseClass {

	public void columnFilters() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		// Thread.sleep(3000);
		// el.clickaudits();

		// click on list
		// el.clicklist();
		// Thread.sleep(2000);

		// click on review pending

		// el.clickReviewpending();
		// Thread.sleep(3000);

		ApproveAuditElements obj = new ApproveAuditElements(driver);
		obj.clickclsdbtn();
		// Thread.sleep(20000);

		// Rejectaudit_Elements obj1 = new Rejectaudit_Elements(driver);
		// obj1.clickRejected1();

		ColumnFiltersElements dtv = new ColumnFiltersElements(driver);

		dtv.selectfilter("closed");

		dtv.clickcolumnfilter();

		dtv.enterauditname("med table form");

		dtv.enteraudittype("test");

		dtv.clickunit("TEST UNIT");

		dtv.enterauditedby("Infini");

		dtv.selectstartdate("15-AUG-2001");

		dtv.selectenddate("15-JUN-2023");

		dtv.clickdateapply();

		dtv.verifyDate("15-Aug-2001", "15-Jun-2023");

		dtv.verifyFilters("med table form", "test", "TEST UNIT", "Infini");

		// dtv.clickDeleteCache();

		/*
		 * dtv.clearAuditname(); Thread.sleep(3000);
		 * 
		 * dtv.clearAudittype(); Thread.sleep(3000);
		 * 
		 * dtv.clearUnit(); Thread.sleep(3000);
		 * 
		 * dtv.clearAuditedby(); Thread.sleep(3000);
		 * 
		 * dtv.clearAuditdate(); Thread.sleep(3000);
		 */

		driver.navigate().refresh();

	}

}
