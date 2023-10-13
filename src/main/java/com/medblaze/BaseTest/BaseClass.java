package com.medblaze.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.google.common.io.Files;
import com.medblaze.utilities.ReadConfig;
import com.medblaze.utilities.utilityMethods;

public class BaseClass {

	public static WebDriver driver;
	JavascriptExecutor js;
	String AuditName;

	public static Logger log = LogManager.getLogger(BaseClass.class);

	static ReadConfig conf = new com.medblaze.utilities.ReadConfig();
	
	public static String auditname;
	public static String username = conf.getUsername();
	public static String password = conf.getPassword();
	public static String baseurl = conf.geturl();
	public static String date1 = conf.getInputdate();
	public static String datep = conf.getVerifydate();
	public static String date3 = conf.getUploaddate();
	public static String approvecomments = conf.getApprovecomments();
	public static String rejectcomments = conf.getRejectcomments();
	public static String bauditname = conf.getBulkAuditname();
	public static String bdate = conf.getBulkdate();
	public static String datec = conf.getCPdate();
	public static String date4 = conf.getverifyCPdate();

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		
		// auditname="svJp00P";

		auditname = utilityMethods.generateRandomString(7);
		System.out.println(auditname);

		if (br.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			log.info("Browser launched");

		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/AJAY/Desktop/Selenium2023/chromedriver-win64/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--remote-allow-origins=*");
			 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(options);
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 */
		} else if (br.equals("ie")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else {
			System.out.println("Browser not found");
		}

		driver.get(baseurl);
		log.info("Getting baseurl");
	}

	@AfterClass
	public void teardown() throws InterruptedException {
	//	driver.quit();
	}

	public void screenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\AJAY\\Desktop\\Selenium2023\\Medblaze Project\\Medblaze\\screenShots\\" + tname + ".png");
		Files.copy(src, destination);
	}

}
