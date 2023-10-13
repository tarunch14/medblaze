package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import org.testng.annotations.Test;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.pageobjects.flowtesting.HospitalStatsElements;



public class HospitalStats extends BaseClass {
	
	@Test
	public void submitstats() throws InterruptedException {	
		
		
		String[] unit= {"Test", "CARE Vizag Ramnagar", "CARE Vizag Maharanipeta", "CARE Nampally","CARE Raipur", "CARE Bhubaneswar", "CARE Banjara IP", "COPC", "CARE Clinic Srinagar", "CARE Pune", "CARE Secunderabad", "CARE Musheerabad", "CARE Nagpur", "CARE Hitech", "CARE Malakpet", "CARE CHL", "CARE United CIIGMA Hospital", "CARE CIIGMA Nursing Home", "CARE United CIIGMA Nursing Home"};
		String[] cashdischarge= {"0", };
		String[] creditdischarge= {"0", };
		String[] deaths= {"0",};
		String[] admissions= {"2", };
		String[] opcount= {"0",};
		
		int unitsize=unit.length;
		
		/*
		 * for(int i=0;i<unitsize;i++) {
		 * 
		 * 
		 * }
		 */
	   
		HospitalStatsElements hse= new HospitalStatsElements(driver);
		
		Thread.sleep(5000);
		
		hse.clickhospitalstatbtn();
		
		hse.clicksubmission();
		
		//------------   loop   -----------
		
		hse.enterunitname("Test");
		Thread.sleep(2000);
		
		hse.clickunit("Test");
		
		hse.enterstatistics("Integration Statistics");
		Thread.sleep(2000);
		
		hse.clickstatistics("Integration Statistics");
		Thread.sleep(2000);
		
		hse.clickcalendericon();
		
		hse.selectdate();
		Thread.sleep(2000);
		
		hse.clicksubmit();
		
		Thread.sleep(3000);
		
		hse.entercashdischarges("0");
		
		hse.enterCreditdischarges("0");
		
		hse.enterdeaths("0");
		
		hse.enteradmissions("2");
		
		hse.enteropcount("0");
		
		//hse.enterinpatientdays("");
		
		//hse.clickrecordsubmit();
		
	}

}
