package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ReopenAuditElements;

public class ReopenClosedAudit extends BaseClass{
	
	
	public void reopen() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		el.clickaudits();

		// click on list
		el.clicklist();
		Thread.sleep(3000);

		ApproveAuditElements obj = new ApproveAuditElements(driver);
		obj.clickclsdbtn();
		Thread.sleep(20000);

		ReopenAuditElements rae = new ReopenAuditElements(driver);
		rae.action("Code Pink - Mock drill", "17-Aug-2023");
		Thread.sleep(5000);
		rae.verifydetails("Code Pink - Mock drill", "17-Aug-2023");

	}

}

