package com.atmecs.testscripts;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.phptravels.constants.ConstantsFilePaths;
import com.phptravels.testbase.TestBase;
import com.phptravels.utils.DateConversion;
import com.phptravels.utils.GetUniqueItem;
import com.phptravels.utils.LocatorType;
import com.phptravels.utils.ReadExcelFile;
import com.phptravels.utils.ReadLocatorsFile;
import com.phptravels.validation.VerifyPhpTravels;
import com.phptrvels.actions.ClickonElementAction;
import com.phptrvels.actions.PageActions;
import com.phptrvels.actions.SendKeysAction;

public class TestPhpTravels extends TestBase {
	String browserUrl;
	String destinationPlace;
	Properties properties, properties1;
	ClickonElementAction click = new ClickonElementAction();
	SendKeysAction sendkey = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();
	VerifyPhpTravels verify = new VerifyPhpTravels();
	DateConversion getDate = new DateConversion();
	PageActions page = new PageActions();
	GetUniqueItem selecthotel = new GetUniqueItem();

	@BeforeClass
	public void launchingUrl() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		browserUrl = properties.getProperty("phptravels_url");
		driver.get(browserUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("static-access")
	@Test
	public void selectingHotel() throws Exception {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		log.info("Opened phpTravels url");
		verify.verifyingHomePage();
		log.info("Validated phpTravels");
		sendkey.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc.sendkeys.destination"), "Bangalore");
		page.performActionEnter(driver);
		getDate.dateGeneration();
		log.info("Date clicked on after 10 days ");
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.chekout"));
		for (int i = 0; i >= 4; i++) {
			click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.adult"));
		}
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.child"));
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.search"));
		verify.verifyingHotelspage();
		log.info("Successfully validated hotels page");
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.modify"));
		verify.verifyingDetailsBeforeModify();		
		selecthotel.selectingUniqueHotel();
	}
}


