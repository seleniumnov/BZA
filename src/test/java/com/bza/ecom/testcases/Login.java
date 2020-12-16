package com.bza.ecom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumpracticedec.RedBusHomePage;
import seleniumpracticedec.RedBusResultsPage;

public class Login {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");

		RedBusHomePage homepage = PageFactory.initElements(driver, RedBusHomePage.class);

		homepage.input_from.sendKeys("");

		RedBusResultsPage respage = PageFactory.initElements(driver, RedBusResultsPage.class);

		respage.bustype_nonac.click();

		
		for (WebElement ele : homepage.div_footertexts) {
			if (ele.getText().equals("test")) {
				System.out.println("Global Sites verified");
				break;
			}
		}

		

	}

}
