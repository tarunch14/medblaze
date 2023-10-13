package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;

public class EditAudit extends BaseClass {

	public void test() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);
		 Thread.sleep(3000);
		 el.clickaudits();
		 
		 el.clicklist();
		 Thread.sleep(2000);
		 
		 el.clickReviewpending();
		 Thread.sleep(2000);

		 el.searchAudit(auditname);
		 Thread.sleep(3000);

		// click on edit
		el.clickedit(auditname, datep);
		Thread.sleep(3000);

		// change selection

		el.clickRadiobutton("No");

		el.enterReason("No specific reason");

		el.clicksubmit();
		Thread.sleep(2000);

		el.clickgotoListpage();

		// verify
		ApproveAuditElements obj = new ApproveAuditElements(driver);
		
		obj.clickAIRPbtn();
		Thread.sleep(2000);

		el.verify(auditname, datep);

	}

}
