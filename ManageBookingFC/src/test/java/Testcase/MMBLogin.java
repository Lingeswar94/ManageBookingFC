package Testcase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import TestPage.ManageBookingPage;
import UtilityFunction.CommonFuntion;
import UtilityFunction.ExcelData;

public class MMBLogin extends CommonFuntion {
	ExcelData excelData=new ExcelData();
	Logger logger=Logger.getLogger(MMBLogin.class);
	@Test
	public void ManageBooking() {

		logger.info("Application Enter the MMBLogin Page");
		
		try {
			String bookingPNR = excelData.getStringMMBData("MMBLogin", 1, 1);
		ManageBookingPage.bookingPNR.sendKeys(bookingPNR);
		ManageBookingPage.FirstName.sendKeys(excelData.getStringMMBData("MMBLogin", 2, 1));
		ManageBookingPage.LastName.sendKeys(excelData.getStringMMBData("MMBLogin", 3, 1));
		ManageBookingPage.RetreiveDetails.click();
		logger.info("Application successfully login with BookingPNR :"+bookingPNR);
	}
		catch(Exception e) {
			logger.error(e.getMessage());
			}
		}
}
