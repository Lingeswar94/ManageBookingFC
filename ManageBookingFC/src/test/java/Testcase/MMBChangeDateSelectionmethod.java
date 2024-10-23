package Testcase;

import org.testng.annotations.Test;

import TestPage.MMBDateChange;

import UtilityFunction.CommonFuntion;

public class MMBChangeDateSelectionmethod extends CommonFuntion {

	@Test
	public void selectAEBookingmethod() {
		
		try {
			MMBDateChange.getmmbdatechange().BookingActions("Change Flight");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			MMBDateChange.getmmbdatechange().getsegmentselection(2, "December", "11", "2024", "December", "19", "2024");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			MMBDateChange.getmmbdatechange().btnContinue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Flight(s) do not operate on the date you have searched.");
		}
	}
}
