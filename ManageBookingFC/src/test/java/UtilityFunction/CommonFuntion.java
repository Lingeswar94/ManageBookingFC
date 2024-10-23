package UtilityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TestPage.MMBChangeFlightAddon;
import TestPage.MMBDateChange;
import TestPage.MMBFlightresult;

import TestPage.MMBItineraryPage;
import TestPage.MMBPaymentPage;
import TestPage.ManageBookingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFuntion {

	public static Properties properties;
	public static WebDriver driver;
	public static ExcelData excelData;

	Logger logger = Logger.getLogger(CommonFuntion.class);

	public static Properties loadbrowser() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/test/resources/Config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	@BeforeSuite
	public void SelectManage() {

		PropertyConfigurator.configure("./src/test/resources/Config/Log4j.properties");
		logger.info("Application Start for MMB ManageBooking Flow :");
		loadbrowser();
		logger.info("Application moved to Selecting Browser for execute ");
		if (CommonFuntion.getDriver() == null) {
			if (Constant.Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				logger.info("Application has selected :" + Constant.Browser);
				driver = new ChromeDriver();
			} else if (Constant.Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.firefoxdriver().setup();
				logger.info("Application has selected :" + Constant.Browser);
				driver = new FirefoxDriver();
			} else if (Constant.Browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				logger.info("Application has selected :" + Constant.Browser);
				driver = new InternetExplorerDriver();

			} else {
				logger.info("Application hasn't selected browser");

			}
			initelement();
		}

		CommonFuntion.getDriver().navigate().to(Constant.Url);
		CommonFuntion.getDriver().manage().window().maximize();
		CommonFuntion.getDriver().manage().deleteAllCookies();
		CommonFuntion.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void initelement() {
		PageFactory.initElements(CommonFuntion.getDriver(), ManageBookingPage.getManageBookingPage());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBDateChange.getmmbdatechange());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBFlightresult.getMmbFlightresult());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBChangeFlightAddon.getMmbChangeFlightAddon());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBItineraryPage.getItineraryPage());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBPaymentPage.getmmbPaymentPage());
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterSuite
	public void tearDownReport() {

		CommonFuntion.getDriver().quit();
		logger.info("MMB booking was successfully executed ");

	}

}
