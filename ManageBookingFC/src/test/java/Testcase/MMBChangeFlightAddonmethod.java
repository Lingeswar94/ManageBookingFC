package Testcase;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.MMBChangeFlightAddon;
import UtilityFunction.CommonFuntion;

public class MMBChangeFlightAddonmethod extends CommonFuntion {

	@Test
	public void ChangeAddonpage() {
		
		WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(MMBChangeFlightAddon.getMmbChangeFlightAddon().btnContinue));

		try {
			MMBChangeFlightAddon.getMmbChangeFlightAddon().getcontine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
