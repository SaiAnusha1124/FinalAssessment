#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ${package}.helpers.LocatorType;

public class ClickonElementAction {
	/*
	 * In this class,Click on Element Actions performed
	 */
	public void clickElement(WebDriver driver, LocatorType locator, String locatorValue) {

		switch (locator) {
		case CLASSNAME:
			driver.findElement(By.className(locatorValue)).click();
			break;

		case CSSSELECTOR:
			driver.findElement(By.cssSelector(locatorValue)).click();
			break;

		case ID:
			driver.findElement(By.id(locatorValue)).click();
			break;

		case LINKTEXT:
			driver.findElement(By.linkText(locatorValue)).click();
			break;

		case NAME:
			driver.findElement(By.name(locatorValue)).click();
			break;

		case PARTIALLINKTEXT:
			driver.findElement(By.partialLinkText(locatorValue)).click();
			break;

		case TAGNAME:
			driver.findElement(By.tagName(locatorValue)).click();
			break;

		case XPATH:
			driver.findElement(By.xpath(locatorValue)).click();
			break;

		default:
			break;
		}

	}
}
