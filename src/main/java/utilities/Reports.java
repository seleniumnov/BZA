package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {

	public ExtentReports extent;
	public ExtentTest test;
	public ExtentHtmlReporter htmlreport;
	public WebDriver driver;
	public File des;
	public WebDriverWait wait;
	public SoftAssert soft;

	@BeforeSuite
	public void configReport() {
		soft = new SoftAssert();
		extent = new ExtentReports();
		File file = new File("./Reports/TestReport.html");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		htmlreport = new ExtentHtmlReporter(file);
		htmlreport.config().setDocumentTitle("TesNG Use Case");

		extent.attachReporter(htmlreport);

	}

	@AfterSuite(alwaysRun = true)
	public void prepareReport() {
		extent.flush();
		soft.assertAll();
	}

	@AfterMethod
	public void verifyResults() {
		driver.close();
	}

	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 60);

		driver.manage().window().maximize();
	}

	public void takeScreenShot(String name) {
		System.out.println("the");
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			des = new File("./ScreenShots/" + name + ".png");
			FileHandler.copy(src, des);
		} catch (Exception e) {
		}
	}

	public void attachScreenToReport() {
		try {
			test.pass("", MediaEntityBuilder.createScreenCaptureFromPath(des.getAbsolutePath()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
