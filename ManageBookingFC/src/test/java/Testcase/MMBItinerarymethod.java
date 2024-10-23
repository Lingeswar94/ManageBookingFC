package Testcase;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import TestPage.MMBItineraryPage;
import UtilityFunction.CommonFuntion;

public class MMBItinerarymethod extends CommonFuntion {

	@Test
	public void VerifyItinerary() {

		MMBItineraryPage.getItineraryPage().getcheckbox();
		MMBItineraryPage.getItineraryPage().getconfirmbutton();
		Alert alert = CommonFuntion.getDriver().switchTo().alert();
		alert.accept();

	}
}
