package com.phptravels.validation;

import org.testng.Assert;
import com.phptravels.utils.LogReports;


public class ValidationResult {
	static LogReports report = new LogReports();

	public static boolean validateData(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("Passed : " + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return true;
		} catch (AssertionError assertionError) {
			report.info("failed : " + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return false;
		}
	}
}
