package mmbChangeFlightTestcase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import UtilityFunction.CommonFuntion;
import UtilityFunction.ExcelData;
import mmbChangeFlightTestPage.MMBDateChange;

public class MMBChangeDateSelectionmethod extends CommonFuntion {
	ExcelData excelData = new ExcelData();
	Logger logger=Logger.getLogger(MMBChangeDateSelectionmethod.class);
	@Test
	public void selectAEBookingmethod() {
		logger.info("Application moved to BookingActions Selection page ");
		
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
