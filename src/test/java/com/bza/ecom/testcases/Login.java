package com.bza.ecom.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.RedBusHomePage;
import pageobjects.RedBusResultsPage;

public class Login {

	ExtentReports extent;
	ExtentTest test;
	ExtentHtmlReporter htmlreport;
	WebDriver driver;
	File des;
//Jagguu
	@BeforeSuite
	public void configReport() {
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

	@AfterSuite
	public void prepareReport() {
		extent.flush();
	}

	@AfterMethod
	public void verifyResults() {
		driver.close();
	}

	public void takeScreenShot(String name) {
		System.out.println("the");
		//this jus a test to check git
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

	@Test
	public void googleSearch() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		test = extent.createTest("Google Search");

		driver.get("https://www.google.com/");

		takeScreenShot("Home Page");

		attachScreenToReport();

		test.log(Status.INFO, "Navigate to Google Home Page");

		driver.findElement(By.name("q")).sendKeys("Extent Reports");

		test.log(Status.INFO, "Extent Reports suggession will be displayed");

		takeScreenShot("Search Results");

		attachScreenToReport();

	}

}
