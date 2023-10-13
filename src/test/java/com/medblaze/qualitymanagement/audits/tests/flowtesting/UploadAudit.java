package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.awt.AWTException;
import java.io.IOException;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.UploadAuditElements;


public class UploadAudit extends BaseClass {

	
	public void auditUpload() throws InterruptedException, AWTException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		 el.clickaudits();

		// click on list
		// el.clicklist();
		// Thread.sleep(3000);

		UploadAuditElements uae = new UploadAuditElements(driver);
		Thread.sleep(2000);
		uae.clickperformAUdit();
		Thread.sleep(2000);

		uae.clickcancel();

		Thread.sleep(5000);

		uae.clickperformAUdit();

		uae.clickUpload();

		uae.checkerrormsg();

		uae.enterAuditName(auditname);
		Thread.sleep(2000);

		uae.clickAuditcancel();

		uae.enterAuditName(auditname);
		Thread.sleep(5000);

		uae.clickUpload();

		uae.uploadAudit("C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\src\\main\\java\\com\\medblaze\\Testdata\\testconfig.xlsx");
		Thread.sleep(10000);
		
		el.clickReviewpending();
		Thread.sleep(3000);
		
		uae.clickAIRPbtn();
		Thread.sleep(2000);
		
		uae.searchRecord(auditname);
		Thread.sleep(3000);

		uae.verify(auditname, date3);
		
		driver.navigate().refresh();
	}

}
