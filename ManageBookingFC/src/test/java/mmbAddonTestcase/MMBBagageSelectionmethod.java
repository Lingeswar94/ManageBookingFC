package mmbAddonTestcase;

import org.testng.annotations.Test;

import UtilityFunction.CommonFuntion;
import mmbAddonPage.MMBAddonSelection;

public class MMBBagageSelectionmethod extends CommonFuntion {

	@Test
	public void getBaggageselection() {

		try {
			MMBAddonSelection.getMmbAddonSelection().selectBaggage(1, 1, true, true, true, true,
					"+ 1 Additional 15Kg Piece - Max 15Kg (33.00 AUD)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		MMBAddonSelection.getMmbAddonSelection().btnProceedBooking.click();
	}

}
