package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.ConfigurationElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditAuditElements;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.EditConfigurationElements;

public class EditConfiguration extends BaseClass {
	String before8;
	String before9;
	String after8;
	String after9;

	public void configurationEditing() throws InterruptedException, IOException {
		// login
		// Thread.sleep(3000);

		// click on audits
		EditAuditElements el = new EditAuditElements(driver);
		// el.clickaudits();

		// click on configuration
		ConfigurationElements ce = new ConfigurationElements(driver);
		ce.clickconfigbutton();
		// Thread.sleep(2000);

		EditConfigurationElements ec = new EditConfigurationElements(driver);

		ec.clickSearch(auditname);

		ec.clickViewbutton(auditname);

		ce.selectitemsperpage("10");

		// Thread.sleep(3000);

		before8 = ec.getvalue("8");
		before9 = ec.getvalue("9");

		ce.clickconfigbutton();

		// Thread.sleep(3000);

		ec.clickSearch(auditname);

		ec.clickeditbutton(auditname);

		ce.selectitemsperpage("10");

		Thread.sleep(3000);

		ec.changeOrder("9", "8");

		// Thread.sleep(3000);

		ec.clickSubmit();

		Thread.sleep(10000);

		ec.clickSearch(auditname);

		ec.clickViewbutton(auditname);

		ce.selectitemsperpage("10");

		// Thread.sleep(3000);

		after8 = ec.getvalue("8");
		after9 = ec.getvalue("9");

		if ((before8.equals(after9)) && (before9.equals(after8))) {
			log.info("Edit Configuration Pass!");
			assertTrue(true);

			// System.out.println("Edit Configuration Pass!");
		} else {
			log.info("Edit Configuration Fail!");
			screenshot(driver, "EditAuditConfiguration");
			assertTrue(false);

			// System.out.println("Edit Configuration Fail!");
		}

	}

}
