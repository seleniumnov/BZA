package com.bza.ecom.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Reports;

public class Facebook extends Reports {

	public void waitforsec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void handleDropDowns() {

		test = extent.createTest("Google Search");

		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='birthday_month']")));

		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));

		Select select = new Select(month);

		waitforsec();

		select.selectByVisibleText("Jan");

		waitforsec();

		WebElement selectedopt = select.getFirstSelectedOption();

		System.out.println(selectedopt.getText());

		soft.assertEquals(selectedopt.getText(), "Jan1");

		System.out.println("Next Line of code");

		List<WebElement> opts = select.getOptions();
		boolean status = false;
		for (WebElement ele : opts) {
			if (ele.getText().trim().equals("Feb")) {

				ele.click();
				status = true;
				break;
			}
		}

		if (status) {
			System.out.println("Feb is available in drop down");
		}else {
			Assert.fail("feb is not available in list");
		}
		
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		
		List<WebElement> ope = driver.findElements(By.xpath("//ul[@role='listbox']/li/a"));
		
		for(int i=1; i<=ope.size();i++) {
			
			WebElement ele = driver.findElement(By.xpath("//ul[@role='listbox']/li["+i+"]/a"));
			
			if(ele.getText().equals("2018")) {
				
				ele.click();
				
				break;
			}
		}
		

	}

}
