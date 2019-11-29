package com.phptravels.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.phptravels.constants.ConstantsFilePaths;
import com.phptravels.testbase.TestBase;
import com.phptravels.validation.VerifyPhpTravels;
import com.phptrvels.actions.ClickonElementAction;
import com.phptrvels.actions.PageActions;

public class GetUniqueItem extends TestBase {
	Properties properties;
	PageActions page = new PageActions();
	VerifyPhpTravels verify = new VerifyPhpTravels();
	ClickonElementAction click = new ClickonElementAction();
	LogReports log = new LogReports();

	public void selectingUniqueHotel() {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);

		driver.findElement(By.xpath("loc.select.4*ratings")).click();
		List<WebElement> element = driver.findElements(By.xpath("loc.select.uniquehotel"));
		int listvalue = element.size();
		System.out.println(element.size());
		List<String> alist = new ArrayList<String>();

		for (WebElement totalList : element) {
			alist.add(totalList.getText());
		}
		System.out.print(alist);
		List<String> sort = new ArrayList<String>(alist);
		Collections.sort(sort);
		for (int i = 0; i < listvalue; i++) {
			System.out.print(sort.get(i));
		}
		String text = driver.findElement(By.xpath("validate.uniquehote.name")).getText();
		System.out.println(text);
		if (text.equalsIgnoreCase("Gardeenia Comfortes")) {
			page.scroll(properties.getProperty("loc.click.viewmore"));
			click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.viewmore"));
		}
		else {
			click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc.click.details"));
			verify.verifyingHotelDetails();
			verify.verifyingHotelDetails();
		}
	}
}
