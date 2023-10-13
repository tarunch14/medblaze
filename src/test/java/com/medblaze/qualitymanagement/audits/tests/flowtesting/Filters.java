package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.FiltersElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.RejectAuditElements;

public class Filters extends BaseClass {

	public void applyfilters() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		// Thread.sleep(3000);
		// el.clickaudits();

		// click on list
		// el.clicklist();

		// click on review pending
		/*
		 * el.clickReviewpending(); Thread.sleep(3000);
		 * 
		 * Approveaudit_Elements obj = new Approveaudit_Elements(driver);
		 * obj.clickclsdbtn(); Thread.sleep(20000);
		 */

		RejectAuditElements obj1 = new RejectAuditElements(driver);
		obj1.clickRejected1();

		FiltersElements ftc = new FiltersElements(driver);
		ftc.selectfilter("Rejected");

		ftc.clickfilterbtn();

		ftc.clickauditnameDD();

		ftc.auditnameddvalue("2", "Hand hygiene");

		ftc.auditnameddvalue("3", "med table form");

		ftc.audittypeddvalue("test");

		ftc.statusddvalue("Audit rejected");

		ftc.clickfrdate();

		ftc.selectfromdate("11-JUN-2005");

		ftc.to_date();

		ftc.selecttilldate("21-SEP-2023");

		ftc.unitddvalue("TEST UNIT");

		ftc.clickapply();

		ftc.verifyDate("11-Jun-2005", "21-Sep-2023");

		ftc.verifyFilters("med table form", "Hand hygiene", "test", "TEST UNIT");

		ftc.clickfilterbtn();

		ftc.clickclear();

	}

}
