package com.medblaze.qualitymanagement.audits.tests.flowtesting;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.medblaze.BaseTest.BaseClass;
import com.medblaze.qualitymanagement.audits.tests.functionalitytesting.FieldsAvaialableinConfiguration;
import com.medblaze.qualitymanagement.audits.tests.functionalitytesting.InputTestingofTextField;


public class TestCasesExecution extends BaseClass {

	@Test(priority = 1)
	public void LogintoApplication() throws IOException {
		Login obj1 = new Login();
		obj1.test();
	}

	@Test(priority = 2)
	public void ConfigurenewAudit() throws InterruptedException, IOException {
		AuditConfiguration obj2 = new AuditConfiguration();
		obj2.configurtion();
	}

	@Test(priority = 3)
	public void EditAuditConfiguration() throws InterruptedException, IOException {
		Thread.sleep(5000);
		EditConfiguration obj3 = new EditConfiguration();
		obj3.configurationEditing();
	}

	@Test(priority = 4)
	public void PerformnewAudit() throws InterruptedException, IOException {
		Thread.sleep(5000);
		PerformAudit obj4 = new PerformAudit();
		obj4.AuditPerform();
	}
	
	@Test(priority = 5)
	public void PerformAuditbyCopyPaste() throws InterruptedException, IOException {
		Thread.sleep(5000);
		CopyandPasteAudit obj20 = new CopyandPasteAudit();
		obj20.copyAudit();
	}

	@Test(priority = 6)
	public void EditExistingAudit() throws InterruptedException, IOException {
		
		EditAudit obj5 = new EditAudit();
		obj5.test();
	}
	
	
	@Test(priority = 7)
	public void ApproveAudit() throws Exception {
		Thread.sleep(5000);
		ApproveAudit obj7 = new ApproveAudit();
		obj7.Approve();
	}
	
	@Test(priority = 8)
	public void ReopenClosedAudit() throws InterruptedException, AWTException, IOException {
		Thread.sleep(3000);
		ReopenAudit obj9 = new ReopenAudit();
		obj9.reopen();
	}
	
	@Test(priority = 9)
	public void UploadAuditusingTemplete() throws InterruptedException, AWTException, IOException {
		Thread.sleep(3000);
		UploadAudit obj6 = new UploadAudit();
		obj6.auditUpload();
	}
	
	@Test(priority = 10)
	public void RejectExistingAudit() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		AuditReject obj8 = new AuditReject();
		obj8.Rejectaudit();
	}
	
	@Test(priority = 11)
	public void ApproveandRejectAuditbyBulkaction() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		BulkApprove obj10 = new BulkApprove();
		obj10.approvebulk();
	}
	
	@Test(priority = 12)
	public void DownloadAuditlist() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		DownloadReport obj11 = new DownloadReport();
		obj11.Reportdownload();
	}
	
	@Test(priority = 13)
	public void noofAuditInchargeReviewPendingrecords() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		AuditInchargeReviewPending obj12 = new AuditInchargeReviewPending();
		obj12.Verify_AIRP_Records();
	}
	
	
	@Test(priority = 14)
	public void SearchRecords() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		SerchRecords obj13 = new SerchRecords();
		obj13.search();
	}
	
	@Test(priority = 15)
	public void NavigationbetweenNextandPreviouspage() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		NextAndPreviousPage obj16 = new NextAndPreviousPage();
		obj16.navigation();
	}
	
	@Test(priority = 16)
	public void ApplyColumnFilters() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		ColumnFilters obj14 = new ColumnFilters();
		obj14.columnFilters();
	}
	
	@Test(priority = 17)
	public void ApplyFilters() throws InterruptedException, AWTException, IOException {
		Thread.sleep(20000);
		Filters obj15 = new Filters();
		obj15.applyfilters();
	}
	
	@Test(priority = 18)
	public void CollapseandExpandFontsize() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		ExpandFontsize obj17 = new ExpandFontsize();
		obj17.Expadnandfont();
	}
	
	@Test(priority = 19)
	public void ArrangeColumnFields() throws InterruptedException, AWTException, IOException {
		Thread.sleep(5000);
		ArrangeColumns obj18 = new ArrangeColumns();
		obj18.arrangeColumns();
	}	
	
	@Test(priority = 20)
	public void ConfigureAuditTargets() throws InterruptedException, IOException {
		TargetsConfiguration obj19= new TargetsConfiguration();
		obj19.configureTaget();	
	}
	
	@Test(priority = 21)
	public void DeleteAuditConfiguration() throws InterruptedException {
		DeleteConfiguration obj21= new DeleteConfiguration();
		obj21.deleteExistingConfiguration();  
	}
	
	@Test(priority=22)
	public void textFieldtesting() throws InterruptedException, IOException {
		FieldsAvaialableinConfiguration obj22 = new FieldsAvaialableinConfiguration();
		obj22.chechFields();
	}
	
	@Test(priority =23)
	public void textFieldTestingtwo() throws Throwable {
		InputTestingofTextField obj23 = new InputTestingofTextField();
		obj23.testInputvalues();
	}
		
}
