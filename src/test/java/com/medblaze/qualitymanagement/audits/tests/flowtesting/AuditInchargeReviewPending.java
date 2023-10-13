package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import org.testng.annotations.Test;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.AuditIRPElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;


public class AuditInchargeReviewPending extends BaseClass {

	@Test
	public void Verify_AIRP_Records() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);
		 Thread.sleep(3000);
		// el.clickaudits();

		// el.clicklist();
		// Thread.sleep(2000);

		el.clickReviewpending();
		Thread.sleep(3000);

		// get no.of audits in audit incharge review pending
		AuditIRPElements obj = new AuditIRPElements(driver);
		obj.getcount();
		Thread.sleep(2000);

		// Click on audit incharge review pending
		obj.clickAIRPbtn();
		Thread.sleep(2000);

		// get no.of records available
		obj.getlistofrecords();
		Thread.sleep(2000);

		obj.verifycount1();

		// ------------------------------------------------------------------------//

		obj.getacount();
		Thread.sleep(2000);

		obj.clickAARPbtn();
		Thread.sleep(2000);

		obj.getlistofrecords();

		obj.verifycount1();

		obj.clickDeleteCache();

	}

}
