package Testcase;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.MMBPaymentPage;
import UtilityFunction.CommonFuntion;

public class MMBPaymentmethod extends CommonFuntion {

	@Test
	public void getPayment() {
		WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(MMBPaymentPage.getmmbPaymentPage().CCpayment));
		try {
			
			MMBPaymentPage.getmmbPaymentPage().SelectPayment();
			wait.until(ExpectedConditions.visibilityOf(MMBPaymentPage.getmmbPaymentPage().Paymentcardname));
			MMBPaymentPage.getmmbPaymentPage().carddetails("Test", "4111111111111111", "123");
			MMBPaymentPage.getmmbPaymentPage().Expirationyear("2026");
			MMBPaymentPage.getmmbPaymentPage().Billingdataclear();
			MMBPaymentPage.getmmbPaymentPage().Billingdetails("Tamil", "GQ", "25SaiBaba", "Coimbatore", "641001",
					"9876543210");
			MMBPaymentPage.getmmbPaymentPage().selectCountry("India");
			MMBPaymentPage.getmmbPaymentPage().paymentcontinue();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
