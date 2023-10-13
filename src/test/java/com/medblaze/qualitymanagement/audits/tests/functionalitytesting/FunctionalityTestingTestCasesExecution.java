package com.medblaze.qualitymanagement.audits.tests.functionalitytesting;

import java.io.IOException;

import org.testng.annotations.Test;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.tests.flowtesting.Login;

public class FunctionalityTestingTestCasesExecution extends BaseClass{
	
	@Test(priority = 1)
	public void LogintoApplication() throws IOException {
		Login obj1 = new Login();
		obj1.test();
	}
	
	@Test(priority = 2)
	public void fieldsTestingofTextfield() throws Throwable {
		ConfigurationFieldsTestingofTextfield obj2= new ConfigurationFieldsTestingofTextfield();
		obj2.configurationFieldsFunctionality();
	}
	
	@Test(priority = 3)
	public void fieldsAvaialabilityinConfiguration() throws InterruptedException, IOException {
		FieldsAvaialableinConfiguration obj3 = new FieldsAvaialableinConfiguration();
		obj3.chechFields();
	}
	
	@Test(priority = 4)
	public void inputTestingofTextfield() throws Throwable {
		InputTestingofTextField obj4 = new InputTestingofTextField();
			obj4.testInputvalues(); 
		}
	}

