package mmbAddonTestcase;

import org.testng.annotations.Test;

import UtilityFunction.CommonFuntion;
import mmbAddonPage.MMBAddonPricecheck;

public class MMBAddonPricecheckmethod extends CommonFuntion {

	@Test
	public void getPricecheck() {

		MMBAddonPricecheck.getMmbAddonPricecheck().getConfirmation();
		MMBAddonPricecheck.getMmbAddonPricecheck().getbodycontent_btnConfirm();

	}
}
