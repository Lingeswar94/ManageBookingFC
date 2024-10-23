package Testcase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import TestPage.MMBDateChange;

import UtilityFunction.CommonFuntion;
import UtilityFunction.ExcelData;

public class MMBChangeDateSelectionmethod extends CommonFuntion {
	ExcelData excelData = new ExcelData();
	Logger logger=Logger.getLogger(MMBChangeDateSelectionmethod.class);
	@Test
	public void selectAEBookingmethod() {
		logger.info("Application moved to BookingActions Selection page ");
		try {
			MMBDateChange.getmmbdatechange().BookingActions(excelData.getStringMMBData("MMBChangeDateSelection", 1, 1));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			logger.info("Application moved to Changedate Selection page ");
			MMBDateChange.getmmbdatechange().getsegmentselection(excelData.getStringMMBData("MMBChangeDateSelection", 4, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 5, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 6, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 7, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 8, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 9, 1),
					excelData.getStringMMBData("MMBChangeDateSelection", 10, 1));
			logger.info("Given Change date Scenario  ");
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Flight(s) do not operate on the date you have searched.");
		}
		try {
			MMBDateChange.getmmbdatechange().btnContinue();
		} catch (Exception e) {
			logger.error(e.getMessage());
			//logger.error("Flight(s) do not operate on the date you have searched.");
		}
	}
}
