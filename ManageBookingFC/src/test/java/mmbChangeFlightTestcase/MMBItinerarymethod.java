package mmbChangeFlightTestcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import UtilityFunction.CommonFuntion;
import mmbChangeFlightTestPage.MMBItineraryPage;

public class MMBItinerarymethod extends CommonFuntion {
	Logger logger = Logger.getLogger(MMBItinerarymethod.class);

	@Test
	public void VerifyItinerary() {
		logger.info("Application moved to VerifyItinerary Page ");
		try {
			MMBItineraryPage.getItineraryPage().getcheckbox();
			MMBItineraryPage.getItineraryPage().getconfirmbutton();
			Alert alert = CommonFuntion.getDriver().switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
