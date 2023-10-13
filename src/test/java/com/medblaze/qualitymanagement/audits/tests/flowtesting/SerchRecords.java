package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;
import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.SearchRecordsElements;


public class SerchRecords extends BaseClass {


	public void search() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);
		// click on Audits
		// Thread.sleep(2000);
		
		// el.clickaudits();
		
		// click on List
		// el.clicklist();
		
		//el.clickReviewpending();
		Thread.sleep(3000);

		// click on search and wait 3sec
		SearchRecordsElements se = new SearchRecordsElements(driver);
		se.clicksearch("Neonatal Checklist");
		Thread.sleep(3000);
		
		se.find_records("Neonatal Checklist");
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
	}

}
