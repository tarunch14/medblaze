package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;

public class ApproveAudit extends BaseClass {

	public void Approve() throws Exception {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);

		// el.clickaudits();

		// click on list
		// el.clicklist();
		// Thread.sleep(3000);

		// click on review pending

		// el.clickReviewpending(); // Thread.sleep(3000);

		// click on audit incharge review pending

		ApproveAuditElements aae = new ApproveAuditElements(driver);

		aae.clickAIRPbtn();
		Thread.sleep(3000);

		// approve
		aae.clickapprove(auditname, datep);

		aae.entercomments("Approved");

		aae.clickyes();
		Thread.sleep(10000);

		// click on audit admin review pending

		aae.clcikAARPbtn();
		Thread.sleep(3000);

		aae.clickedit(auditname, datep);

		// clcik on edit and approve

		aae.clickapproveedit();

		aae.entercomments("Approved");

		aae.clickyes();
		Thread.sleep(10000);

		// verify audit in closed list

		aae.clickclsdbtn();
		Thread.sleep(25000);

		aae.searchRecord(auditname);
		Thread.sleep(3000);

		aae.verifyApprovedAudit(auditname, datep);

	}

}
