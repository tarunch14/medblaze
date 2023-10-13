package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.PerformAuditElements;

public class PerformAudit extends BaseClass {

	// String date="31-Aug-2023";
	public void AuditPerform() throws InterruptedException, IOException {

		// login

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		// Thread.sleep(3000);
		// el.clickaudits();

		// el.clicklist();
		// Thread.sleep(3000);

		PerformAuditElements pa = new PerformAuditElements(driver);

		pa.clickPerformAudit();

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);

		pa.enterUnitname("TEST UNIT");

		pa.selectDate(date1);

		pa.enteremployeeId("81102");

		pa.enterDepartment("Admin");

		pa.enterReportingmanager("Roopesh");

		pa.clickRadiobutton("Yes");

		// Thread.sleep(3000);

		pa.clickcheckbox("Option 1");

		pa.clickcheckbox("Option 3");

		pa.multiSelectdropdown("Dropdown 1");

		pa.multiSelectdropdown("Dropdown 2");

		pa.enterNumericField("1");

		pa.enterTextArea("Additional information");

		pa.clickDraft();

		pa.goToAuditListPage();
		// Thread.sleep(3000);

		EditAuditElements obj = new EditAuditElements(driver);
		obj.searchAudit(auditname);
		// Thread.sleep(2000);

		pa.verify(auditname, datep);

	}

}
