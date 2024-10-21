package UtilityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import TestPage.MMBFlow;
import TestPage.ManageBookingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFuntion {

	public static Properties properties;
	public static WebDriver driver;

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

		loadbrowser();
		if (CommonFuntion.getDriver() == null) {
			if (Constant.Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}else if(Constant.Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if (Constant.Browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				
			} else {
				System.out.println("Application hasn't selected browser");
				
			}
			initelement();
		}

		CommonFuntion.getDriver().navigate().to(Constant.Url);
		CommonFuntion.getDriver().manage().window().maximize();
		CommonFuntion.getDriver().manage().deleteAllCookies();
		
	}
	
	public void initelement() {
		PageFactory.initElements(CommonFuntion.getDriver(), ManageBookingPage.getManageBookingPage());
		PageFactory.initElements(CommonFuntion.getDriver(), MMBFlow.getmmbFlow());
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
