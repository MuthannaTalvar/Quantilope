package pages;

import java.util.List;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utils.Utility;

public class Home_Page {

	WebDriver driver;

	By SatrtButton = By.xpath("//button[@id='startSurvey']");
	By BarGraphValue = By.xpath("(//*[@class='highcharts-text-outline'])[4]");
	By PieChartValue = By.xpath("(//*[@class='highcharts-text-outline'])[10]");
	By GraphValue = By.xpath("(//*[@class='highcharts-text-outline'])[6]");
	By YellowOption = By.xpath("(//div[@class='qRadioDisplay'])[1]");
	By Textbox = By.xpath("//input[@placeholder='Type in your value']");
	By Rating = By.xpath("(//div[@class='qRadioDisplay'])[4]");
	By NextButton = By.xpath("//button[@id='nextPage']");

	String bgValue = "";
	String pcValue = "";
	String gValue = "";

	/**
	 * This Constructor is used to set the Web driver reference to the class
	 * 'Privacy_Page'
	 * 
	 * @param tempDriver
	 */
	public Home_Page(WebDriver tempDriver) {
		this.driver = tempDriver;
	}

	public void BarGraphValue() {
		bgValue = Utility.gettext(driver, BarGraphValue);
	}

	public void PieChartValue() {
		pcValue = Utility.gettext(driver, PieChartValue);
	}

	public void GraphValue() {
		gValue = Utility.gettext(driver, GraphValue);
	}

	public void SelectCheesecolor() {
		Utility.clickAction(driver, SatrtButton);
		Utility.wait(3);
		Utility.clickAction(driver, YellowOption);
		Utility.wait(3);
		Utility.clickAction(driver, NextButton);
		Utility.wait(3);
	}

	public void EnterValue() {
		Utility.sendKeysAction(driver, Textbox, "10");
		Utility.wait(3);
		Utility.clickAction(driver, NextButton);
		Utility.wait(3);
	}

	public void SelectRating() {
		Utility.clickAction(driver, Rating);
		Utility.wait(2);
		Utility.clickAction(driver, NextButton);
		Utility.wait(3);
	}

	public void VerifyBarGraphValue() {
		if (!Utility.gettext(driver, BarGraphValue).equals(bgValue)) {
			System.out.println("Value in bar graph is updated");
		} else {
			System.out.println("Value in bar graph is not updated");
		}
	}

	public void VerifyPieChartValue() {
		if (!Utility.gettext(driver, PieChartValue).equals(pcValue)) {
			System.out.println("Value in pie chart is updated");
		} else {
			System.out.println("Value in pie chart is not updated");
		}
	}

	public void VerifyGraphValue() {
		if (!Utility.gettext(driver, GraphValue).equals(gValue)) {
			System.out.println("Value in graph is updated");
		} else {
			System.out.println("Value in graph is not updated");
		}
	}

}
