package Testcase;

import org.testng.annotations.Test;

import TestPage.MMBFlow;
import UtilityFunction.CommonFuntion;

public class MMBFlowmethod extends CommonFuntion {

	@Test
	public void selectAEBookingmethod() {
		
		MMBFlow.getmmbFlow().BookinActions("Email Reservation and E-Ticket Receipt");
		
	}
	
}
