package com.medblaze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public Properties prop;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("File not found :" + e.getMessage());
		}
	}

	public String getUsername() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getPassword() {
		String pswd = prop.getProperty("password");
		return pswd;
	}

	public String geturl() {
		String baseurl = prop.getProperty("baseurl");
		return baseurl;
	}

	public String getAuditname() {
		String audit = prop.getProperty("auditname");
		return audit;
	}

	public String getInputdate() {
		String date = prop.getProperty("auditconfigdate");
		return date;
	}
	
	public  String getVerifydate() {
		String date = prop.getProperty("verifyconfigdate");
		return date;
	}
	
	public  String getUploaddate() {
		String date = prop.getProperty("uploadauditdate");
		return date;
	}

	public String getApprovecomments() {
		String comment = prop.getProperty("approvecomments");
		return comment;
	}
	
	public String getRejectcomments() {
		String comment = prop.getProperty("rejectcomments");
		return comment;
	}
	
	
	public String getBulkAuditname() {
		String baudit=prop.getProperty("bulkauditname");
		return baudit;
	}
	
	public String getBulkdate() {
		String bdate=prop.getProperty("bulkdate");
		return bdate;
	}
	
	public String getCPdate() {
		String cdate=prop.getProperty("verifycopypastedate");
		return cdate;
	}
	
	public String getverifyCPdate() {
		String cdate=prop.getProperty("copypasteauditdate");
		return cdate;
	}

}
