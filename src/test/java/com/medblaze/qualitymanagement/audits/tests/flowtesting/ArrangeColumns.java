package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ArrangeColumnsElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;

public class ArrangeColumns extends BaseClass {


	public void arrangeColumns() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		// el.clickaudits();

		// click on list
		// el.clicklist();
		Thread.sleep(3000);

		// click on review pending
		el.clickReviewpending();
		Thread.sleep(3000);

		// Approveaudit_Elements obj = new Approveaudit_Elements(driver);
		// obj.clickclsdbtn();
		// Thread.sleep(20000);

		// Rejectaudit_Elements obj1 = new Rejectaudit_Elements(driver);
		// obj1.clickRejected1();

		ArrangeColumnsElements ace = new ArrangeColumnsElements(driver);
		ace.selectfilter("Review pending");
		

		String[] rPendingfieldnames = { "Audit Name", "Audit Type", "Audit Date", "Unit", "Audited By", "Status",
				"Reviewed By Incharge", "Reviewed By Admin", "Submitted date", "Process Instance Id", "Total Score",
				"Achieved Score", "Compliance Percentage", "Entry type" };
		
		String[] rejectedFieldnames= {"Audit Name", "Audit Type", "Audit Date", "Unit","Audited By","Rejected Date",
				"Rejected By","Status","Reviewed By Incharge","Reviewed By Admin","Submitted date","Process Instance Id",
				"Total Score","Achieved Score","Compliance Percentage","Entry type"};
		
		String[] closedFieldnames= {"Audit Name", "Audit Type", "Audit Date", "Unit","Audited By","Closed Date",
				"Reviewed By Incharge","Reviewed By Admin","Status","Submitted date","Process Instance Id","Total Score",
				"Achieved Score","Compliance Percentage","Entry type"};
		
		if(ace.section.equalsIgnoreCase("Review pending")) {
			for (String s : rPendingfieldnames) {
				ace.clickarrangecolumns();
				ace.toogleSelection(s);
			}
		}
		else if(ace.section.equalsIgnoreCase("closed")) {
			for (String s : closedFieldnames) {
				ace.clickarrangecolumns();
				ace.toogleSelection(s);
			}
		}
		else{
			for (String s : rejectedFieldnames) {
				ace.clickarrangecolumns();
				ace.toogleSelection(s);
			}
		}		
		
		driver.navigate().refresh();

	}

}
