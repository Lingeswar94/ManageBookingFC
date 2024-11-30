package mmbCommon;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.testng.TestNG;
import org.testng.annotations.Test;

import UtilityFunction.CommonFuntion;
import UtilityFunction.ExcelData;


public class MMBLogin extends CommonFuntion {
	ExcelData excelData = new ExcelData();
	Logger logger = Logger.getLogger(MMBLogin.class);

	@Test
	public void ManageFunction() {

		logger.info("Application Enter the MMBLogin Page");

		try {
			String bookingPNR = excelData.getStringMMBData("MMBLogin", 1, 1);
			ManageBookingPage.bookingPNR.sendKeys(bookingPNR);
			ManageBookingPage.FirstName.sendKeys(excelData.getStringMMBData("MMBLogin", 2, 1));
			ManageBookingPage.LastName.sendKeys(excelData.getStringMMBData("MMBLogin", 3, 1));
			ManageBookingPage.RetreiveDetails.click();
			logger.info("Application successfully login with BookingPNR :" + bookingPNR);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	

	
		try

		{
			ManageBookingPage.getManageBookingPage()
					.BookingActions(excelData.getStringMMBData("MMBChangeDateSelection", 1, 1));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
