package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ApproveAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ExpandFontElements;



public class ExpandFontsize extends BaseClass {


	public void Expadnandfont() throws InterruptedException, IOException {
		// login
		// Thread.sleep(5000);

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		//Thread.sleep(3000);
		 //el.clickaudits();

		// click on list
		 //el.clicklist();
		 Thread.sleep(2000);

		// click on closed list
		ApproveAuditElements obj = new ApproveAuditElements(driver);
		obj.clickclsdbtn();
		Thread.sleep(20000);

		ExpandFontElements obj1 = new ExpandFontElements(driver);
		obj1.clickFSdd();
		
		obj1.selectfont("4");
		Thread.sleep(5000);
		
		obj1.verify();
		
		obj1.clickFSdd();
		obj1.selectfont("11");

	}

}
