#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ${package}.actions.ClickonElementAction;
import ${package}.actions.Project_PageActions;
import ${package}.actions.SendKeysAction;
import ${package}.constants.ConstantsFilePaths;
import ${package}.dataproviders.ReadExcelFile;
import ${package}.testbase.TestBase;
import ${package}.utils.ReadLocatorsFile;

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
