package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ReopenAuditElements;


public class ReopenAudit extends BaseClass {

	public void reopen() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
	//	Thread.sleep(5000);
	//	el.clickaudits();

		// click on list
	//	 el.clicklist();
    //	 Thread.sleep(3000);

		ApproveAuditElements obj = new ApproveAuditElements(driver);
		// obj.clickclsdbtn();
	//	Thread.sleep(5000);

		ReopenAuditElements rae = new ReopenAuditElements(driver);
		rae.action(auditname, datep);
		Thread.sleep(20000);
		
		ApproveAuditElements aae = new ApproveAuditElements(driver);
		aae.searchRecord(auditname);
		Thread.sleep(2000);

		rae.verifydetails(auditname, datep);

	}

}
