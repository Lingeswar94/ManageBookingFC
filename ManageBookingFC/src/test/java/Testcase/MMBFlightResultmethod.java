package Testcase;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.MMBFlightresult;
import UtilityFunction.CommonFuntion;

public class MMBFlightResultmethod extends CommonFuntion {

	
	
	
	@Test
	public void Flightresult() {
		
		WebDriverWait wait=new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(MMBFlightresult.getMmbFlightresult().OBFareselection));
		
		MMBFlightresult.getMmbFlightresult().Fareselecting("pro", "pro");
		MMBFlightresult.getMmbFlightresult().FlightContiune();
		
	}
}
