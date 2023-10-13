package com.medblaze.qualitymanagement.audits.tests.functionalitytesting;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.PerformAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.functionalitytesting.fieldtesting.textfield.InputTestingofTextFieldElements;

public class InputTestingofTextField extends BaseClass {

	public void testInputvalues() throws Throwable {

		EditAuditElements el = new EditAuditElements(driver);
		Thread.sleep(3000);
		//el.clickaudits();

		el.clicklist();
		Thread.sleep(3000);

		PerformAuditElements pa = new PerformAuditElements(driver);

		pa.clickPerformAudit();

		pa.enterAuditName(auditname);

		pa.clickSubmit();
		Thread.sleep(2000);

		InputTestingofTextFieldElements itotfe = new InputTestingofTextFieldElements(driver);

		itotfe.verify();

		itotfe.checkclearButton();

	}

}
