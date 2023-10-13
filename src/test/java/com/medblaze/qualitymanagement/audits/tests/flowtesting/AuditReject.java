package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.RejectAuditElements;
import com.medblaze.BaseTest.BaseClass;



public class AuditReject extends BaseClass {

	
	public void Rejectaudit() throws InterruptedException, IOException {
		// login

		// click on audits

		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		
		// el.clickaudits();

		//---- click on list ---

		// el.clicklist();
	//	Thread.sleep(2000);

		//--- click on review pending ---
		el.clickReviewpending();
		 Thread.sleep(3000);

		// click on audit incharge review pending

		ApproveAuditElements obj = new ApproveAuditElements(driver);

		obj.clickAIRPbtn();
		Thread.sleep(2000);

		// approve

		obj.clickapprove(auditname, date3);
		
		obj.entercomments("Approved");
		
		obj.clickyes();
		Thread.sleep(10000);

		// click on audit admin review pending
		
		obj.clcikAARPbtn();
		Thread.sleep(2000);

		// click 3 dots and click reject
		
		RejectAuditElements rae = new RejectAuditElements(driver);
		rae.clickdots(auditname,date3);
		
		rae.clickreject();
		Thread.sleep(2000);
		
		obj.entercomments("Rejected");
		
		rae.clickYes();
		Thread.sleep(5000);
		
		rae.clickRejected1();
		Thread.sleep(7000);
		
		rae.searchRecord(auditname);
		Thread.sleep(2000);
		
		rae.verifyelement(auditname, date3);
		
		driver.navigate().refresh();

	}

}
