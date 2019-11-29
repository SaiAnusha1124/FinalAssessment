package com.phptravels.validation;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.phptravels.constants.ConstantsFilePaths;
import com.phptravels.testbase.TestBase;
import com.phptravels.utils.ReadLocatorsFile;
import com.phptrvels.actions.ClickonElementAction;

public class VerifyPhpTravels extends TestBase {
	String expectedhomepage, expectedselectedhotelpage, expecteddestinationplace, expectedcheckindate,
			expectedcheckoutdate, expectedadults, expectedchild,expectedhotelname,expectedhoteaddress,expectedhotelavailablerooms;
	String actualhomepage, actualselectedhotelspage, actualdestinationplace, actualcheckindate, actualcheckoutdate,
			actualadults, actualchild,actualhotelname,actualhoteladdress,actualhptelavailablerooms;
	Properties properties, properties1;
	ClickonElementAction click = new ClickonElementAction();

	@Test
	public void verifyingHomePage() {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);

		actualhomepage = driver.findElement(By.xpath(properties.getProperty("validate.homepage"))).getText();
		ValidationResult.validateData(actualhomepage, properties1.getProperty("expectedhomepage"));
		log.info("Validated HomePage for phptravels ");
	}

	public void verifyingHotelspage() {
		actualselectedhotelspage = driver.findElement(By.cssSelector(properties.getProperty("validate.hotelspage"))).getText();
		ValidationResult.validateData(actualselectedhotelspage, properties1.getProperty("expectedselectedhotelpage"));

	}

	public void verifyingDetailsBeforeModify() {
		actualdestinationplace = driver.findElement(By.xpath(properties.getProperty("validate.destinationplace"))).getText();
		ValidationResult.validateData(actualdestinationplace, properties1.getProperty("expecteddestinationplace"));

		actualcheckindate = driver.findElement(By.cssSelector(properties.getProperty("validate.checkindate"))).getText();
		ValidationResult.validateData(actualcheckindate, properties1.getProperty("expectedcheckindate"));

		actualcheckoutdate = driver.findElement(By.cssSelector(properties.getProperty("loc.click.chekout"))).getText();
		ValidationResult.validateData(actualcheckoutdate, properties1.getProperty("expectedcheckoutdate"));

		actualadults = driver.findElement(By.cssSelector(properties.getProperty("loc.click.adult"))).getText();
		ValidationResult.validateData(actualadults, properties1.getProperty("expectedadults"));

		actualchild = driver.findElement(By.cssSelector(properties.getProperty("loc.click.child"))).getText();
		ValidationResult.validateData(actualchild, properties1.getProperty("expectedchild"));
	}

	public void verifyingHotelDetails() {
		
		actualhotelname = driver.findElement(By.cssSelector(properties.getProperty("validate.hotelname"))).getText();
		ValidationResult.validateData(actualhotelname, properties1.getProperty("expectedhotelname"));
		
		actualhoteladdress = driver.findElement(By.xpath(properties.getProperty("validate.hoteladdress"))).getText();
		ValidationResult.validateData(actualhoteladdress, properties1.getProperty("expectedhoteaddress"));
		
		actualhptelavailablerooms = driver.findElement(By.cssSelector(properties.getProperty("validate.hotelavailablerooms"))).getText();
		ValidationResult.validateData(actualhptelavailablerooms, properties1.getProperty("expectedhotelavailablerooms"));

	}

}
