package Testcase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.MMBChangeFlightAddon;
import UtilityFunction.CommonFuntion;

public class MMBChangeFlightAddonmethod extends CommonFuntion {

	Logger logger=Logger.getLogger(MMBChangeFlightAddonmethod.class);
	@Test
	public void ChangeAddonpage() {
		
		WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(MMBChangeFlightAddon.getMmbChangeFlightAddon().btnContinue));
		logger.info("Application moved to MMBChangeFlight Addon method ");
		try {
			MMBChangeFlightAddon.getMmbChangeFlightAddon().getcontine();
			logger.info("Booking without Addon for MMB Changeflight");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
