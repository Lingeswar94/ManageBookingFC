package Testcase;

import org.testng.annotations.Test;

import TestPage.ManageBookingPage;
import UtilityFunction.CommonFuntion;

public class MMBLogin extends CommonFuntion {

	@Test
	public void ManageBooking() {

		ManageBookingPage.bookingPNR.sendKeys("TWDQFW");
		ManageBookingPage.FirstName.sendKeys("TamilKhan");
		ManageBookingPage.LastName.sendKeys("GQ");
		ManageBookingPage.RetreiveDetails.click();
	}
}
