package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.DeleteConfigurationElements;

public class DeleteConfiguration extends BaseClass {
	
	public void deleteExistingConfiguration() throws InterruptedException {
		
		ConfigurationElements ce = new ConfigurationElements(driver);
		ce.clickconfigbutton();
		Thread.sleep(3000);
		
		DeleteConfigurationElements dce=new DeleteConfigurationElements(driver);
		dce.serachRecord(auditname);
		
		dce.clickvDots(auditname);
		
		dce.clickDeletebutton();
		
		dce.clickNo();
		
		dce.clickvDots(auditname);
		
		dce.clickDeletebutton();
		
		dce.clickyes();
		
		dce.clearSearch();
		Thread.sleep(2000);
		
		dce.serachRecord(auditname);
		
		dce.verify(auditname, "Test");
				
	}

}
