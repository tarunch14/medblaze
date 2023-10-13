package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.NavigationElements;


public class NextAndPreviousPage extends BaseClass {
	
	public void navigation() throws InterruptedException, IOException {
		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		// el.clickaudits();

		// click on list
		// el.clicklist();
		//Thread.sleep(2000);

		// click on review pending
		el.clickReviewpending();
		Thread.sleep(3000);

		NavigationElements ne = new NavigationElements(driver);
		ne.action();
		ne.verify();

	}
}
