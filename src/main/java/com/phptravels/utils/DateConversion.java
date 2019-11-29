package com.phptravels.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.Keys;

import com.phptravels.constants.ConstantsFilePaths;
import com.phptravels.testbase.TestBase;
import com.phptrvels.actions.ClickonElementAction;
import com.phptrvels.actions.SendKeysAction;

public class DateConversion extends TestBase {
	String days;
	Properties properties;
	ClickonElementAction click = new ClickonElementAction();
	SendKeysAction sendkey = new SendKeysAction();

	public void dateGeneration() throws Exception {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String userDate = (dateformat.format(now));
		System.out.println("User given Date: " + userDate);
		Calendar getDate = Calendar.getInstance();
		SimpleDateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyy");
		getDate.setTime(dateformat1.parse(userDate));
		getDate.add(Calendar.DATE, 10);
		String newDate = dateformat1.format(getDate.getTime());
		System.out.println("Generated Date: " + newDate);
		Thread.sleep(2000);
		sendkey.sendKeys(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.checkin"), "09-12-2019");
		sendkey.sendKeys(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.chekout"), "11-12-2019");
	}
}
