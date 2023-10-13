package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.BulkApproveElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.BaseTest.BaseClass;



public class BulkApprove extends BaseClass {

	
	public void approvebulk() throws InterruptedException, IOException {
		// login

		// click on audits
		 EditAuditElements el = new EditAuditElements(driver);
	//	 Thread.sleep(3000);
	//	 el.clickaudits();

		// click on list
		 el.clicklist();
		Thread.sleep(3000);

		// click on audit incharge review pending
		 el.clickReviewpending();
		 Thread.sleep(2000);

		ApproveAuditElements obj = new ApproveAuditElements(driver);
		obj.clickAIRPbtn();
		Thread.sleep(3000);

		BulkApproveElements tel = new BulkApproveElements(driver);

		tel.clickbulkbtn();
		
		tel.clickBulkapprovebtn();
		
		tel.selectkaudits(bauditname, bdate);
		
		tel.clickbulkaprbtn();
		
		tel.entercomments(approvecomments);
		
		tel.clickyes();
		Thread.sleep(5000);

		obj.clcikAARPbtn();
		Thread.sleep(3000);
		
		tel.clickbulkbtn();
		
		tel.clickbulkreject();
		
		tel.selectkaudits(bauditname, bdate);
		
		tel.clickrej();
		
		tel.clickNo();
		
		tel.clickrej();
		
		tel.entercomments(rejectcomments);
		
		tel.clickyes();
		Thread.sleep(5000);
		
		// verify rejected records
		tel.verifyrejlist(bauditname, bdate);

	}

}
