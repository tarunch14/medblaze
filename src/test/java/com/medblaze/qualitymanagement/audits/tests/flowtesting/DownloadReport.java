package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.DownloadReportElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;

public class DownloadReport extends BaseClass {
	
	String typeofreport="Rejected";

	
	public void Reportdownload() throws InterruptedException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		// el.clickaudits();

		// click on list
		// el.clickReviewpending();;
		// Thread.sleep(3000);
		
		DownloadReportElements obj=new DownloadReportElements(driver);
		obj.clickdownload(typeofreport);
		
		BaseClass.log.info("Download Report Pass!");
		
		//System.out.println("Download Report PAss!");

	}

}
