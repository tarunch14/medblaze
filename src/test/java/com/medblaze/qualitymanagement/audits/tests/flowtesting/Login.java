package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.LoginTestElements;

public class Login extends BaseClass {
	
	public void test() throws IOException {
		
		LoginTestElements lt=new LoginTestElements(driver);
		lt.setUsername(username);
		
		lt.setPassword(password);
		
		lt.loginclick();
				
		if(driver.getTitle().equalsIgnoreCase("Medblaze")) {
			log.info("Login Pass!");
			assertTrue(true);
			
			//System.out.println("Login Pass!");		
		}
		else {
			log.info("Login Fail");
			screenshot(driver, "LogintoApplication");
			assertTrue(false);				
		}		
		
	}

}
