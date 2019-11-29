package com.phptrvels.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.phptravels.constants.ConstantsFilePaths;
import com.phptravels.utils.LogReports;
import com.phptravels.utils.ReadExcelFile;
import com.phptravels.utils.ReadLocatorsFile;

public class PageActions {

	ReadLocatorsFile read = new ReadLocatorsFile();

	public WebDriver driver;
	ReadExcelFile reader = getsheet(ConstantsFilePaths.TESTDATA_FILE);

	public ReadExcelFile getsheet(String sheetname) {
		ReadExcelFile read = new ReadExcelFile();
		try {
			read.setPath(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}

	public String getdata_fromExcel(String sheetname, String columnname, String rowname) {

		String datavalue = reader.getCellDataByColumnName(sheetname, columnname, rowname);
		return datavalue;
	}

	LogReports log = new LogReports();
	WebElement webElement;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public WebElement selectLocators(String locatorType) {

		String[] locator = locatorType.split(":", 2);

		switch (locator[0]) {
		case "id":
			webElement = driver.findElement(By.id(locator[1]));
			break;
		case "name":
			webElement = driver.findElement(By.name(locator[1]));
			break;
		case "className":
			webElement = driver.findElement(By.className(locator[1]));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(locator[1]));
			break;
		case "partialLinkText":
			webElement = driver.findElement(By.partialLinkText(locator[1]));
			break;
		case "tagName":
			webElement = driver.findElement(By.tagName(locator[1]));
			break;
		case "css":
			// System.out.println(locator[1]);
			webElement = driver.findElement(By.cssSelector(locator[1]));
			break;
		case "xpath":
			webElement = driver.findElement(By.xpath(locator[1]));
			break;

		}
		return webElement;
	}

	public void scroll(String element) {
		webElement = selectLocators(element);
		js.executeScript("window.scrollBy(0,500)");
	}

	public static void performActionEnter(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

}