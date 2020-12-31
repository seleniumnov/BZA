package com.bza.ecom.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utilities.Reports;

public class Login extends Reports {

	
	@Test
	public void googleSearch() {
		
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
