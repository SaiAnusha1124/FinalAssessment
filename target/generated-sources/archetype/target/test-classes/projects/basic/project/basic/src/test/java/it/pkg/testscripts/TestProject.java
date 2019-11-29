package it.pkg.testscripts;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import it.pkg.actions.ClickonElementAction;
import it.pkg.actions.Project_PageActions;
import it.pkg.actions.SendKeysAction;
import it.pkg.constants.ConstantsFilePaths;
import it.pkg.dataproviders.ReadExcelFile;
import it.pkg.testbase.TestBase;
import it.pkg.utils.ReadLocatorsFile;

public class TestProject extends TestBase {
	String browserUrl;
	Properties properties, properties1;
	ClickonElementAction click = new ClickonElementAction();
	SendKeysAction sendkeys = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();
	Project_PageActions page = new Project_PageActions();

	@BeforeClass
	public void launchingUrl() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		browserUrl = properties.getProperty("phptravels_url");
		driver.get(browserUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginHomePage() throws Exception {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		
	}
}
