package com.medblaze.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlrep;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname="Test-Report"+timestamp+".html";
		htmlrep=new ExtentHtmlReporter("C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\testReport\\reports"+reportname);
		htmlrep.loadConfig("C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlrep);
		extent.setSystemInfo("Host", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Tarun");
		
		htmlrep.config().setDocumentTitle("Medblaze Test Project");
		htmlrep.config().setReportName("Functional Test Report");
		htmlrep.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlrep.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult res) {
		test=extent.createTest(res.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(res.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestSkipped(ITestResult res) {
		test=extent.createTest(res.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(res.getName(), ExtentColor.ORANGE));
	}
	
	public void onTestFailure(ITestResult res) {
		test=extent.createTest(res.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(res.getName(), ExtentColor.RED));
		test.log(Status.FAIL, res.getThrowable());
		System.out.println(res.getName());
		
		String sspath="C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\screenShots\\"+res.getName()+".png";
		File src=new File(sspath);
		
		try {
			if(src.exists()) {
				test.addScreenCaptureFromPath(sspath);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}


