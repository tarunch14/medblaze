package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.TargetsConfigurationElements;

public class TargetsConfiguration extends BaseClass {

	public void configureTaget() throws InterruptedException, IOException {

		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		//el.clickaudits();

		TargetsConfigurationElements tce = new TargetsConfigurationElements(driver);

		tce.clickTargets();
		Thread.sleep(2000);

		tce.clickAdd();

		tce.enterUnit("TEST UNIT");

		tce.enterauditName(auditname);

		tce.clickEnable("No");

		tce.selectTargetFrequency("Monthly");

		tce.sendFirstNotification("1", "1", "59");

		Thread.sleep(5000);

		tce.repeatNotofication("1", "1", "57");

		tce.setnoofNotifications("2");

		tce.setnoofAudits("10");

		tce.clickSubmit();

		Thread.sleep(10000);

		tce.clickNotifications();

		tce.verify(auditname);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		tce.deleteConfiguration(auditname);
		
		tce.deleteVerifiaction(auditname);
	}

}
