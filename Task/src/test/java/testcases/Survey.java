package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserfactory.Browsers;
import pages.Home_Page;
import utils.Utility;

public class Survey {

	WebDriver driver;
	Browsers fc = new Browsers();
	Utility utility = new Utility();
	String url1 = "https://app.quantilope.com/share/eeTNRb6FmPQh48Cei?type=dashboard";
	String url2 = "https://survey.quantilope.com/SfidqfGjdrvMzwzWK/PREDqERmTayiEdFq2/9xednGW4bJAGd7sv2";
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "testName" })
	public synchronized void testSetup(String browser, String testName, Method method) {
		driver = fc.startBrowser(browser, testName);
		driver.get("url1");
		Utility.wait(15);
	}

	/**
	 * In Test Method annotation we are verifying that User CAn Generate Login
	 * Credentials And See Error Validations(LLCARES-T173)
	 * 
	 * @throws IOException
	 */

	@Test(groups = { "Regression" })
	public void RegressionTest() throws IOException {

		Home_Page oHome_Page = new Home_Page(driver);

	
		oHome_Page.BarGraphValue();
		oHome_Page.PieChartValue();
		oHome_Page.GraphValue();

		driver.navigate().to(url2);
		Utility.wait(30);
		oHome_Page.SelectCheesecolor();
		oHome_Page.EnterValue();
		oHome_Page.SelectRating();
		driver.navigate().to("url1");
		Utility.wait(30);
		oHome_Page.VerifyBarGraphValue();
		oHome_Page.VerifyPieChartValue();
		oHome_Page.VerifyGraphValue();

	}

	
	@AfterMethod(alwaysRun = true)
	public void closebrowser(ITestResult result) {
		driver.close();
	}
}
