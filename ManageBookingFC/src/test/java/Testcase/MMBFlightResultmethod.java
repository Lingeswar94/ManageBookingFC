package Testcase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.MMBFlightresult;
import UtilityFunction.CommonFuntion;
import UtilityFunction.ExcelData;

public class MMBFlightResultmethod extends CommonFuntion {

	Logger logger = Logger.getLogger(MMBFlightResultmethod.class);
	ExcelData excelData = new ExcelData();

	@Test
	public void Flightresult() {
		logger.info("Application moved to MMBCabin Fare Selection ");
		WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(MMBFlightresult.getMmbFlightresult().OBFareselection));

		try {
			MMBFlightresult.getMmbFlightresult().Fareselecting(
					excelData.getStringMMBData("MMBChangeDateSelection", 14, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 15, 1));
			MMBFlightresult.getMmbFlightresult().FlightContiune();
			logger.info("Application has selected Cabin Fare : ");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
