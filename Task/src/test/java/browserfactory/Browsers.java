package browserfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	WebDriver driver;

	/**
	 * This Method is used to select on which platform and browser to run
	 * scripts and also we are returning respective driver form this method
	 * 
	 * @param browser
	 * @param Rval
	 * @return WebDriver
	 */
	public WebDriver startBrowser(String browser, String testName) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "FIREFOX":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Browser name provided is " + browser + ". And it doesn't seems to be correct...");
			System.out.println("So not proceeding further, shutting down the JVM !!!");
			System.exit(0);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * This Method is used to close the active driver instance
	 */
	public void killDriverInstance() {
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe");
		} catch (Exception e) {
			System.out.println("ChromeDriver instance already killed");
		}
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM geckodriver.exe");
		} catch (Exception e) {
			System.out.println("GeckoDriver instance already killed");
		}
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM IEDriverServer.exe");
		} catch (Exception e) {
			System.out.println("IEDriverServer instance already killed");
		}
	}
}
