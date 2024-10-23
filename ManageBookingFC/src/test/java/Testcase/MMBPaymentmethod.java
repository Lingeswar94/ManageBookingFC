package Testcase;

import org.testng.annotations.Test;

import TestPage.MMBPaymentPage;
import UtilityFunction.CommonFuntion;

public class MMBPaymentmethod extends CommonFuntion {

	@Test
	public void getPayment() {

		MMBPaymentPage.getmmbPaymentPage().SelectPayment();
		MMBPaymentPage.getmmbPaymentPage().carddetails("Test", "4111111111111111", "123");
		MMBPaymentPage.getmmbPaymentPage().Expirationyear("2026");
		MMBPaymentPage.getmmbPaymentPage().Billingdataclear();
		MMBPaymentPage.getmmbPaymentPage().Billingdetails("Tamil", "GQ", "25SaiBaba", "Coimbatore", "641001",
				"9876543210");
		MMBPaymentPage.getmmbPaymentPage().selectCountry("India");
		MMBPaymentPage.getmmbPaymentPage().paymentcontinue();

	}
}
