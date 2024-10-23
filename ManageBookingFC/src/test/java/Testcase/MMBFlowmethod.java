package Testcase;

import org.testng.annotations.Test;

import TestPage.MMBFlow;
import UtilityFunction.CommonFuntion;

public class MMBFlowmethod extends CommonFuntion {

	@Test
	public void selectAEBookingmethod() {
		
		try {
			MMBFlow.getmmbFlow().BookingActions("Change Flight");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			MMBFlow.getmmbFlow().getsegmentselection(2, "December", "11", "2024", "December", "24", "2024");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			MMBFlow.getmmbFlow().btnContinue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Flight(s) do not operate on the date you have searched.");
		}
	}
}
