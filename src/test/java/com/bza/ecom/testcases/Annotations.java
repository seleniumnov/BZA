package com.bza.ecom.testcases;

import org.testng.annotations.Test;

import utilities.Reports;

public class Annotations extends Reports {

	@Test
	public void smokecase() {
		System.out.println("actual test case");
	}

	@Test
	public void regcase() {
		System.out.println("actual test case 2");
	}

	

}
