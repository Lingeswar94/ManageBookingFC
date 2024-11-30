package mmbCommon;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageBookingPage {

	private static ManageBookingPage manageBookingPage;

	private ManageBookingPage() {

	}

	public static ManageBookingPage getManageBookingPage() {
		if (manageBookingPage == null) {
			manageBookingPage = new ManageBookingPage();
		}
		return manageBookingPage;
	}
	
	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/input")
	public static List<WebElement> bookingactionitems;

	@FindBy(xpath = "//input[@id='txtPNR']")
	public static WebElement bookingPNR;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	public static WebElement LastName;

	@FindBy(xpath = "//input[@id='btnRetreiveDetails']")
	public static WebElement RetreiveDetails;

	public void BookingPNR(String PNR) {
		bookingPNR.sendKeys(PNR);
	}

	public void Firstname(String firstname) {
		FirstName.sendKeys(firstname);
	}

	public void Lastname(String lastname) {
		LastName.sendKeys(lastname);
	}

	public void RetreiveDetailscontinue() {
		RetreiveDetails.click();
	}
	
	public void BookingActions(String Flowname) {
		try {
			// Avoid index out-of-bound by using < instead of <=
			int size = bookingactionitems.size();
			for (int i = 0; i < size; i++) {
				String AEBookingname = bookingactionitems.get(i).getAttribute("value");
				if (Flowname.equalsIgnoreCase(AEBookingname)) {
					bookingactionitems.get(i).click();
					// After clicking, exit the loop
					return;
				}
			}
			// Call the method to handle the flow after clicking
			// name( index, Month, date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
